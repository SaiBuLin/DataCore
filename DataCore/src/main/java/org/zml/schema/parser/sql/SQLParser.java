package org.zml.schema.parser.sql;
import java.util.List;
import java.util.Map;

import org.zml.data.DataServiceTools;
import org.zml.data.FieldInfo;
import org.zml.data.SQLParameter;
import org.zml.data.SQLString;
import org.zml.data.dataset.bind.NetDataSet;
import org.zml.form.bind.ConditionSection;
import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Field;
import org.zml.schema.bind.Service;
import org.zml.tools.xml.parser.CTXMLElement;

/**
 * 
 * 
00  完全成功完成        	 	 表 3
01  警告                            		表 4
02  无数据                       		表 5
07  动态 SQL 错误  	 	表 6
08 连接异常				表 7
09  触发操作异常			表 8
0A 功能部件不受支持		表 9
0D 目标类型规范无效		表 10
0F 无效标记			表 11
0K RESIGNAL 语句无效	表 12
20   找不到 CASE 语句的条件	表 13
21   基数违例			表 14
22  数据异常				表 15
23 约束违例				表 16
24 无效游标状态			表 17
25 无效事务状态			表 18
26 无效 SQL 语句标识		表 19
28 无效权限规范			表 21
2D 无效事务终止			表 22
2E 无效连接名			表 23
34 无效游标名			表 24
36 游标灵敏度异常			表 25
38 外部函数异常			表 26
39 外部函数调用异常		表 27
3B SAVEPOINT 无效		表 28
40 事务回滚				表 29
42 语法错误或存取规则违例	表 30
44 WITH CHECK OPTION 违例	表 31
46 Java DDL			表 32
51 无效应用程序状态		表 33
53 无效操作数或不一致的规范	表 34
54	超出 SQL 限制，或超出产品限制	表 35
55	对象不处于先决条件状态		表 36
56	其它 SQL 或产品错误	表 37
57	资源不可用或操作员干预	表 38
58	系统错误			表 39

类代码 00 完全成功完成

SQLSTATE 值  
含义
00000 操作执行成功，并且未产生任何类型的警告或异常情况。

SQLSTATE 值
  
含义
01002
发生 DISCONNECT 错误。
01003
从列函数的自变量消去 NULL 值。
01004
字符串值在指定给具有较短长度的另一字符串数据类型时被截断。
01005
SQLDA 中的条目数不够。
01007
未授予特权。
0100C
从过程返回了一个或多个特殊结果集。
0100D
关闭的游标已在链中的下一个结果集上重新打开。
0100E
生成的过程大于允许的最大结果集数目。只有第一个整数结果集已经返回到调用者。
01503
结果列数比提供的主机变量数大。
01504
UPDATE 或 DELETE 语句不包括 WHERE 子句。
01506
对 DATE 或 TIMESTAMP 值进行了调整，以更正算术运算得出的无效日期。
01509
由于用户虚拟机中的存储器不够，取消游标的分块。
01515
已为主机变量指定了一个空值，因为列的非空值不在主机变量的范围之内。
01516
已忽略不可用的 WITH GRANT OPTION。
01517
用替代字符替换不能转换的字符。
01519
已为主机变量指定了一个空值，因为数字值超出范围。
01524
列函数的结果不包括由算术表达式求值得出的空值。
01526
隔离级别已升级。
01527
SET 语句引用的专用寄存器在 AS 上不存在。
01539
连接成功但只应使用 SBCS 字符。
01543
已忽略重复约束。
01545
未限定列名已解释为相关引用。
01550
索引未创建，因为具有指定描述的索引已经存在。
01560
忽略了一个冗余的 GRANT。
01562
在数据库配置文件中的新日志路径（newlogpth）无效。
01563
日志文件的当前路径（logpath）无效。日志文件路径被复位为缺省值。
01564
已为主机变量指定了空值，因为发生了被零除的错误。
01586
将引用结构中父表的约束设置为 OFF 已导致一个或多个派生表被自动置为检查暂挂状态
01589
语句包含有冗余规范。
01592
在引用 SOURCE 函数的 CREATE FUNCTION 语句中，或：

输入参数的长度、精度或小数位大于源函数相应参数的长度、精度或小数位；或
RETURNS 或 CAST FROM 参数的长度、精度或小数位比源函数的小；或
CREATE FUNCTION 语句中的 CAST FROM 参数的长度、精度或小数位比 RETURNS 参数的大。

运行期间可能发生截断（那时可能会引起错误）。
01594
对于所有信息，SQLDA 内的条目数不够多（即没有足够的描述符返回相异名称）。
01595
该视图已替换现有无效视图。
01596
没有为基于长串数据类型的单值类型创建比较函数。
01598
尝试激活活动的事件监视器，或尝试释放不活动的事件监视器。
01599
忽略 REBIND 上的绑定选项。
01602
优化级别已降低。
01603
CHECK DATA 处理过程中发现约束违例，已将其移至异常表。
01604
已经说明了 SQL 语句，但是未执行它。
01605
递归公共表表达式可能包含无限循环。
01606
节点或系统数据库目录是空的。
01607
只读事务中节点的时间差超过定义的阈值。
01609
生成的过程大于允许的最大结果集数目。只有第一个整数结果集已经返回到调用者。
01610
从过程返回了一个或多个特殊结果集。
01611
关闭的游标已在链中的下一个结果集上重新打开。
01614
定位器数小于结果集数。
01616
估计的 CPU 成本超出了资源限制。
01618
再分发节点组是更改数据分区所必需的。
01620
UNION ALL 的某些基本表可能是同一个表。
01621
检索到的 LOB 值可能已更改。
01622
语句成功完成，但在语句完成之后发生了系统错误。
01623
忽略 DEGREE 的值。
01625
模式名在 CURRENT PATH 中出现了多次。
01626
数据库仅有一个活动的缓冲池。
01627
DATALINK 值可能无效，因为该表处理协调暂挂或协调不可能的状态。
01632
并发连接数超出了该产品的定义授权。
01633
可能不能使用具体查询表来优化查询的处理。
01636
数据库管理器一直未验证非增量数据的完整性。
01637
未启用调试。
01639
联合对象可能需要调用者具有对数据源对象的必要特权。
01641
Datalink 类型属性限制结构化类型的使用。
01642
对于最大的可能 USER 缺省值，列不足够长。
01643
对 SQL 例程中 SQLSTATE 或 SQLCODE 变量的赋值可能会被覆盖，不会激活任何处理程序。
01645
SQL 过程的可执行文件未保存在数据库目录中。
01648
忽略了 COMPRESS 列属性，因为对表取消激活了 VALUE COMPRESSION。
01649
缓冲池操作已经完成，但是直到下一次数据库重新启动才会生效。
01650
索引和表统计信息不一致。
01651
成功激活了事件监视器，但是某些监视信息可能丢失了。
01652
由于语句上下文而忽略了隔离子句。
01653
权限授予给 USER。因为权限名大于 8 个字节，所以不考虑组。
01654
未启动缓冲池。
01655
成功创建了事件监视器，但是至少有一个事件监视器目标表已存在。
01657
缓冲池操作在下一次数据库重新启动后才会生效。
01665
列名或参数名被截断。
01667
可能不能使用视图来优化查询的处理。
01669
由于远程目录与本地目录之间的模式不一致，因此，未彻底更新指定昵称的统计信息。
01670
对新表来说，不存在缺省主表空间。
01671
高速缓存的语句的环境与当前环境不同。将使用当前环境来重新优化指定的语句。
01H51
“MQSeries 应用程序消息传递接口”消息被截断。
01HXX
由用户定义的函数或外部过程 CALL 返回了有效警告 SQLSTAE。


类代码 02 无数据

表 5. 类代码 02：无数据
SQLSTATE 值
  
含义
02000
发生下述异常之一：

SELECT INTO 语句或 INSERT 语句的子查询的结果为空表。
在搜索的 UPDATE 或 DELETE 语句内标识的行数为零。
在 FETCH 语句中引用的游标位置处于结果表最后一行之后。
02501
游标位置对于当前行的 FETCH 无效。
02502
检测到删除或更新孔
类代码 07 动态 SQL 错误

表 6. 类代码 07：动态 SQL 错误
SQLSTATE 值
  
含义
07001
对于参数标记的数目来说，主机变量的数目不正确。
07002
调用参数列表或控制块无效。
07003
在 EXECUTE 语句内标识的语句是一条选择语句，或未处于已预编译状态。
07004
动态参数需要 USING 子句或 INTO 子句。
07005
游标的语句名标识的是一个不能与游标关联的已预编译语句。
07006
由于其数据类型的缘故不能使用某输入主机变量。
类代码 08 连接异常

表 7. 类代码 08：连接异常
SQLSTATE 值
  
含义
08001
应用程序请求器不能建立连接。
08002
连接已存在。
08003
连接不存在。
08004
应用程序服务器拒绝建立连接。
08007
事务解析未知。
08502
用 TWOPHASE 的 SYNCPOINT 运行的应用程序进程发出的 CONNECT 语句无效，因为无事务管理器可用。
08504
当处理指定的路径重命名配置文件时遇到错误。
类代码 09 触发操作异常

表 8. 类代码 09：触发操作异常
SQLSTATE 值
  
含义
09000
触发 SQL 语句失败。
类代码 0A 不支持功能部件

表 9. 类代码 0A：不支持功能部件
SQLSTATE 值
  
含义
0A001
CONNECT 语句无效，因为进程不处于可连接状态。
0A502
未对此数据库实例启用操作。
0A503
由于潜在的数据不一致，不能编译联合插入、更新或删除操作。
类代码 0D 目标类型规范无效

表 10. 类代码 0D：目标类型规范无效
SQLSTATE 值
  
含义
0D000
目标结构化数据类型规范是源结构化数据类型的正确子类型。
类代码 0F 无效标记

表 11. 类代码 OF：无效标记
SQLSTATE 值
  
含义
0F001
LOB 标记变量当前不表示任何值。
类代码 0K RESIGNAL 语句无效

表 12. 类代码 0K：RESIGNAL 语句无效
SQLSTATE 值
  
含义
0K000
RESIGNAL 语句不在处理程序中。
类代码 20 找不到 CASE 语句的条件

表 13. 类代码 20：找不到 Case 语句的条件
SQLSTATE 值
  
含义
20000
找不到 CASE 语句的条件。
类代码 21 基数违例

表 14. 类代码 21：基数违例
SQLSTATE 值
  
含义
21000
SELECT INTO 的结果是一个多行的结果表，或者，基本谓词的子查询结果为多个值。
21501
对自引用表进行多行 INSERT 是无效的。
21502
主键的多行 UPDATE 是无效的。
21504
从删除规则为 RESTRICT 或 SET NULL 的自引用表进行多行 DELETE 是无效的。
21505
行函数返回的内容不能超过一行。　
21506
表的同一行不能是多个更新、删除或插入操作的目标。
类代码 22 数据异常

表 15. 类代码22：数据异常
SQLSTATE 值
  
含义
22001
字符数据，发生右截断；例如，更新或插入值对于列来说太长（字符串），或者日期时间值由于太小而不能赋给主机变量。
22002
检测到空值或缺少指示符参数；例如，不能将空值赋给主机变量，因为没有指定指示符变量。
22003
数字值超出范围。
22004
不能从定义为 PARAMETER STYLE GENERAL 的过程或者从用非空自变量调用的类型保留方法中返回空值。
22007
检测到无效的日期时间格式；即指定了无效的字符串表示法或值。
22008
发生日期时间字段溢出；例如，对日期或时间戳记算术运算的结果不在有效日期范围之内。
2200G
大多数特定类型都不匹配。
22011
发生子字符串错误；例如，SUBSTR 的自变量超出范围。
22012
用零作除数是无效的。
22018
对于 CAST、DECIMAL、FLOAT、或 INTEGER 标量函数，字符值是无效的。
22019
LIKE 谓词有无效转义字符。
22021
某字符不在编码字符集中。
22024
以 NUL 结束的输入主机变量或参数不包含 NUL。
22025
LIKE 谓词字符串模式包含无效的转义字符。
2202D
配合变异方法使用了空实例。
2202H
在 TABLESAMPLE 子句中指定的样本大小无效。
22501
变长字符串的长度控制字段为负值或大于最大值。
22504
混合数据值是无效的。
22506
对日期时间专用寄存器的引用无效，因为 TOD 时钟发生故障或操作系统时区参数超出范围。
22522
CCSID 值根本无效，对数据类型或子类型无效，或对编码方案无效。
22526
键变换函数没有生成任何行或生成了重复的行。
22527
对多行 INSERT 操作检测到了无效的输入数据。
类代码 23 约束违例

表 16. 类代码 23：约束违例
SQLSTATE 值
  
含义
23001
RESTRICT 更新或删除规则防止父键被更新或删除。
23502
插入或更新值为空，但该列不能包含空值。
23503
外键的插入或更新值无效。
23504
NO ACTION 更新或删除规则防止父键被更新或删除。
23505
发生由唯一索引或唯一约束强加的约束违例。
23510
使用由 RLST 表强加的命令时发生约束违例。
23511
不能删除父行，因为检查约束限制该删除。
23512
不能添加检查约束，因为该表含有不满足约束定义的行。
23513
INSERT 或 UPDATE 的结果行不符合检查约束定义。
23514
检查数据处理中发现约束违例。
23515
不能建立唯一索引，或不能添加唯一约束，因为该表包含指定键的重复值。
23520
不能定义外键，因为其所有的值都不同于父表的父键。
23521
对目录表的更新违反了内部约束。
23522
标识列值的范围或者序列用完。
23524
UNION ALL 视图内的无效行移动。
23527
联合数据源中发生了完整性约束违例。
类代码 24 无效游标状态

表 17. 类代码 24：无效游标状态
SQLSTATE 值
  
含义
24501
标识的游标未打开。
24502
在 OPEN 语句中标识的游标已经打开。
24504
在 UPDATE、DELETE、SET 或 GET 语句中标识的游标未定位在行上。
24506
在 PREPARE 中标识的语句是一个打开游标语句。
24510
对一个删除孔或更新孔尝试了 UPDATE 或 DELETE 操作。
24512
结果表与基本表不一致。
24513
不允许 FETCH NEXT、PRIOR、CURRENT 或 RELATIVE，原因是游标位置未知。
24514
先前的错误已禁用此游标。
24516
已对结果集指定了一个游标。
24517
外部函数或方法将游标保持为打开。
类代码 25 无效事务状态

表 18. 类代码 25：无效事务状态
SQLSTATE 值
  
含义
25000
插入、更新或删除操作在指定它的上下文中无效。
25001
该语句只允许作为工作单元的第一个语句。
25501
该语句只允许作为工作单元的第一个语句。
25502
操作在单个事务中不能多次出现。
类代码 26 无效 SQL 语句标识

表 19. 类代码 26：无效 SQL 语句标识
SQLSTATE 值
  
含义
26501
标识的语句不存在。
类代码 27 触发的数据更改违例

表 20. 类代码 27：触发的数据更改违例
SQLSTATE 值
  含义
27000
已尝试通过约束或触发器来修改 MERGE 语句的目标表。
类代码 28 无效权限规范

表 21. 类代码 28：无效权限规范
SQLSTATE 值
  
含义
28000
权限名称无效。
类代码 2D 无效事务终止

表 22. 类代码 2D：无效事务终止
SQLSTATE 值
  
含义
2D521
SQL COMMIT 或 ROLLBACK 在当前操作环境中无效。
2D522
ATOMIC 复合语句中不允许 COMMIT 和 ROLLBACK。
2D528
动态 COMMIT 对于应用程序执行环境无效。
2D529
动态 ROLLBACK 对于应用程序执行环境无效。
类代码 2E 无效连接名

表 23. 类代码 2E：无效连接名
SQLSTATE 值
  
含义
2E000
连接名无效。
类代码 34 无效游标名

表 24. 类代码 34：无效游标名
SQLSTATE 值
  
含义
34000
游标名无效。
类代码 36 无效游标规范

表 25. 类代码 36：无效游标规范
SQLSTATE 值
  
含义
36001
不能为指定的选择语句定义 SENSITIVE 游标。
类代码 38 外部函数异常

表 26. 类代码 38：外部函数异常
SQLSTATE 值
  
含义
38XXX
外部例程或触发器返回有效错误 SQLSTATE。
38001
不允许外部例程执行 SQL 语句。
38002
例程尝试修改数据，但例程未定义为 MODIFIES SQL DATA。
38003
例程中不允许该语句。
38004
例程尝试读取数据，但例程未定义为 READS SQL DATA。
38501
（使用 SIMPLE CALL 或 SIMPLE CALL WITH NULLS 调用约定）调用用户定义的函数、外部过程或触发器时出错。
38502
不允许外部函数执行 SQL 语句。
38503
用户定义的函数异常终止（abend）。
38504
用户定义的函数已被用户中断，以停止可能的循环条件。
38505
FINAL CALL 上的例程中不允许 SQL 语句。
38506
函数因来自 OLE 数据库提供程序的错误而失败。
38552
SYSFUN 模式（由 IBM 提供）中的函数已异常终止。

可以在消息正文中找到下列原因码之一：

01
数字值超出范围
02
被零除
03
算术溢出或下溢
04
日期格式无效
05
时间格式无效
06
时间戳记格式无效
07
时间戳记持续时间的字符表示法无效
08
间隔类型无效（必须是 1、2、4、8、16、32、64、128、256 其中之一）
09
字符串太长
10
字符串函数中的长度或位置超出范围
11
浮点数的字符表示法无效
38553
系统模式中的例程已因错误而终止。
38H01
MQSeries 函数未能初始化。
38H02
MQSeries 的“应用程序消息传递接口”未能终止会话。
38H03
MQSeries 的“应用程序消息传递接口”未能正确地处理消息。
38H04
MQSeries 的“应用程序消息传递接口”未能发送消息。
38H05
MQSeries 的“应用程序消息传递接口”未能读取／接收消息。
38H06
MQSeries 的“应用程序消息传递接口”预订（不预订）请求失败。
38H07
MQSeries 的“应用程序消息传递接口”未能落实工作单元。
38H08
MQSeries 的“应用程序消息传递接口”策略错误。
38H09
MQSeries XA（两阶段落实）API 调用错误。
38H0A
MQSeries 的“应用程序消息传递接口”未能回滚工作单元。
类代码 39 外部函数调用异常

表 27. 类代码 39：外部函数调用异常
SQLSTATE 值
  
含义
39001
用户定义的函数已返回无效 SQLSTATE。
39004
不允许 IN 或 INOUT 自变量为空值。
39501
与自变量相关联的 eye-catcher（引人注目的事物）已被修改。
类代码 3B SAVEPOINT 无效

表 28. 类代码 3B：SAVEPOINT 无效
SQLSTATE 值
  
含义
3B001
保存点无效。
3B002
已经达到最大保存点数目。
3B501
检测到重复的保存点名。
3B502
指定了 RELEASE 或 ROLLBACK TO SAVEPOINT，但是保存点不存在。
3B503
在触发器或全局事务中不允许 SAVEPOINT、 RELEASE SAVEPOINT 或 ROLLBACK TO SAVEPOINT。
类代码 40 事务回滚

表 29. 类代码 40：事务回滚
SQLSTATE 值
  
含义
40001
发生了伴随自动回滚的超时或死锁。
40003
语句完整性未知。
40504
由于系统错误导致工作单元被回滚。
40506
由于 SQL 错误，当前事务已回滚。
40507
由于创建索引时发生故障，因此当前事务已回滚。
类代码 42 语法错误或存取规则违例

表 30. 类代码 42：语法错误或存取规则违例
SQLSTATE 值
  
含义
42501
授权标识不具有对标识对象执行指定操作的特权。
42502
授权标识不具有执行指定操作的特权。
42504
指定的特权不能从指定的权限名称撤销。
42506
发生所有者授权失败。
42508
不能将指定的数据库特权授予 PUBLIC。
42509
因为 STATICRULES 选项而未授权 SQL 语句。
42511
未能检索 DATALINK 值。
42601
字符、标记或子句无效或丢失。
42602
检测到名称中有无效字符。
42603
检测到未终止的字符串常量。
42604
检测到无效数字或字符串常量。
42605
为标量函数指定的自变量数无效。
42606
检测到无效十六进制常数。
42607
列函数的操作数无效。
42608
在 VALUES 中使用 NULL 或 DEFAULT 是无效的。
42609
运算符或谓词的所有操作数都是参数标记。
42610
不允许参数标记。
42611
列或自变量定义无效。
42612
语句字符串是一条 SQL 语句，它在它所出现的上下文中是不可接受的。
42613
子句互斥。
42614
重复关键字无效。
42615
检测到无效备用项。
42616
指定了无效的选项。
42617
语句字符串是空白或空的。
42618
不允许主机变量。
42620
对 UPDATE 子句指定了只读 SCROLL。
42621
检查约束无效。
42622
名称或标号太长。
42623
不能指定 DEFAULT 子句。
42625
CASE 表达式无效。
42627
必须在使用 EXPRESSION AS 子句的谓词规范之前指定 RETURNS 子句。
42628
在变换定义中多次定义了 TO SQL 或 FROM SQL 变换函数。
42629
必须为 SQL 例程指定参数名。
42630
在嵌套复合语句中一定不能存在 SQLSTATE 或 SQLCODE 变量声明。
42631
SQL 函数或方法中的 RETURN 语句必须包括返回值。
42634
XML 名称无效。
42635
XML 名称空间前缀无效。
42701
在插入或更新操作或 SET 转换变量语句中检测到重复列名。
42702
由于名称重复，列引用有歧义。
42703
检测到一个未定义的列、属性或参数名。　
42704
检测到未定义的对象或约束名。
42705
检测到未定义的服务器名。
42707
ORDER BY 内的列名不标识结果表中的列。
42709
在 PRIMARY、UNIQUE、或 FOREIGN KEY 子句中检测到重复列名。
42710
检测到重复的对象或约束名。
42711
在对象定义或 ALTER 语句中检测到重复列名或属性名。
42712
在 FROM 子句中检测到重复的表标志符。
42713
在对象列表中检测到重复对象。
42720
在节点目录内未找到远程数据库的节点名。
42723
模式中已经存在带有相同特征符的函数。
42724
不能存取用于用户定义的函数或过程的外部程序。
42725
函数或方法是直接引用的（不是通过特征符或者通过特定实例名），但是存在该函数或方法的多个特定实例。
42726
检测到已命名的派生表的重复名称。
42727
对新表来说，不存在缺省主表空间。
42728
在节点组定义中检测到重复节点。
42729
节点未定义。
42730
容器名已由另一表空间使用。
42731
容器名已由该表空间使用。
42732
在 SET CURRENT PATH 语句中检测到重复的模式名。
42734
检测到重复的参数名、SQL 变量名、游标名、条件名或标号。
42735
对缓冲池，未定义表空间的节点组。
42736
在 LEAVE 语句上指定的标号找不到或无效。
42737
未定义在处理程序中指定的条件。
42738
在 FOR 语句的 DECLARE CURSOR 语句中指定了重复的列名或未命名的列。
42739
检测到重复的变换。
42740
未找到指定类型的变换。 未删除任何变换。
42741
未对数据类型定义变换组。
42742
类型表或带类型视图层次结构中已存在同类子表或子视图。
42743
在索引扩展名中未找到搜索方法。　
42744
在变换组中未定义 TO SQL 或 FROM SQL 变换函数。
42745
例程将用现有方法定义覆盖关系。
42746
在同一类型层次结构中，方法名不能与结构化类型名相同。
42748
存储器路径对于数据库来说已存在或被指定多次。
42802
插入或更新值的数目与列数不相同。
42803
在 SELECT 或 HAVING 子句中的列引用无效，因为它不是分组列；或者在 GROUP BY 子句中的列引用无效。
42804
CASE 表达式中的结果表达式不兼容。
42805
ORDER BY 子句中的整数不标识结果表中的列。
42806
不能将某值赋予某主机变量, 因为数据类型不兼容。
42807
对该对象不允许执行 INSERT、UPDATE 或 DELETE。
42808
插入或更新操作中标识的列不可更新。
42809
标识的对象不是语句所应用的对象类型。
42810
FOREIGN KEY 子句中没有标识基本表。
42811
指定的列数与 SELECT 子句中的列数不相同。
42813
WITH CHECK OPTION 不能用于指定的视图。
42815
数据类型、长度、小数位、值或 CCSID 无效。
42816
表达式中的日期时间值或持续时间无效。
42818
运算符或函数的操作数不兼容。
42819
算术运算的操作数或需要数字的函数的操作数不是数字。
42820
数字常数太长，或其值不在该数据类型取值范围内。
42821
更新或插入值与列不兼容。
42823
从仅允许一列的子查询中返回了多列。
42824
LIKE 的操作数不是字符串，或第一个操作数不是列。
42825
UNION、INTERSECT、EXCEPT 或 VALUES 的行没有兼容列。
42826
UNION、INTERSECT、EXCEPT 或 VALUES 的行的列数不相同。
42827
UPDATE 或 DELETE 中标识的表与游标指定的表不相同。
42828
由 UPDATE 或 DELETE 语句的游标指定的表不能修改，或该游标是只读游标。
42829
FOR UPDATE OF 无效，因为由该游标指定的结果表不能修改。
42830
外键不符合父键的描述。
42831
主键或唯一键列不允许空值。
42832
不允许对系统对象执行该操作。
42834
不能指定 SET NULL，因为不能对外键的任何列指定空值。
42835
在已命名的派生表之间不能指定循环引用。
42836
命名的递归派生表的规范无效。
42837
不能改变该列，原因是它的属性与当前的列属性不兼容。
42838
检测到表空间的无效使用。
42839
索引和长列不能处于与该表独立的表空间内。
42840
检测到 AS CAST 选项的无效使用。
42841
参数标记不能是用户定义的类型或引用类型。
42842
列定义无效，因为指定的选项与列描述不一致。
42845
检测到 VARIANT 或 EXTERNAL ACTION 函数的无效使用。
42846
不支持从源类型到目标类型的强制类型转型。
42852
在 GRANT 或 REVOKE 中指定的特权无效或不一致。 （例如，视图上的 GRANT ALTER。）
42853
指定了选项的两个备用项，或者同一选项被指定了多次。
42854
选择列表中的结果列数据类型与在带类型视图或具体查询表定义中定义的类型不兼容。
42855
不允许对此主机变量指定 LOB。 此游标的 LOB 值的所有访存的目标主机变量必须是定位器或 LOB 变量。
42858
不能将该操作应用于指定对象。
42863
检测到 REXX 中有未定义的主机变量。
42866
在 CREATE FUNCTION 语句的 CAST FROM 子句中的 RETURNS 子句的数据类型对于有源函数或函数体中的 RETURN 语句返回的数据类型不适合。
42867
指定了冲突的选项。
42872
FETCH 语句子句与游标定义不兼容。
42875
要在 CREATE SCHEMA 中创建的对象的限定符必须与模式名相同。
42877
不能限定该列名。
42878
无效的函数或过程名称与 EXTERNAL 关键字一起使用。
42879
在 CREATE FUNCTION 语句中一个或多个输入参数的数据类型对于源函数中相应的数据类型不适合。
42880
CAST TO 和 CAST FROM 数据类型不兼容，或总会导致固定字符串截断。
42881
使用基于行的函数无效。
42882
特定实例名限定符与函数名限定符不相同。
42883
找不到具有相匹配特征符的函数或方法。
42884
找不到具有指定名称和兼容自变量的任何例程。
42885
在 CREATE FUNCTION 语句中指定的输入参数数目与 SOURCE 子句中命名的函数所提供的参数数目不匹配。
42886
IN、OUT 或 INOUT 参数属性不匹配。
42887
在该函数出现的上下文中该函数无效。
42888
表没有主键。
42889
该表已有主键。
42890
在引用子句中指定了列表，但是标识的父表没有指定列名的唯一约束。
42891
重复的 UNIQUE 约束已存在。
42893
该对象或约束不能删除，因为还有其它对象从属于该对象。
42894
DEFAULT 值无效。
42895
对于静态 SQL，不能使用输入主机变量，因为其数据类型与过程或用户定义的函数的参数不兼容。
428A0
用户定义的函数所基于的有源函数出错。
428A1
不能存取主机文件变量所引用的文件。
428A2
表不能指定给多节点节点组，因为它没有分区键。
428A3
为事件监视器指定了无效路径。
428A4
为事件监视器选项指定了无效值。
428A5
在 SET INTEGRITY 语句中命名的异常表结构不正确，或者已用生成的列、约束或触发器定义了该异常表。
428A6
在 SET INTEGRITY 语句中命名的异常表不能与正在检查的表之一相同。
428A7
检查的表数目与在 SET INTEGRITY 语句中指定的异常表数目不匹配。
428A8
在父表处于检查暂挂状态时，不能对派生表使用 SET INTEGRITY 语句复位检查暂挂状态。
428A9
节点范围无效。
428AA
列名不是事件监视器表的有效列。
428B0
在 ROLLUP、CUBE 或 GROUPING SETS 中有非法嵌套。
428B1
未指定给特定节点的表空间容器的规范数目不正确。
428B2
容器的路径名无效。
428B3
指定了无效的 SQLSTATE。
428B7
在 SQL 语句中指定的编号不在有效范围内。
428BO
不能为联合数据源创建方案。
428C0
不能删除该节点，因为它是节点组中唯一的节点。
428C1
只能为表指定一个 ROWID 列。
428C2
检查函数体指出应已在 CREATE FUNCTION 语句中指定给出的子句。
428C4
谓词运算符两边的元素数不相同。
428C5
从数据源中找不到数据类型的数据类型映射。
428C9
不能将 ROWID 列指定为 INSERT 或 UPDATE 的目标列。
428CA
处于追加方式的表不能具有集群索引。
428CB
表空间的页大小必须与相关联的缓冲池的页大小相匹配。
428D1
不能存取 DATALINK 值所引用的文件。
428D4
在 OPEN、CLOSE 或 FETCH 语句中不能引用在 FOR 语句中指定的游标。
428D5
结束标号与开始标号不匹配。
428D6
NOT ATOMIC 语句不允许 UNDO。
428D7
不允许条件值。
428D8
SQLSTATE 或 SQLCODE 变量的声明或使用无效。
428DB
作为超类型、超表或超视图，该对象无效。　
428DC
对于此类型的变换，该函数或方法无效。
428DD
未定义要求的变换。
428DE
PAGESIZE 值不受支持。
428DF
在 CREATE CAST 中指定的数据类型无效。
428DG
在 CREATE CAST 中指定的函数无效。
428DH
操作对于类型表无效。
428DJ
不能更改或删除继承列或属性。
428DK
已定义引用列的作用域。
428DL
外部函数或有源函数的参数已定义了作用域。
428DM
作用域表或视图对于引用类型无效。
428DN
未在外部函数的 RETURNS 子句中指定 SCOPE，或在有源函数的 RETURN 子句中指定了 SCOPE。
428DP
该类型不是结构化类型。
428DQ
子表或子视图的模式名不能与其上一级表或上一级视图的模式名不同。
428DR
操作不能应用于子表。　
428DS
不能在子表中定义指定列的索引。　
428DT
表达式的操作数不是有效的作用域引用类型。
428DU
要求的类型层次结构中不包括的一种类型。　
428DV
取消引用运算符的左操作数无效。
428DW
不能使用取消引用运算符来引用对象标识列。
428DX
对象标识列是定义一个类型表或带类型视图层次结构的根表或根视图所必需的。
428DY
不能对目标对象类型更新统计信息。
428DZ
不能更新对象标识列。
428E0
索引的定义与索引扩展名的定义不匹配。
428E1
用于产生范围的表函数的结果与索引扩展名的键变换表函数的结果不一致。
428E2
目标键参数的数目或类型与索引扩展名的键变换函数的数目或类型不匹配。
428E3
索引扩展名中函数的自变量无效。
428E4
函数在 CREATE INDEX EXTENSION 语句中不受支持。
428E5
只能用用户定义的谓词来指定 SELECTIVITY 子句。
428E6
用户定义的谓词中的方法的搜索自变量与索引扩展名的相应搜索方法的搜索自变量不匹配。
428E7
用户定义的谓词中跟在比较运算符后的操作数类型与 RETURNS 数据类型不匹配。
428E8
搜索目标或搜索自变量参数与正在创建的该函数的参数名不匹配。
428E9
在相同的使用规则中自变量参数名不能同时作为搜索目标和搜索自变量。
428EA
带类型视图中的全查询无效。
428EB
仅当上一级视图中的相应列为可更新时，才可读取子视图中的列。
428EC
为具体查询表指定的全查询无效。
428ED
不能构造具有 Datalink 或 Reference 类型属性的结构化类型。
428EE
选项对此数据源无效。
428EF
该选项的值对此数据源无效。
428EG
丢失此数据源所必需的选项。
428EH
不能 ADD 已定义的选项。
428EJ
不能 SET 或 DROP 尚未添加的选项。
428EK
声明的全局临时表名的限定符必须是 SESSION。
428EL
变换函数不能与函数或方法一起使用。
428EM
TRANSFORM GROUP 子句是必需的。
428EN
变换组被指定为未使用。
428EP
结构化类型不能直接或间接地从属于其本身。
428EQ
例程的返回类型与主题类型不同。
428ER
在删除方法主体之前，不能删除方法规范。
428ES
方法主体与方法规范的语言类型不对应。
428EU
在服务器定义中未指定 TYPE 或 VERSION。
428EV
对于该数据源类型，传递（Pass-Through）设施不受支持。
428EW
表不能与具体查询表互相转换。
428EX
例程不能用作变换函数，因为它是内置函数或方法。
428EY
用户定义的谓词中搜索目标的数据类型与指定索引扩展名的源键的数据类型不匹配。
428EZ
OLAP 函数的窗口规范无效。
428F0
ROW 函数必须包括至少两列。
428F1
SQL TABLE 函数必须返回表结果。
428F2
SQL 过程中的 RETURN 语句值的数据类型必须是 INTEGER。
428F3
SCROLL 与 WITH RETURN 是互斥的。
428F4
在 FETCH 上指定的 SENSITIVITY 不允许用于游标。
428F6
游标是可滚动的，但结果表涉及来自表函数的输出。
428F7
尝试对外部例程进行的操作仅应用于 SQL 例程。
428F9
在此上下文中不能指定序列表达式。
428FA
十进制数的小数位必须为零。
428FB
序列名一定不能是由系统为标识列生成的序列。
428FC
加密密码的长度无效。
428FD
用于解密的密码与加密数据时所使用的密码不匹配。
428FE
数据不是 ENCRYPT 函数的结果。
428FF
缓冲池规范无效。
428FG
用来定义登台表的表无效。
428FH
SET INTEGRITY 选项无效
428FI
指定了 ORDER OF，但表标志符不包含 ORDER BY 子句。
428FJ
视图或具体查询表的外部全查询不允许使用 ORDER BY。
428FL
在指定 SQL 数据更改语句的上下文中，不允许 SQL 数据更改语句。
428FM
SELECT 中的 INSERT 语句指定了一个不是对称视图的视图。
428FP
只允许将一个 INSTEAD OF 触发器用于对主题视图的每种操作。
428FQ
INSTEAD OF 触发器一定不能指定使用 WITH CHECK OPTION 定义的视图、在使用 WITH CHECK OPTION 定义的另一个视图上定义的视图或者嵌套在使用 WITH ROW MOVEMENT 子句定义的视图中的视图。
428FU
从 FROM SQL 变换函数或方法返回的内置类型与 TO SQL 变换函数或方法的相应内置类型不匹配。
428FV
不能将方法定义为覆盖方法。
428FZ
仅为某些操作定义了 INSTEAD OF 触发器的视图不能在 MERGE 语句中用作目标。
428G3
当全查询中的 SQL 数据更改语句的目标视图定义了 INSTEAD OF 触发器时，FINAL TABLE 无效。
428G4
无效使用了 INPUT SEQUENCE 排序。
428G5
UPDATE 语句的赋值子句必须至少指定不是 INCLUDE 列的一列。
428G6
指定了不能从全查询的 FROM 子句中的数据更改语句的目标中选择的一列。
428G8
不能启用视图以进行查询优化。
428GA
不能添加、删除或改变联合选项。
42901
列函数不包括列名。
42903
WHERE 子句或 SET 子句包括无效引用，例如列函数。
42904
由于编译错误，未创建 SQL 过程。
42907
字符串太长。
42908
语句不包括必需的列列表。
42910
复合语句中不允许该语句。
42911
十进制除法运算无效，因为其结果的小数位为负。
42912
列不能更新，因为它未在游标的 select 语句的 UPDATE 子句中标识。
42914
DELETE 无效，因为子查询中引用的表可能会受该操作影响。
42915
检测到无效引用约束。
42916
不能创建别名，因为它会导致重复的别名链。
42917
不能显式删除或改变该对象。
42918
用户定义的数据类型不能用系统定义数据类型名（例如 INTEGER）创建。
42919
不允许嵌套复合语句。
42921
容器不能添加至该表空间。
42925
命名的递归派生表不能指定 SELECT DISTINCT，而必须指定 UNION ALL。
42928
不能为该表指定 WITH EMPTY TABLE。
42932
程序预编译假设不正确。
42939
不能使用该名称，因为指定的标识是保留给系统使用的。
42961
指定的服务器名与当前服务器不匹配。
42962
长列、LOB 列或结构化类型列不能用于索引、键或约束。
42968
连接失败，因为没有当前软件许可证。
42969
未创建程序包。
42972
MERGE 语句的连接条件或 ON 子句中的表达式引用多个操作数表中的列。
42985
例程中不允许该语句。
42987
不允许此语句出现在过程或触发器中。
42989
在 BEFORE 触发器中不能使用基于表达式的 GENERATED 列。
42991
当前内部仅支持 BOOLEAN 数据类型。
42993
定义的列太大而不能记录。
42994
不支持裸设备容器。
42995
所请求的函数不应用于全局临时表。
42997
此版本的 DB2 应用程序请求器、DB2 应用程序服务器或两者的组合不支持该功能。
429A0
外键不能引用最初被定义为不进行记录的父表。
429A1
节点组对于表空间无效。
429A9
SQL 语句不能由 DataJoiner 处理。
429B2
为结构化类型或列指定的直接插入长度值太小。
429B3
可能未在子表中定义对象。
429B4
数据过滤函数不能是 LANGUAGE SQL 函数。
429B5
索引扩展名中实例参数的数据类型无效。
429B8
用 PARAMETER STYLE JAVA 定义的例程 不能具有作为参数类型或返回类型的结构化类型。
429B9
在属性赋值中不能使用 DEFAULT 或 NULL。
429BA
FEDERATED 关键字必须与对联合数据库对象的引用配合使用。
429BB
在 SQL 例程中不支持对参数或变量指定的数据类型。
429BC
在 ALTER TABLESPACE 语句中有多个容器操作。
429BE
主键或唯一键是维子句中的列的子集。
429BG
范围集群表不支持该函数。
429BJ
在视图中无效使用了 WITH ROW MOVEMENT。
429BK
由于移动行涉及到基础视图，因此，尝试更新视图无效。
429BL
在非法上下文中调用了将修改 SQL 数据的函数。
429BO
不能为联合数据源创建方案。
429BP
昵称列表达式无效。
类代码 44 WITH CHECK OPTION 违例

表 31. 类代码 44：WITH CHECK OPTION 违例
SQLSTATE 值
  
含义
44000
不允许插入或更新操作，因为结果行不满足视图定义。
类代码 46 Java DDL

表 32. 类代码 46：Java DDL
SQLSTATE 值
  
含义
46001
Java DDL － 无效 URL。
46002
Java DDL － 无效 jar 名称。
46003
Java DDL － 无效类删除。
46007
Java DDL － 无效特征符。
46008
Java DDL － 无效方法规范。
46103
Java 例程遇到了 ClassNotFound 异常。
46501
Java DDL － 未实现可选组件。
类代码 51 无效应用程序状态

表 33. 类代码 51：无效应用程序状态
SQLSTATE 值
  
含义
51002
未找到与 SQL 语句执行请求相对应的程序包。
51003
一致性标记不匹配。
51004
SQLDA 中的地址无效。
51005
上一系统错误已禁用此函数。
51008
预编译的程序的发行版号无效。
51015
尝试执行在绑定时发现有错的节。
51017
用户没有登录。
51021
直到应用程序进程执行回滚操作时才能执行 SQL 语句。
51022
当 CONNECT 语句中命名的服务器已存在连接（不论处于当前状态还是休眠状态）时，指定权限名称的 CONNECT 无效。
51023
该数据库已由数据库管理器的另一实例使用。
51024
不能使用视图，因为它已被标记为不可操作。
51025
在 XA 事务处理环境中的应用程序未用 SYNCPOINT TWOPHASE 绑定。
51026
事件监视器不能打开，因为它的目标路径已由另一事件监视器使用。
51027
因为表是用户维护的具体查询表或未处于检查暂挂状态，所以 SET INTEGRITY 语句的 IMMEDIATE CHECKED 选项无效。
51028
不能使用程序包，因为它被标记为不可操作。
51030
在应用程序进程中尚未调用 ALLOCATE CURSOR 或 ASSOCIATE LOCATORS 语句中所引用的过程。
51034
使用 MODIFIES SQL DATA 定义的例程在调用它的上下文中无效。
51035
不能使用 PREVVAL 表达式，原因是在此会话中还没有为序列生成值。
51038
SQL 语句可能不再由例程发出。
51039
未设置 ENCRYPTION PASSWORD 值。
51040
编译环境无效。
类代码 53 无效操作数或不一致的规范

表 34. 类代码 53：无效操作数或不一致的规范
SQLSTATE 值
  
含义
53040
在指定的数据库分区上不存在指定的缓冲池。
53090
同一个 SQL 语句中只能引用具有一种编码方案（ASCII、EBCDIC 或 Unicode）的数据。
53091
指定的编码方案与当前用于包含对象的编码方案不相同。
类代码 54 超过 SQL 或产品限制

表 35. 类代码 54：超过 SQL 限制或产品限制
SQLSTATE 值
  
含义
54001
语句太长或者太复杂。
54002
字符串常量太长。
54004
语句中 SELECT 或 INSERT 列表中的项或表名太多。
54006
并置的结果太长。
54008
键太长，列数太多，或键列太长。
54010
表的记录长度太长。
54011
为表或视图指定了太多列。
54023
用于函数或过程的参数或自变量数目超出限制。
54028
已达到并发 LOB 句柄最大数。
54029
已达到打开目录扫描最大数。
54030
活动事件监视器已达最大数。
54031
已对事件监视器分配了最大文件数。
54032
已达到表的最大大小。
54033
已达到分区映射最大数。
54034
表空间的所有容器名的组合长度太长。
54035
已超过内部对象限制。
54036
容器或存储器路径的路径名太长。
54037
表空间的容器映射太复杂。
54038
超出了嵌套例程或触发器的最大深度。
54045
已超出类型层次结构的最大级别。
54046
索引扩展名中已超出允许的参数的最大值。
54047
已超出表空间的最大大小。
54048
具有足够页大小的临时表空间不存在。
54049
结构化类型的实例的长度超过了系统限制。
54050
在结构化类型中超过了允许的最大属性数目。
54052
缓冲池的块页数对缓冲池对于缓冲池的大小来说太大了。
54053
为 BLOCKSIZE 指定的值不在有效范围内。
类代码 55 对象不处于先决条件状态

表 36. 类代码 55：对象不处于先决条件状态。
SQLSTATE 值
  
含义
55001
数据库必须迁移。
55002
未正确定义解释表。
55006
对象不能删除，因为它当前正由同一应用程序进程使用。
55007
不能改变对象，因为它当前正由同一应用程序进程使用。
55009
系统尝试对只读文件或写保护软盘进行写入。
55012
在表中已存在一个集群索引。
55019
表的状态对于该操作无效。
55022
未向此数据库注册文件服务器。
55023
调用例程时发生错误。
55024
表空间不能删除，因为与表相关的数据也在另一表空间中。
55025
必须重新启动数据库。
55026
不能删除临时表空间。
55031
错误映射文件的格式不正确。
55032
CONNECT 语句无效，因为在该应用程序启动后，数据库管理器停止。
55033
事件监视器不能在创建它或修改它所处的同一工作单元内激活。
55034
事件监视器处于无效的操作状态。
55035
不能删除该表，因为它是受保护的。
55036
不能删除该节点，因为它未从该分区映射除去。
55037
不能删除该分区键，因为该表在多节点节点组内。
55038
该节点组不能使用，因为它正在进行重新平衡。
55039
不允许存取或状态过渡，因为该表空间未处于适当状态。
55041
在进行重新平衡时，不能将容器添加至表空间。
55043
当基于该类型的类型表或带类型视图存在时，不能改变结构化类型的属性。
55045
不能为该例程创建“SQL 归档”（SAR）文件，因为服务器上未提供所需组件。
55046
指定的 SQL 归档文件与目标环境不匹配。
55047
外部函数或方法尝试存取联合对象。
55048
不能再加密已加密的数据。
55049
未正确定义事件监视器表。
55051
ALTER BUFFERPOOL 语句当前正在处理中。
55054
不能将方法定义为覆盖方法。
55056
由于未启用数据库进行联合，因此不能更新昵称统计信息。
55060
尚未对数据库定义自动存储器。
55061
不允许执行自动存储器表空间的重定向复原。
55062
因为没有对数据库启用自动存储器，所以不能提供存储器路径。
类代码 56 其它 SQL 或产品错误

表 37. 类代码 56：其它 SQL 或产品错误
SQLSTATE 值
  
含义
56031
子句或标量函数无效，因为该系统不支持混合数据和 DBCS 数据。
56033
长串列的插入值或更新值必须是主机变量或 NULL。
56038
此环境不支持请求的功能部件。
56072
由于低级别服务器不支持函数，所以执行失败，这不会影响后续 SQL 语句的执行。
56084
在 DRDA 中不支持 LOB 数据。
56091
执行复合 SQL 语句时发生多个错误。
56092
权限类型不能确定，因为权限名称既是用户标识又是组标识。
56095
绑定选项无效。
56097
在 DEVICE 上构建的 TABLESPACE 中不允许 LONG VARCHAR 和 LONG VARGRAPHIC 字段。
56098
在隐式重新绑定或预编译期间出错。
56099
目标数据库不支持 REAL 数据类型。
560A0
对 LOB 值的操作失败。
560AA
子句或标量函数无效，因为该系统不支持 UCS-2。
560AC
包装器定义不能用于指定类型或版本的数据源。
560AF
当使用网关集中器时，PREPARE 语句不受支持。
560B0
调整的新表空间或表空间容器大小值无效。
560B1
存储过程中有无效的游标规范。
560B7
对于多行 INSERT，对于每一行，序列表达式的用法都必须相同。
560BB
对于动态准备的 CALL 语句中的 INOUT 参数，必须在 USING 和 INTO 子句中使用相同的主机变量。
560BC
存取文件时发生错误。
560BD
联合服务器从数据源中接收到意外的错误代码。
560BF
加密设施不可用。
560C0
不能在 SQL 函数或 SQL 方法中使用以 Unicode 编码方案创建的表。
560C1
以 Unicode 编码方案创建的表不能是类型表或者包含图形类型或用户定义的类型。
560C2
为已删除表写历史文件条目失败。
560C3
AFTER 触发器不能修改为 INSERT 语句插入的一行。
560C6
引用约束不能修改由全查询内的 SQL 数据更改语句修改的行。
560C8
不能更新某些昵称统计信息。
560C9
不能说明指定的语句。
560CA
SQL 语句引用了只能在当前数据库分区上运行的例程。
类代码 57 资源不可用或操作员干预

表 38. 类代码 57：资源不可用或操作员干预
SQLSTATE 值
  
含义
57001
表不可用，因为它没有主索引。
57003
未激活指定的缓冲池。
57007
对象不能使用，因为 DROP 或 ALTER 处于暂挂状态。
57009
虚拟存储器或数据库资源暂时不可用。
57011
虚拟存储器或数据库资源不可用。
57012
非数据库资源不可用。这不会影响后续语句的成功执行。
57013
非数据库资源不可用。这将影响后继语句的成功执行。
57014
按照请求取消了处理。
57016
因为表不活动，所以不能存取它。
57017
未定义字符转换。
57019
该语句因资源问题未成功。
57020
包含数据库的驱动器被锁定。
57021
软盘驱动器门是打开的。
57022
不能创建表，因为语句的授权标识不拥有任何合适的 dbspaces。
57030
与应用程序服务器的连接超出安装定义的限制。
tp57032
已启动最大并行数据库数。
57033
发生死锁或超时，而没有自动回滚。
57036
事务日志不属于当前的数据库。
57046
不能启动新的事务，因为数据库或实例被停顿。
57047
不能创建内部数据库文件，因为该目录不可存取。
57048
存取表空间的容器时发生错误。
57049
已达到操作系统处理限制。
57050
文件服务器当前不可用。　
57051
估计的 CPU 成本超出了资源限制。
57052
节点不可用，因为它所含有的容器不足以满足所有的临时表空间。
57053
因为冲突操作，所以不能对表执行操作。
57055
带有足够页大小的临时表空间不可用。　
57056
程序包不可用，因为数据库处于 NO PACKAGE LOCK 方式。
57057
由于 SQL 语句的 DRDA 链中的优先条件，不能执行该 SQL 语句。
57059
表空间中没有足够的空间用于执行指定的操作。
类代码 58 系统错误

表 39. 类代码 58：系统错误
SQLSTATE 值
  
含义
58004
发生系统错误（它不一定阻止后续 SQL 语句的成功执行）。
58005
发生系统错误（它阻止后续 SQL 语句的成功执行）。
58008
由于分发协议错误致使执行失败，它不影响后续 DDM 命令或 SQL 语句的成功执行。
58009
由于分发协议错误致使执行失败，它导致对话的释放。
58010
由于分发协议错误致使执行失败，它将影响后续 DDM 命令或 SQL 语句的成功执行。
58011
进行绑定时 DDM 命令无效。
58012
具有指定程序包名和一致性标记的绑定进程不活动。
58014
不支持 DDM 命令。
58015
不支持 DDM 对象。
58016
不支持 DDM 参数。
58017
不支持 DDM 参数值。
58018
不支持 DDM 回复消息。
58023
系统错误导致当前程序被取消。
58030
发生 I/O 错误。
58031
连接因系统错误而未成功。
58032
不能将该进程用于设防方式的用户定义的函数。
58034
尝试在 DMS 表空间中寻找对象的页时检测到错误。
58035
尝试在 DMS 表空间中释放对象的页时检测到错误。
58036
指定的内部表空间标识不存在。
ZZZZZ
占位符 sqlstate 仅供开发使用。在交付代码之前必须更改它。
 * @author zlmwork
 *
 */
