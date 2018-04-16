# Travel

## 项目约定规范


1. 不使用Valid，保证Entity的简便性
2. 使用GetMapping，PostMapping等代替RequestMapping
3. 用AOP概念，进行必须的前置测试
4. 告警使用log4j排查问题
5. 数据库字段和entity字段必须相同，保持数据的一致性，避免使用Result反复修改结果集
6. 每个Entity都需要加toString方法，便于出现问题时打印排查
7. 如果出现多表联合查询，使用entityVo，禁止在entity中直接添加属性
8. 多项数据库操作前，必须在service方法前使用Transactional确保事务能够回滚
9. RESTful 写文档