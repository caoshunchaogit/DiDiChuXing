/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : feidichuxing

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 10/08/2022 21:04:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for passenger_user
-- ----------------------------
DROP TABLE IF EXISTS `passenger_user`;
CREATE TABLE `passenger_user`  (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `passenger_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '乘客手机号',
  `passenger_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '乘客姓名',
  `passenger_gender` tinyint(1) NULL DEFAULT NULL COMMENT '乘客的性别 0女 1男',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '乘客的状态 0正常 1暂停',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1557351595946053634 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of passenger_user
-- ----------------------------
INSERT INTO `passenger_user` VALUES (1557349559762456577, '2022-08-10 20:54:04', '2022-08-10 20:54:04', '18145664515', '张三', 0, 0);
INSERT INTO `passenger_user` VALUES (1557351595946053633, '2022-08-10 21:02:09', '2022-08-10 21:02:09', '18650887487', '张三', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