public abstract class SQLParser extends DataServiceTools implements SQLParserAble
{
	protected CTXMLElement queryDefineElement = null;
	public CTXMLElement getQueryDefineElement()
	{
		return queryDefineElement;
	}
	public void setQueryDefineElement(CTXMLElement queryDefineElement)
	{
		this.queryDefineElement = queryDefineElement;
	}
	
	/* 实现接口 */
	/**
	 * 该方法， 用于SchemaConfig, 获得对应SQL 文
	 * @param formcode
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserSQLString(String formcode, FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现parserSQLString.");
		return null;
	}
	
	/**
	 * 该接口用Form 和View 对象的Parser 实现， 以供SchemaConfig 调用
	 * 根据Form 进行SQL 生成
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserSQLString(FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现parserSQLString.");
		return null ;
	}
	
	
	/**
	 * 该接口由command 实现
	 * @param field
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserSQLString( Field field, String alias, String content, FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现parserSQLString.");
		return null;
	}
	
	
	/**
	 * 该方法， 用于SchemaConfig 
	 * @param formcode  Schema Code 的值
	 * @param field 	field
	 * @return          如果字段Field 对应有字典，则返回Map<String,String> 格式Map<key,value> 模式。
	 * @throws Exception
	 */
	@Override
	public Map<String, String> getLibrary(String formcode, String field) throws Exception{
		logger.debug("SQLParser 不需要实现getLibrary.");
		return null;
	}
	
