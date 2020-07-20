# 1. 理解 SQL

## 1.1 数据库基础

### 1.1.1 什么是数据库

> **数据库（Database）**：存储已经组织好的数据的容器（通常是一个文件或文件集）。

我们使用的数据库软件，它实际上称为**数据库管理系统（DBMS）**。数据库是通过 **DBMS** 创建和操作的容器。我们不可能直接访问到数据库，而是通过使用 **DBMS**，让它来替我们访问数据库。



### 1.1.2 表

> **表（Table）**：特定类型数据的结构化列表。

表是结构化的文件，用来存储特定类型的数据。表可能存储客户清单、产品目录，或者其他信息列表。

需要值得注意的是存储在表中的数据是一种类型的数据或一个列表。你绝不应该将顾客的列表信息和订单的列表信息存储到同一个数据库表中，这样做会使随后的数据检索和访问变得困难。推荐的解决方案是创建两个表，在每个表中存储其相应的列表信息。

> 表名：数据库的表名是唯一的，这意味着数据库中的表不可以同名。但不同的数据库中可以使用相同的表名。



> **框架（Schema）**：关于数据库和表的布局以及属性的信息。

**框架**用来描述存储在数据库中的特定表，以及整个数据库。



### 1.1.3 列和数据类型

表由列构成。列中存储表的一部分信息。

> **列（Column）**：表中的一个字段。所有的表由一列或多列构成。



**分解数据**：正确地将数据分解到多列中很重要。例如城市、州、邮政编码应该分别作为一列。通过分解，就可能实现对特定列地排序或数据过滤。



> **数据类型（Datatype）**：允许数据的类型。表的每一列都有一个相应的数据类型来约束（或允许）该列存储特定的数据。

数据库中每一列都有相应的**数据类型**。数据类型约束存储在列中数据的类型（如防止字符值进入数值字段）。数据类型也有助于对数据正确排序，可以优化磁盘使用空间。



### 1.1.4 行

> **行（Row）**：表中的一条记录。

如果将表当作一个记录学生信息的电子表格，那么表格中的列就是数据库表的列（表示学生信息，姓名，年龄，住址等），表格的行就是数据库表的行（某个学生的具体信息）。



### 1.1.5 NULL

数据存储在行和列中，列可能被定义为可接收空值，意思就是没有任何数据。`SQL` 中用 `NULL` 来代指空值。如果一列被定义未允许未 `NULL`，当插入和更新行时，可以忽略该列的数据。



### 1.1.6 主键

> **主键（Primary Key）**：唯一标识表中每一行的列（或者多列的集合）叫做主键。

表中的每一行都应该由某列（或列的集合）来唯一标识改行。一个学生清单的表可能会使用`学生 ID` 来标识各行。

一个表的任何列都可以作为主键，只要它遵循以下两个条件：

* 任意两行不具有同样的主键值；
* 每一行必须有一个主键值（即主键列不能包含 `NULL` 值）。



在设计数据库时有以下建议：

1. 不要更新作为主键的列值；
2. 不要重复主键的列值；
3. 不要使用可能改变的主键列值。



## 1.2 什么是 SQL

**SQL** 是 **Structured Query Language（结构化查询语言）**的缩写。SQL 是为了与数据库进行通信而专门设计出来的语言。



# 2. MySQL 入门

## 2.1 什么是 MySQL





### 2.1.1 客户端/服务器软件

DBMS 有两个分支：

* **基于共享文件系统的 DBMS**，如 Microsoft Access 和 File Maker，适用于桌面系统，一般不用来进行较高端或者高要求的应用；
* **基于客户端/服务器的 DBMS**，如 MySQL、MySQL、Oracle 和 Microsoft SQL Server。这种 DBMS 分为两部分：
  * **服务器部分**：这是负责数据访问和操作的软件，该软件运行在**数据库服务器（database server）**上。负责与数据文件交互的只有服务器软件，所有对数据的请求，数据的增删改查都通过服务器软件的执行；
  * **客户端部分**：这是用来与用户交互的软件。客户端软件通过网络将请求提交给服务器软件。



## 2.2 MySQL 工具

### 2.2.1 mysql 命令行

在终端上使用以下命令，输入密码后登录 mysql 命令行。

``` bash
mysql -u root -p
```

### 2.2.2 MySQL Workbench

