DataPagination
===================


��Ŀ�� ��**DataPagination**
�ӿڣ� **INewsDao**
ȫ�ֶ���**NewsData**
�������⣺**C3P0**��**DBUtil**
**��Ŀ��������ļ�** 

----------


˵���ĵ�
-------------
**DDL_for_mysql**


    create table `ycf_db`.`news`(
        `newsTitle` VARCHAR(128) not null,
       `newsDescription` VARCHAR(512) not null,
       `newsDate` DATETIME not null,
       `newsURL` VARCHAR(256) not null
    );