	/**
	 * 该接口用Form 和View 对象的Parser 实现， 以供SchemaConfig 调用
	 * @param field
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String,String> getLibrary(String field) throws Exception{
		logger.debug("SQLParser 不需要实现getLibrary.");
		return null;
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的SELECT 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getSelectFields(String alias, FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现getSelectFields");
		return null;
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Where 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getConditionFields( String alias, FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现getConditionFields.");
		return null;
	}
	
	/**
	 * 
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public SQLString parserSQLStringForWhereString(String alias, FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现parserSQLStringForWhereString.");
		return null;
	}
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Order By 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getOrderByFields(String alias,FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现getOrderByFields.");
		return null;
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Group by 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getGroupByFields(String alias,FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现getGroupByFields.");
		return null;
	}
	
	/**
	 * 获得所需要的parameter
	 * parameter 该接口由 Command 部分实现
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SQLParameter> getSQLParameters(FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现getSQLParameters.");
		return null;
	}
	
	
	/**
	 * 生成Select 部分，  该方法，主要command 实现
	 * @param formrequest
	 * @param alias
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	@Override
	public String parserSelectSentence( String alias, List<FieldInfo> fields) throws Exception{
		logger.debug("SQLParser 不需要实现parserSelectSentence.");
		return "";
	}
	
	/**
	 * 根据条件生成对应Where 部分， 该接口用command 实现
	 * @param alias
	 * @param fields
	 * @param conditionSyntax
	 * @return
	 * @throws Exception
	 */
	@Override
	public String parserWhereSentence(String alias, List<FieldInfo> fields, ConditionSection conditionSyntax) throws Exception{
		logger.debug("SQLParser 不需要实现parserWhereSentence.");
		return "";
	}
	
