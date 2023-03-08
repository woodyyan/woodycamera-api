-- DROP TABLE IF EXISTS model;
--
-- CREATE TABLE model (
--                               id INT AUTO_INCREMENT  PRIMARY KEY,
--                               index INT DEFAULT 0 NOT NULL,
--                               model_name VARCHAR(50) NOT NULL,
--                               city VARCHAR(50) NOT NULL,
--                               date VARCHAR(50) DEFAULT NULL
-- );
--

-- INSERT INTO model (index, model_name, city, date, tags) VALUES
--                                                              (1, '九九诗', '深圳', '2022-1-1', '日系|阳光|夏日|小淸新'),
--                                                              (2, 'Doctor', '成都', '2022-9-3', '夜景|情绪');

-- insert into image (model_id, url) values
--                                       ( 2, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/docter2022070101.JPG'),
--         (2, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/docter2022070102.JPG'),
--         (2, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/docter2022070103.JPG'),
--         (2, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/docter2022070104.JPG'),
--         (2, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/docter2022070105.JPG'),
--         (2, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/docter2022070106.JPG'),
--         (2, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/docter2022070107.JPG'),
--         (2, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/docter2022070108.JPG'),
--         (2, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/docter2022070109.JPG');


-- insert into image (model_id, url)
-- values (1, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/jiujiushi2022070301.JPG'),
--        (1, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/jiujiushi2022070302.JPG'),
--        (1, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/jiujiushi2022070303.JPG'),
--        (1, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/jiujiushi2022070304.JPG'),
--        (1, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/jiujiushi2022070305.JPG'),
--        (1, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/jiujiushi2022070306.JPG'),
--        (1, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/jiujiushi2022070307.JPG'),
--        (1, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/jiujiushi2022070308.JPG'),
--        (1, 'https://woodycamera-1256194296.cos.ap-guangzhou.myqcloud.com/photos/jiujiushi2022070309.JPG');