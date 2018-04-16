package com.nyeong.util;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Date;

/**
 * Title:  HeadpUtil
 * Description: 头像处理工具
 *
 * @date: 2017/9/28 下午8:47
 * @author: quinn_norris
 * @version: 1.0
 */
public class HeadpUtil {

    /**
     * 将参数file中文件存入filePath文件下返回jsp中引用路径
     *
     * @param file springMVC自带文件传输类，通过transferTo方法存入文件中
     * @return 返回一个能够在jsp页面中正常使用的路径写法
     */
    public static String insertHeadp(MultipartFile file, String filePath) {
        String fileStr = "";
        if (!file.isEmpty()) {
            try {
                String[] filetype = file.getContentType().split("/");
                String fileName = DateUtil.continueDateFormat(new Date()) + "." + filetype[1];
                File targetFile = new File(filePath, fileName);
                fileStr = "/headp/" + fileName;
                file.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileStr;
    }

    /**
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     *
     * @param imgFilePath 图片文件路径
     * @return 返回Base64编码过的字节数组字符串
     */
    public static String GetImageStr(String imgFilePath) {
        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * 对字节数组字符串进行Base64解码并生成图片
     *
     * @param imgStr 图像数据
     * @param imgFilePath 图像文件路径
     * @return 返回是否成功
     */
    public static boolean GenerateImage(String imgStr, String imgFilePath) {
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
