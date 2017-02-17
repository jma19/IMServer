package com.im.server.mode.db;

/**
 * Created by majun on 16/3/2.
 */
public class Assistant {
//    `pid` bigint(22) NOT NULL DEFAULT '0' COMMENT '辅导员pid',
//            `univ_id` bigint(22) NOT NULL DEFAULT '0' COMMENT '学校id',
//            `faculty_id` varchar(20) DEFAULT '' COMMENT '工号id',
//            `univ_name` varchar(50) NOT NULL DEFAULT '' COMMENT '学校名称',
//            `college_name` varchar(50) NOT NULL DEFAULT '' COMMENT '学院名称',
//            `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号码',
//            `phone_bak` varchar(20) DEFAULT '' COMMENT '备用手机号码',
//            `univ_code` varchar(20) NOT NULL DEFAULT '' COMMENT '学校code',
//            `univ_address` varchar(255) NOT NULL DEFAULT '' COMMENT '学校地址',
//            `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注:2010级辅导员',
//            `head_url` varchar(50) NOT NULL DEFAULT '' COMMENT 'head pic url',
//            `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//            `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    private Long pid;
    private Long univId;
    private String univName;
    private String collegeName;
    private String phone;
    private String phoneBak;
    private String univCode;
    private String univAddress;
    private String remark;
    private String headUrl;



}



