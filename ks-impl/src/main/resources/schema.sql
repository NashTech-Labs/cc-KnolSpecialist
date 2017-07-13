CREATE TABLE IF NOT EXISTS technology (
  id int PRIMARY KEY,
  name VARCHAR(12),
  url VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS specialist (
  id BIGSERIAL PRIMARY KEY,
  knolder_name VARCHAR(12),
   skill_percentage FLOAT,
   technology_id INT
);


insert into technology values(1, 'Spark', 'https://spark.apache.org/docs/latest/img/spark-logo-hd.png');
insert into technology values(2, 'Akka', 'http://whatpixel.com/images/2016/10/00-akka-logo-design.jpg');
insert into technology values(3, 'Angular JS', 'https://angular.io/assets/images/logos/angularjs/AngularJS-Shield.svg');
insert into technology values(4, 'Play Framework', 'https://www.playframework.com/assets/images/logos/play_full_color.png');
insert into technology values(5, 'Lagom', 'https://blog.scalac.io/images/logom.png');
insert into technology values(6, 'Flink', 'https://flink.apache.org/img/logo/png/1000/flink_squirrel_1000.png');
insert into technology values(7, 'NodeJs', 'https://dab1nmslvvntp.cloudfront.net/wp-content/uploads/2015/07/1436439824nodejs-logo.png');
insert into technology values(8, 'Docker', 'https://d262ilb51hltx0.cloudfront.net/max/1600/1*_MtS4HqN2srTcrSyet61DQ.jpeg');

insert into specialist values(1, 'Himanshu', 99.9, 1);
insert into specialist values(2, 'Anuj', 60.9, 1);
insert into specialist values(3, 'Mahesh', 59.9, 1);
insert into specialist values(4, 'Siddharth', 90.9, 2);
insert into specialist values(5, 'Girish', 90.9, 2);
insert into specialist values(6, 'Ashu', 90.9, 3);
insert into specialist values(7, 'Nikhil', 90.9, 3);
insert into specialist values(8, 'Akshay', 90.9, 3);
insert into specialist values(9, 'Sahil', 70.9, 4);
insert into specialist values(10, 'Sangeeta', 70.9, 4);
insert into specialist values(11, 'Anmol', 70.9, 5);
insert into specialist values(12, 'Deepak', 70.9, 5);
insert into specialist values(13, 'Prabhat', 70.9, 6);
insert into specialist values(14, 'Nikhil', 70.9, 7);
insert into specialist values(15, 'Akshay', 70.9, 7);
insert into specialist values(16, 'Piyush', 70.9, 8);
insert into specialist values(17, 'Harmeet', 70.9, 8);






CREATE TABLE IF NOT EXISTS knolder (
  id int PRIMARY KEY,
  k_name VARCHAR(40),
  k_desg VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS expert (
  t_id int PRIMARY KEY,
  k_id int,
  skill_level int
);
