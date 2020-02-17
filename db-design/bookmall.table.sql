
-- 数据库名称 bookmall
use bookMallbookmall;

-- 地址表
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `open_id` varchar(255) NOT NULL COMMENT '关联user表的唯一标识',
  `address` varchar(255) NOT NULL COMMENT '地址',
  `mobile_no` varchar(11) NOT NULL COMMENT '手机号',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_oi` (`open_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 商品表
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '商品名称',
  `price` double NOT NULL COMMENT '商品价格',
  `number` int(255) DEFAULT '0' COMMENT '商品数量',
  `kind` varchar(45) NOT NULL COMMENT '商品种类',
  `image` varchar(300) NOT NULL COMMENT '商品图片',
  `status` varchar(45) NOT NULL COMMENT '商品状态',
  `isbn` bigint(20) NOT NULL DEFAULT '0' COMMENT '书号，或唯一标识',
  `remark` varchar(999) DEFAULT NULL COMMENT '商品备注',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_un_nk` (`name`,`kind`),
  KEY `idx_name` (`name`) USING BTREE,
  KEY `idx_kind` (`kind`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 种类表
CREATE TABLE `kind` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '类别名称',
  `image` varchar(255) NOT NULL COMMENT '类别图片',
  `create_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 订单表
CREATE TABLE `order_t` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(255) NOT NULL COMMENT '关联用户表唯一标识',
  `address_id` bigint(20) NOT NULL COMMENT '地址id',
  `goods_name` varchar(45) NOT NULL COMMENT '关联商品名称',
  `goods_kind` varchar(45) NOT NULL COMMENT '关联商品种类',
  `status` varchar(45) NOT NULL COMMENT '订单状态，未付款，已付款，已发货，已收货',
  `number` int(11) DEFAULT NULL COMMENT '商品数量',
  `price` double DEFAULT NULL COMMENT '商品总价',
  `price_total` double DEFAULT NULL,
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_sta` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 收书表
CREATE TABLE `recycle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '收书的名称',
  `number` int(5) NOT NULL COMMENT '收书的数量',
  `open_id` varchar(255) NOT NULL COMMENT '关联用户表的唯一标识',
  `kind_id` bigint(20) NOT NULL COMMENT '种类id',
  `kind_name` varchar(45) NOT NULL COMMENT '种类名称',
  `seller` varchar(45) NOT NULL COMMENT '卖家姓名',
  `mobile_no` varchar(45) NOT NULL COMMENT '卖家联系方式',
  `address` varchar(255) NOT NULL COMMENT '上门收书的地址',
  `isbn` bigint(20) NOT NULL,
  `status` varchar(45) NOT NULL COMMENT '确认状态：是否以添加到库存。已添加、未添加',
  `create_time` bigint(13) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_oi` (`open_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 用户表
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '用户姓名',
  `image` varchar(255) NOT NULL COMMENT '用户头像url',
  `open_id` varchar(255) NOT NULL COMMENT '用户的open_id',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_oi` (`open_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