在 Ubuntu 中下载 MySQL Workbench：

``` bash
apt install mysql-workbench-community 
```



# 3. 运行 MySQL

## 3.1 数据库连接

使用 MySQL Workbench 来连接 MySQL：

![image-20200720114221955](MySQL_note.assets/image-20200720114221955.png)

链接到 MySQL 中需要下面信息：

* MySQL 服务器的主机名（本机就是 localhost）；
* 端口（默认为 3306）；
* 一个合法的用户名；
* 用户密码。



## 3.2 选择数据库

从网站上下载 [MySQL_scripts](https://forta.com/wp-content/uploads/books/0672327120/mysql_scripts.zip)，导入样例数据库。如果使用的数据库是 mysql，需要先创建并使用一个数据库 DATABASE，并将数据库引擎修改为 InnoDB 或其他 mysql 支持的引擎。



> 关键字（Keyword）：关键字也是保留字，作为 MySQL 的 SQL 语言的一部分，不应该被用作表名或者列名。

以下实例均使用 mysql 命令行进行输入输出。

使用 `crashcourse` 数据库：

```sql
USE crashcourse;
```

输出：

```
Database changed
```



## 3.3 数据库和表

### 3.3.1 查看数据库的信息

`SHOW DATABASES`：返回可访问的数据的列表。

```sql
mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| crashcourse        |
| information_schema |
| mybatis            |
| mysql              |
| performance_schema |
| ssmbuild           |
| sys                |
+--------------------+
7 rows in set (0.00 sec)
```



### 3.3.2 查看表的信息

`SHOW TABLES`：返回当前选择的数据库中可用表的列表信息。

```sql
mysql> SHOW TABLES;
+-----------------------+
| Tables_in_crashcourse |
+-----------------------+
| customers             |
| orderitems            |
| orders                |
| productnotes          |
| products              |
| vendors               |
+-----------------------+
6 rows in set (0.00 sec)
```



### 3.3.3 显示表的列

`DESCRIBE` 实际是 `SHOW COLUMNS FROM` 的缩写。

`DESCRIBE customers`：对指定表名，对它的每个字段返回一行。包含以下信息：



| 描述列  |      说明       |
| :-----: | :-------------: |
|  Field  |     字段名      |
|  Type   |    数据类型     |
|  Null   | 是否可为 `NULL` |
|   Key   |    键值信息     |
| Default |     默认值      |
|  Extra  |    额外信息     |



```sql
mysql> DESCRIBE customers;
+--------------+-----------+------+-----+---------+----------------+
| Field        | Type      | Null | Key | Default | Extra          |
+--------------+-----------+------+-----+---------+----------------+
| cust_id      | int       | NO   | PRI | NULL    | auto_increment |
| cust_name    | char(50)  | NO   |     | NULL    |                |
| cust_address | char(50)  | YES  |     | NULL    |                |
| cust_city    | char(50)  | YES  |     | NULL    |                |
| cust_state   | char(5)   | YES  |     | NULL    |                |
| cust_zip     | char(10)  | YES  |     | NULL    |                |
| cust_country | char(50)  | YES  |     | NULL    |                |
| cust_contact | char(50)  | YES  |     | NULL    |                |
| cust_email   | char(255) | YES  |     | NULL    |                |
+--------------+-----------+------+-----+---------+----------------+
9 rows in set (0.00 sec)
```



> **自增长（ auto_increment）**：有些表的列需要唯一值，可以在每次添加一行时自动分配一个为唯一。



# 4. 查询

**约定：所有 SQL 关键字使用大写，对表名和列名使用小写。**

## 4.1 `SELECT` 语句

### 4.1.1 检索数据

**检索单独的列**，使用 `SELECT` 语句来检索单独的列：

```sql
mysql> SELECT prod_name FROM products;
+----------------+
| prod_name      |
+----------------+
| .5 ton anvil   |
| 1 ton anvil    |
| 2 ton anvil    |
| Detonator      |
| Bird seed      |
| Carrots        |
| Fuses          |
| JetPack 1000   |
| JetPack 2000   |
| Oil can        |
| Safe           |
| Sling          |
| TNT (1 stick)  |
| TNT (5 sticks) |
+----------------+
14 rows in set (0.00 sec)

```



**检索多列**，多个列名之间使用逗号隔开，最后一个列名后不需要逗号：

```sql
mysql> SELECT prod_id, prod_name, prod_price
    -> FROM products;
+---------+----------------+------------+
| prod_id | prod_name      | prod_price |
+---------+----------------+------------+
| ANV01   | .5 ton anvil   |       5.99 |
| ANV02   | 1 ton anvil    |       9.99 |
| ANV03   | 2 ton anvil    |      14.99 |
| DTNTR   | Detonator      |      13.00 |
| FB      | Bird seed      |      10.00 |
| FC      | Carrots        |       2.50 |
| FU1     | Fuses          |       3.42 |
| JP1000  | JetPack 1000   |      35.00 |
| JP2000  | JetPack 2000   |      55.00 |
| OL1     | Oil can        |       8.99 |
| SAFE    | Safe           |      50.00 |
| SLING   | Sling          |       4.49 |
| TNT1    | TNT (1 stick)  |       2.50 |
| TNT2    | TNT (5 sticks) |      10.00 |
+---------+----------------+------------+
14 rows in set (0.00 sec)

```



**检索所有列**，使用星号（`*`）通配符来代替实际的列名：

```sql
mysql> SELECT * 
    -> FROM products;
+---------+---------+----------------+------------+----------------------------------------------------------------+
| prod_id | vend_id | prod_name      | prod_price | prod_desc                                                      |
+---------+---------+----------------+------------+----------------------------------------------------------------+
| ANV01   |    1001 | .5 ton anvil   |       5.99 | .5 ton anvil, black, complete with handy hook                  |
| ANV02   |    1001 | 1 ton anvil    |       9.99 | 1 ton anvil, black, complete with handy hook and carrying case |
| ANV03   |    1001 | 2 ton anvil    |      14.99 | 2 ton anvil, black, complete with handy hook and carrying case |
| DTNTR   |    1003 | Detonator      |      13.00 | Detonator (plunger powered), fuses not included                |
| FB      |    1003 | Bird seed      |      10.00 | Large bag (suitable for road runners)                          |
| FC      |    1003 | Carrots        |       2.50 | Carrots (rabbit hunting season only)                           |
| FU1     |    1002 | Fuses          |       3.42 | 1 dozen, extra long                                            |
| JP1000  |    1005 | JetPack 1000   |      35.00 | JetPack 1000, intended for single use                          |
| JP2000  |    1005 | JetPack 2000   |      55.00 | JetPack 2000, multi-use                                        |
| OL1     |    1002 | Oil can        |       8.99 | Oil can, red                                                   |
| SAFE    |    1003 | Safe           |      50.00 | Safe with combination lock                                     |
| SLING   |    1003 | Sling          |       4.49 | Sling, one size fits all                                       |
| TNT1    |    1003 | TNT (1 stick)  |       2.50 | TNT, red, single stick                                         |
| TNT2    |    1003 | TNT (5 sticks) |      10.00 | TNT, red, pack of 10 sticks                                    |
+---------+---------+----------------+------------+----------------------------------------------------------------+
14 rows in set (0.00 sec)

```



**检索不同的行**，SELECT 语句返回所有匹配的行，这些行之间或许会有重复。

```sql
mysql> SELECT vend_id
    -> FROM products;
+---------+
| vend_id |
+---------+
|    1001 |
|    1001 |
|    1001 |
|    1002 |
|    1002 |
|    1003 |
|    1003 |
|    1003 |
|    1003 |
|    1003 |
|    1003 |
|    1003 |
|    1005 |
|    1005 |
+---------+
14 rows in set (0.00 sec)

```

可以使用 `DISTINCT` 关键字，告诉 MySQL 只返回唯一的 `vend_id` 的行。`DISTINCT` 关键字必须放在列名前，并且它会对其后所有的列都起作用。

```sql
l> SELECT DISTINCT vend_id  
    -> FROM products;
+---------+
| vend_id |
+---------+
|    1001 |
|    1002 |
|    1003 |
|    1005 |
+---------+
4 rows in set (0.00 sec)

```



### 4.1.2 LIMIT 限定结果

`SELECT` 语句返回所有匹配的行，可能是指定表中的每一行。如果要限定返回行数，可使用 `LIMIT` 子句：

```sql
mysql> SELECT prod_name
    -> FROM products
    -> LIMIT 5;
+--------------+
| prod_name    |
+--------------+
| .5 ton anvil |
| 1 ton anvil  |
| 2 ton anvil  |
| Detonator    |
| Bird seed    |
+--------------+
5 rows in set (0.00 sec)

```

`LIMIT 5` 表示从第 0 行开始取 5 行；

`LIMIT 5，5` 表示从第 5 行开始取 5 行；

`LIMIT 4 OFFSET 3` 和 `LIMIT 3, 4` 相同，都是从第 3 行开始取 4 行。



## 4.2 数据排序

通常情况下，检索的数据显示的顺序是没有意义的，因此我们需要显式地指定排序。



> **子句（Clause）**，SQL 语句由多个子句组成，有些是必需的，有些是可选的。一个子句通常由关键字和数据组成。



### 4.2.1 单列排序

为了显式地对 SELECT 语句检索出地数据进行排序，可使用 ORDER BY 子句。ORDER BY 子句后接一个或多个列名，以此来对数据排序。

```sql
mysql> SELECT prod_name
    -> FROM products
    -> ORDER BY prod_name;
+----------------+
| prod_name      |
+----------------+
| .5 ton anvil   |
| 1 ton anvil    |
| 2 ton anvil    |
| Bird seed      |
| Carrots        |
| Detonator      |
| Fuses          |
| JetPack 1000   |
| JetPack 2000   |
| Oil can        |
| Safe           |
| Sling          |
| TNT (1 stick)  |
| TNT (5 sticks) |
+----------------+
14 rows in set (0.00 sec)

```

### 4.2.2 多列排序

使用多列排序，在不同的列名之间以逗号隔开，下面的例子，仅当多行具有相同地 `prod_price` 值时，产品才以 `prod_name` 列为标准排序：

```sql
mysql> SELECT prod_id, prod_price prod_name
    -> FROM products  
    -> ORDER BY prod_price, prod_name;
+---------+-----------+
| prod_id | prod_name |
+---------+-----------+
| FC      |      2.50 |
| TNT1    |      2.50 |
| FU1     |      3.42 |
| SLING   |      4.49 |
| ANV01   |      5.99 |
| OL1     |      8.99 |
| ANV02   |      9.99 |
| FB      |     10.00 |
| TNT2    |     10.00 |
| DTNTR   |     13.00 |
| ANV03   |     14.99 |
| JP1000  |     35.00 |
| SAFE    |     50.00 |
| JP2000  |     55.00 |
+---------+-----------+
14 rows in set (0.00 sec)

```

下面两条 SQL 语句具有相同功能，使用索引可以指定在 SELECT 关键字后地列，但是当列名变动后，也需要修改对应的索引号，不推荐使用。

```sql
SELECT prod_id, prod_price, prod_name
From products
ORDER BY prod_price, prod_name;

SELECT prod_id, prod_price, prod_name
From products
ORDER BY 2, 3;
```



### 4.2.3 指定排序方向

数据的默认排序方向是升序排序（A~Z），使用 ORDER BY 子句后接 `DESC` 关键字也可以指定降序排序（Z~A）。

下面的例子按价格以降序排序：

```sql
mysql> SELECT prod_id, prod_price, prod_name 
    -> FROM products
    -> ORDER BY prod_price DESC, prod_name;
+---------+------------+----------------+
| prod_id | prod_price | prod_name      |
+---------+------------+----------------+
| JP2000  |      55.00 | JetPack 2000   |
| SAFE    |      50.00 | Safe           |
| JP1000  |      35.00 | JetPack 1000   |
| ANV03   |      14.99 | 2 ton anvil    |
| DTNTR   |      13.00 | Detonator      |
| FB      |      10.00 | Bird seed      |
| TNT2    |      10.00 | TNT (5 sticks) |
| ANV02   |       9.99 | 1 ton anvil    |
| OL1     |       8.99 | Oil can        |
| ANV01   |       5.99 | .5 ton anvil   |
| SLING   |       4.49 | Sling          |
| FU1     |       3.42 | Fuses          |
| FC      |       2.50 | Carrots        |
| TNT1    |       2.50 | TNT (1 stick)  |
+---------+------------+----------------+
14 rows in set (0.00 sec)

```

关键字 `DESC` 仅仅作用于直接位于其前面的列名。因此 `prod_name` 依旧是升序。



## 4.3 过滤数据

### 4.3.1 WHERE 子句

在 `SELECT` 语句中，可通过 `WHERE` 子句指定搜索条件来过滤数据。

```sql
mysql> SELECT prod_name, prod_price 
    -> FROM products
    -> WHERE prod_price = 2.50;
+---------------+------------+
| prod_name     | prod_price |
+---------------+------------+
| Carrots       |       2.50 |
| TNT (1 stick) |       2.50 |
+---------------+------------+
2 rows in set (0.00 sec)

```

**WHERE 子句的位置**：`WHERE` 子句在 `FROM` 子句之后指定。当同时使用 `ORDER BY` 和 `WHERE` 子句时，确保 `ORDER BY` 跟在 `WHERE` 子句后面，否则会出现语法错误。



### 4.3.2 WHERE 子句操作符



|       操作符        |     说明     |
| :-----------------: | :----------: |
|         `=`         |     相等     |
|        `<>`         |     不等     |
|        `!=`         |     不等     |
|         `<`         |     小于     |
|        `<=`         |  小于或等于  |
|         `>`         |     大于     |
|        `>=`         |  大于或等于  |
| `BETWEEN` x `AND` y | 在两个值之间 |
|      `IS NULL`      |   空值检查   |



## 4.4 高级数据过滤

> **操作符（operator）**：在 `WHERE` 子句中用来连接或者改变子句的关键字。也被称为逻辑操作符。



| 操作符 |                 描述                 |
| :----: | :----------------------------------: |
| `AND`  |      满足所有条件的行应该被检索      |
|  `OR`  |         匹配其中某个条件的行         |
|  `IN`  | 用来指定一系列使用 `OR` 进行匹配的值 |
| `NOT`  |            否定后面的条件            |

|                WHERE 子句                 |                      描述                      |
| :---------------------------------------: | :--------------------------------------------: |
| `WHERE vend_id 1002 AND prod_price <= 10` | 查询所有供应商为 `1002` 并且价格低于 `10` 的行 |
| `WHERE vend_id = 1002 OR vend_id = 1003`  |       查询供应商为 `1002` 或 `1003` 的行       |
|      `WHERE vend_id IN (1002, 1003)`      |       查询供应商为 `1002` 或 `1003` 的行       |
|    `WHERE vend_id NOT IN (1002, 1003)`    |      查询供应商不为 `1002` 或 `1003` 的行      |



`AND` 优先级比 `OR` 优先级高，为了避免优先级导致的逻辑错误，无论何时，当你写 `WHERE` 子句时同时包含 `AND` 和 `OR` 时，显式使用括号对操作符分组。



`IN` 操作符的优点：

1. 当值列表很长时，`IN` 操作符语法更清晰易读；
2. 因为使用更少的操作符，使用 `IN` 操作符更容易管理优先级顺序；
3. `IN` 操作符执行速度相较于一系列 `OR` 操作符更快；
4. `IN` 操作符最大的优势，可以包含 `SELECT` 语句。



## 4.5 使用通配符过滤



### 4.5.1 LIKE 操作符

> **通配符（Wildcard）** ：用来匹配值的某个部分的特殊字符。

通配符实际上是在 `SQL` 的 `WHERE` 子句中有特殊含义的字符。为了在搜索语句中使用通配符，必须使用 `LIKE` 操作符。



| 通配符 |        描述        |
| :----: | :----------------: |
|  `%`   | 匹配任何数量的字符 |
|  `_`   |   仅匹配一个字符   |



|              WHERE 子句              |             描述              |
| :----------------------------------: | :---------------------------: |
|    `WHERE prod_name LIKE 'jet%'`     |  找到以单词 `jet` 开头的产品  |
| `WHERE prod_name LIKE '_ ton anvil'` | 匹配个位数 `ton anvil` 的产品 |



## 4.6 正则表达式

### 4.6.1 基本字符匹配

检索列 `prod_name` 包含文本 `1000` 的所有行：

```sql
SELECT 
    prod_name
FROM
    products
WHERE
    prod_name REGEXP '1000'
ORDER BY prod_name;

+--------------+
| prod_name    |
+--------------+
| JetPack 1000 |
+--------------+
1 row in set (0.01 sec)
```

对比使用 LIKE 通配符语句，输出 0 行：

```SQL
SELECT 
    prod_name
FROM
    products
WHERE
    prod_name LIKE '1000'
ORDER BY prod_name;

Empty set (0.00 sec)

```

`LIKE` 匹配一个完整的列。

`REGEXP` 在列中寻找匹配的值。



### 4.6.2 OR 匹配

搜索两个字符串其中任意一个，使用 `|` ：

```sql
SELECT prod_name
FROM products
WHERE prod_name REGEXP '1000|2000|3000'
ORDER BY prod_name;

+--------------+
| prod_name    |
+--------------+
| JetPack 1000 |
| JetPack 2000 |
+--------------+
2 rows in set (0.00 sec)

```



### 4.6.3 匹配多个字符中的一个

`.` 可匹配任何单一字符。如果只想匹配特定的字符，可以指定一组用 `[]` 括起来的字符来完成 。

```sql
SELECT prod_name
FROM products
WHERE prod_name REGEXP '[123]000'
ORDER BY prod_name;

+--------------+
| prod_name    |
+--------------+
| JetPack 1000 |
| JetPack 2000 |
+--------------+
2 rows in set (0.00 sec)

```

正则表达式 `[123]000` 是 `[1|2|3]000` 的缩写。

### 4.6.4 匹配范围

集合可用来定义要匹配的一个或多个字符。例如，下面的集合将匹配数字 0 到 9：

`[0123456789]` 

为了简化这种类型的集合，可使用 `-` 来定义一个范围：

`[0-9]`



```sql
SELECT prod_name
FROM products
WHERE prod_name REGEXP '[1-3]000'
ORDER BY prod_name;

+--------------+
| prod_name    |
+--------------+
| JetPack 1000 |
| JetPack 2000 |
+--------------+
2 rows in set (0.01 sec)

```



### 4.6.5 匹配特殊字符

正则表达式语言由具有特定含义的特殊字符构成。我们已经看到 `.`、 `[]`、`|` 和 `-` 等，还有其他一些字符。  

为了匹配特殊字符，必须用 `\\` 为前导。  `\\-` 表示查找 `-` ， `\\.` 表示查找 `.`  

### 4.6.6 匹配字符类

MySQL 中预定义的字符集，称为**字符类（character class）**。



|      类      |                         描述                         |
| :----------: | :--------------------------------------------------: |
| `[:alnum:]`  |         任意字母和数字（同 `[a-zA-Z0-9]` ）          |
| `[:alpha:]`  |              任意字符（同 `[a-zA-Z]` ）              |
| `[:blank:]`  |              空格和制表（同 `[\\t]` ）               |
| `[:cntrl:]`  |     ASCII控制字符（ ASCII `0` 到 `31`和 `127`）      |
| `[:digit:]`  |                任意数字（同 `[0-9]`）                |
| `[:graph:]`  |          与 `[:print:]` 相同，但不包括空格           |
| `[:lower:]`  |              任意小写字母（同 `[a-z]`）              |
| `[:print:]`  |                    任意可打印字符                    |
| `[:punct:]`  |  既不在 `[:alnum:]`又不在 `[:cntrl:]` 中的任意字符   |
| `[:space:]`  | 包括空格在内的任意空白字符（同 `[\\f\\n\\r\\t\\v]`） |
| `[:upper:]`  |              任意大写字母（同 `[A-Z]`）              |
| `[:xdigit:]` |         任意十六进制数字（同 `[a-fA-F0-9]`）         |



### 4.6.7 匹配多个实例

重复元字符



| 元字符  |                 描述                 |
| :-----: | :----------------------------------: |
|   `*`   |           `0` 个或多个匹配           |
|   `+`   |   `1` 个或多个匹配（等于 `{1,}` ）   |
|   `?`   | `0` 个或 `1` 个匹配（等于 `{0,1}` ） |
|  `{n}`  |            指定数目的匹配            |
| `{n,}`  |         不少于指定数目的匹配         |
| `{n,m}` | 匹配数目的范围（ `m` 不超过 `255`）  |



### 4.6.8 定位符



|  元字符   |    描述    |
| :-------: | :--------: |
|    `^`    | 文本的开始 |
|    `$`    | 文本的结尾 |
| `[[:<:]]` |  词的开始  |
| `[[:>:]]` |  词的结尾  |

> `^` 的双重用途： `^` 有两种用法。在集合中（用 `[]` 定义），用它来否定该集合，否则，用来指串的开始处。  





## 4.7 创建计算字段

### 4.7.1 计算字段

> 字段（Field）