CREATE TABLE permission (
  id_ VARCHAR(32) PRIMARY KEY,
  name_ VARCHAR(30)
);

INSERT INTO permission VALUES('8bbff9a36392483b8a2496f5d036ef1a', 'user_manager');
INSERT INTO permission VALUES('e29011e629ba446e90d63d0d91812bc1', 'info_manager');
INSERT INTO permission VALUES('f596d188e1c64ec9affa224401eb5d69', 'news_manager');
INSERT INTO permission VALUES('fc40bb298cca4a8f8a877d28d95781e1', 'notice_manager');
INSERT INTO permission VALUES('9da32566654449faa4e654dbfdafc920', 'activity_manager');
INSERT INTO permission VALUES('ac5e7c2c6c6443e1a5d5073323c57800', 'topic_manager');

CREATE TABLE role (
  id_ VARCHAR(32) PRIMARY KEY,
  name_ VARCHAR(30),
  permission_ids_ TEXT
);

INSERT INTO role VALUES('a6ae79cace744ec08f1bc506de066e37', 'admin', '8bbff9a36392483b8a2496f5d036ef1a,e29011e629ba446e90d63d0d91812bc1,f596d188e1c64ec9affa224401eb5d69,fc40bb298cca4a8f8a877d28d95781e1,9da32566654449faa4e654dbfdafc920,ac5e7c2c6c6443e1a5d5073323c57800');
INSERT INTO role VALUES('bcd14ce4680942dc83acd9d42d4ead76', 'charge_user', 'fc40bb298cca4a8f8a877d28d95781e1,9da32566654449faa4e654dbfdafc920');
INSERT INTO role VALUES('2f58614346604c1383c6d9aca063f01d', 'ordinary_user', '');

CREATE TABLE user (
  id_ VARCHAR(32) PRIMARY KEY,
  number_ VARCHAR(12),
  name_ VARCHAR(30),
  sex_ INT,
  classes_ VARCHAR(20),
  contact_way_ VARCHAR(11),
  role_id_ VARCHAR(32),
  password_ VARCHAR(32),
  association_ids_ TEXT
);

INSERT INTO user(id_, number_, name_, role_id_, password_) VALUES('5dcfa6656e864bd9aacda2464548ce1b', 'admin', 'admin', 'a6ae79cace744ec08f1bc506de066e37', 'f4847d8ba3aa1fb1688de08921c18948');

CREATE TABLE notice (
  id_ VARCHAR(32) PRIMARY KEY,
  title_ VARCHAR(40),
  content_ TEXT,
  date_ TIMESTAMP,
  author_id_ VARCHAR(32),
  file_paths_ TEXT,
  association_id_ VARCHAR(32)
);

CREATE TABLE info (
  id_ VARCHAR(32) PRIMARY KEY,
  name_ VARCHAR(30),
  info_ VARCHAR(512),
  charity_id_ VARCHAR(32)
);

CREATE TABLE activity (
  id_ VARCHAR(32) PRIMARY KEY,
  title_ VARCHAR(40),
  content_ TEXT,
  author_id_ VARCHAR(32),
  file_paths_ TEXT,
  participantors_ TEXT,
  apply_up_ INT,
  apply_start_time_ TIMESTAMP,
  apply_end_time_ TIMESTAMP,
  labels_ TEXT,
  association_id_ VARCHAR(32)
);

CREATE TABLE news (
  id_ VARCHAR(32) PRIMARY KEY,
  title_ VARCHAR(40),
  content_ TEXT,
  date_ TIMESTAMP,
  author_id_ VARCHAR(32),
  clicks_ INT,
  important_ INT,
  important_img_path_ VARCHAR(256)
);

CREATE TABLE topic (
  id_ VARCHAR(32) PRIMARY KEY,
  content_ TEXT,
  date_ TIMESTAMP,
  author_id_ VARCHAR(32),
  labels_ TEXT
);

CREATE TABLE post (
  id_ VARCHAR(32) PRIMARY KEY,
  content_ TEXT,
  date_ TIMESTAMP,
  author_id_ VARCHAR(32),
  topic_ids_ TEXT,
  img_paths_ TEXT
);

CREATE TABLE COMMENT (
  id_ VARCHAR(32) PRIMARY KEY,
  content_ TEXT,
  date_ TIMESTAMP,
  author_id_ VARCHAR(32),
  post_id_ VARCHAR(32)
);

CREATE TABLE up (
  author_id_ VARCHAR(32),
  post_id_ VARCHAR(32)
);