	/**
	 * 根据order by 生成Order by 字符串
	 * @param alias
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	@Override
	public String parserOrderBySentence(String alias,  List<FieldInfo> fields) throws Exception{
		logger.debug("SQLParser 不需要实现parserOrderBySentence.");
		return "";
	}

	/**
	 * 根据alias 生成Group by 字符串。
	 * @param alias
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	@Override
	public String parserGroupBySentence(String alias,  List<FieldInfo> fields) throws Exception{
		logger.debug("SQLParser 不需要实现parserGroupBySentence.");
		return "";
	}
	
	/**
	 * 该接口用SechemConfig 实现。
	 * @param formcode
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public NetDataSet executeForm(String formcode, FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现executeForm.");
		return null;
	}
	
	
	/**
	 * 执行, 该接口用Form 对应parser 实现。 
	 * @return 返回DataSet , DataSet 包括多个Table .
	 * @throws Exception
	 */
	@Override
	public NetDataSet executeForm(Service service, FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现executeForm.");
		return null;
	}
	
	/**
	 * 执行SQL 语句 ， 这个由Service 实现接口
	 * @param SQLString
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@Override
	public NetDataSet executeSQL(String SQLString, List<SQLParameter> params) throws Exception{
		logger.debug("SQLParser 不需要实现executeSQL.");
		return null;
	}
	
	/* 属性部分 */
	/**
	 * 获得属性值
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getAttributes() throws Exception{
		return null;
	}
	
	/**
	 * 根据attr Name 获得值列表。
	 * @param attrname
	 * @return
	 * @throws Exception
	 */
	public List<Object> getAttribute(String attrname ) throws Exception{
		return null;
	}
	
	/**
	 * 根据属性设置值
	 * @param attrname
	 * @param value
	 * @throws Exception
	 */
	public void setAttribute(String attrname, Object value) throws Exception{
		
	}
	
	/**
	 * 清除属性
	 * @throws Exception
	 */
	public void clear() throws Exception{
		
	}
	
	/**
	 * 根据属性名，删除属性
	 * @param attrname
	 * @throws Exception
	 */
	public void deleteAttribute(String attrname)throws Exception{
		
	}
	
	/**
	 * 判断是否是自己
	 * @param attrname
	 * @throws Exception
	 */
	public boolean isMine(String attrname) throws Exception{
		return false;
	}
}