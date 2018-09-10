create table invitation_card.invitation_card_info
(
	invitation_card_info_id varchar(36) not null comment '请柬信息ID'
		primary key,
	man_name varchar(100) null comment '男方姓名',
	woman_name varchar(100) null comment '女方姓名',
	wedding_date date null comment '婚礼举行日期',
	lunar_calendar varchar(30) null comment '农历',
	hotel_name varchar(100) null comment '酒店名称',
	address varchar(300) null comment '婚礼地址',
	share_name varchar(100) null comment '分享名称',
	thumb_content varchar(100) null comment '分享内容',
	thumb_url varchar(150) null comment '分享图片URL',
	man_tel varchar(11) null comment '男方手机号码',
	woman_tel varchar(11) null comment '女方手机号',
	longitude varchar(50) null comment '经度',
	latitude varchar(50) null comment '纬度',
	create_time datetime null comment '创建时间',
	update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间',
	app_id varchar(36) null
)
comment '请柬信息'
;

create table invitation_card.blessing_info
(
	blessing_id varchar(36) null comment '祝福ID',
	invitation_card_info_id varchar(36) null comment '请柬ID',
	blessing_name varchar(200) null comment '祝福人姓名',
	blessing_head_portrait varchar(300) null comment '祝福人头像',
	create_time datetime null comment '创建时间',
	update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间'
)
comment '祝福'
;


create table invitation_card.invitation_album
(
	album_id varchar(36) not null comment '请柬照片信息ID'
		primary key,
	invitation_card_info_id varchar(36) null comment '请柬信息ID',
	album_url varchar(400) null comment '照片URL',
	create_time datetime null comment '创建时间',
	update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间'
)
comment '请柬照片信息'
;


create table invitation_card.invitation_music
(
	music_id varchar(36) not null comment '请柬音乐ID'
		primary key,
	invitation_card_info_id varchar(36) null comment '请柬信息ID',
	music_url varchar(500) null comment '请柬音乐URL',
	create_time date null comment '创建时间',
	update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间'
)
comment '请柬音乐'
;


create table invitation_card.leaving_message
(
	leaving_message_id varchar(36) not null
		primary key,
	invitation_card_info_id varchar(36) null,
	leaving_name varchar(300) null comment '留言人姓名',
	leaving_content varchar(500) null comment '留言内容',
	leaving_url varchar(200) null comment '留言人头像',
	create_time datetime null comment '创建时间',
	update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间'
)
comment '留言'
;