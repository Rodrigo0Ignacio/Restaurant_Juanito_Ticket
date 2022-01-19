-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-01-2022 a las 01:23:37
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `juanito`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `filtro_fechas` (IN `fecha_inicio` DATETIME, IN `fecha_final` DATETIME)  SELECT DISTINCT fecha_hora, id_ticket, nro_mesa, valor_total FROM ticket WHERE CAST(fecha_hora AS DATE) BETWEEN fecha_inicio and fecha_final$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`password`) VALUES
('uix86.dll');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_cat` int(11) NOT NULL,
  `categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_cat`, `categoria`) VALUES
(7, 'Acompañamiento'),
(10, 'Aperitivos'),
(8, 'Bebidas'),
(14, 'Bebidas Calientes'),
(13, 'Empanadas'),
(5, 'Entradas'),
(11, 'Postres'),
(6, 'Principales'),
(9, 'Salsas'),
(12, 'Sandwich');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `id_comida` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `fk_categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`id_comida`, `nombre`, `precio`, `descripcion`, `fk_categoria`) VALUES
(1, 'Empanadas de queso', 1600, NULL, 'Entradas'),
(2, 'Empanadas de marisco', 2100, NULL, 'Entradas'),
(3, 'ceviche tradicional', 6600, NULL, 'Entradas'),
(4, 'ceviche mixto (camaron pulto)', 7500, NULL, 'Entradas'),
(5, 'ceviche juanito', 9800, NULL, 'Entradas'),
(6, 'camaron al til-til', 8900, NULL, 'Entradas'),
(7, 'ensalada de camarones', 8900, NULL, 'Entradas'),
(8, 'mariscal frio', 9800, NULL, 'Entradas'),
(9, 'ostiones parmesano', 10500, NULL, 'Entradas'),
(10, 'locos mayo', 13500, NULL, 'Entradas'),
(12, 'Empanadas de camaron queso', 2300, NULL, 'Entradas'),
(16, 'pastel de jaiba', 9800, NULL, 'Principales'),
(17, 'chupe de marisco', 8900, NULL, 'Principales'),
(18, 'chupe de camaron', 8900, NULL, 'Principales'),
(19, 'chupe de locos', 13500, NULL, 'Principales'),
(20, 'paila mariscal', 6800, NULL, 'Principales'),
(21, 'caldillo de congrio', 8500, NULL, 'Principales'),
(22, 'caldillo de congrio nerudiano', 10500, NULL, 'Principales'),
(23, 'caldillo de congrio tradicional', 10500, NULL, 'Principales'),
(24, 'pulpo a la plancha', 9800, NULL, 'Principales'),
(25, 'tallarin salteado de camarones', 8900, NULL, 'Principales'),
(26, 'merluza con dos agregados', 4900, NULL, 'Principales'),
(27, 'reineta con 2 agregados', 7500, NULL, 'Principales'),
(28, 'congrio con 2 agregados', 11500, NULL, 'Principales'),
(29, 'atun con 2 agregados', 11000, NULL, 'Principales'),
(30, 'salmon con 2 agregados', 9200, NULL, 'Principales'),
(31, 'Ensalada mixta para uno', 2500, NULL, 'Acompañamiento'),
(32, 'ensalada mixta familiar', 3800, NULL, 'Acompañamiento'),
(33, 'arroz', 1800, NULL, 'Acompañamiento'),
(34, 'pure', 2400, NULL, 'Acompañamiento'),
(35, 'papas fritas pequeñas', 3000, NULL, 'Acompañamiento'),
(36, 'papas fritas grandes', 4800, NULL, 'Acompañamiento'),
(37, 'lomo con 2 agregados', 10500, NULL, 'Acompañamiento'),
(38, 'pollo a la planca con', 5500, NULL, 'Acompañamiento'),
(39, 'menu niños nuggetys', 3500, NULL, 'Acompañamiento'),
(40, 'Bebida lata', 1500, NULL, 'Bebidas'),
(41, 'bebida familiar', 2400, NULL, 'Bebidas'),
(42, 'jugo natural 1/2L', 2200, NULL, 'Bebidas'),
(43, 'Escudo 500CC', 2500, NULL, 'Bebidas'),
(44, 'cusqueña 500CC', 3000, NULL, 'Bebidas'),
(45, 'budwriser 500CC', 3000, NULL, 'Bebidas'),
(46, 'heineken 500CC', 3000, NULL, 'Bebidas'),
(47, 'Salsa de camaron', 2000, NULL, 'Salsas'),
(48, 'Salsa margarita', 2200, NULL, 'Salsas'),
(49, 'salsa de champignon', 1800, NULL, 'Salsas'),
(50, 'salsa de roquefotr', 2800, NULL, 'Salsas'),
(51, 'Papayas con crema', 3800, NULL, 'Postres'),
(52, 'helados', 2800, NULL, 'Postres'),
(53, 'Aperol spritz', 4500, NULL, 'Aperitivos'),
(54, 'pisco sour', 2800, NULL, 'Aperitivos'),
(55, 'vaina', 2800, NULL, 'Aperitivos'),
(56, 'whisky sour', 4600, NULL, 'Aperitivos'),
(57, 'Sandwich de pescado', 5500, 'filete de pescado con hojas de lechuga, tomate, cebolla y mayonesa en marraqueta', 'Sandwich'),
(58, 'Hamburguesa doble con queso', 3800, 'pan frica con hamburguesa, 2 huevos fritos y acompañado de papas fritas', 'Sandwich'),
(59, 'Hamburguesa chemilico', 3500, 'pan frica con hamburguesa, 2 huevos fritos y caompañado de papas fritas', 'Sandwich'),
(60, 'Hamburguesa de la casa', 3800, 'pan frica con hamburguesa, lechuga, tomate, queso, mayonesa y acompañado de papas fritas', 'Sandwich'),
(61, 'Te o café', 1200, NULL, 'Bebidas Calientes'),
(62, 'Leche', 1500, NULL, 'Bebidas Calientes'),
(63, 'Jugo natural 1/2Litro', 2200, NULL, 'Bebidas Calientes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `despachos`
--

CREATE TABLE `despachos` (
  `id_comidad` int(11) NOT NULL,
  `precio_unitario` int(11) NOT NULL,
  `id_ticketd` varchar(50) NOT NULL,
  `plato` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `despachos`
--

INSERT INTO `despachos` (`id_comidad`, `precio_unitario`, `id_ticketd`, `plato`) VALUES
(53, 2000, 'EEE12121', 'Aperol spritz'),
(33, 8000, 'EEE12121', 'Aroz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `id_ticket` varchar(50) NOT NULL,
  `nro_mesa` int(11) NOT NULL,
  `valor_total` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`id_ticket`, `nro_mesa`, `valor_total`, `cantidad`, `fecha_hora`) VALUES
('123123er543rqra4', 3, 89000, 34, '2022-01-07 06:06:27'),
('234342423wedwrfwqe', 98, 55000, 32, '2022-01-07 06:06:27'),
('234qre1qq2r3q2r3q2r', 98, 96000, 3, '2022-01-07 16:06:27'),
('23er32r23r', 89, 78000, 34, '2022-01-07 19:06:27'),
('3123123', 3, 34000, 2, '2022-01-07 04:06:27'),
('31231241423142342', 3, 45000, 12, '2022-01-07 04:03:27'),
('3242w3e4rwerwerwe', 89, 9600, 2, '2022-01-07 21:06:27'),
('3424214', 12, 57000, 23, '2022-01-06 04:06:27'),
('3dr2rd3rdf2ewr2w', 98, 25000, 32, '2022-01-09 00:06:27'),
('423423rwef34', 33, 89000, 23, '2022-01-07 10:20:35'),
('423424r2rewfwfe', 98, 34000, 4, '2022-01-08 11:06:27'),
('43214324', 98, 3000, 1, '2022-01-07 21:06:27'),
('43223r3rq2rq23', 23, 87000, 33, '2022-01-07 08:06:27'),
('432413432413242werwe', 3, 98000, 23, '2022-01-06 11:26:27'),
('89oo89o89', 8, 9000, 8000, '2022-01-07 04:24:09'),
('dqwdqwdqwdqwdqw', 98, 45000, 8, '2022-01-08 01:06:27'),
('EEE12121', 2, 8000, 80, '2022-01-06 03:50:35'),
('eerere343', 3, 9000, 4, '2022-01-07 04:06:27'),
('ERR333', 432, 9000, 23, '2022-01-06 06:50:51'),
('erwrf34r34qrerf3q4rf3arf', 98, 98000, 32, '2022-01-08 04:06:01'),
('fewfwefwe432f334f43', 89, 6000, 6, '2022-01-07 04:24:09'),
('rfwef3fag43t34qga', 89, 55000, 31, '2022-01-07 10:06:27'),
('tgar4etgergt45t43', 98, 90000, 9, '2022-01-09 04:06:27'),
('werwerwerr234', 3, 8500, 0, '2022-01-07 04:06:27');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_cat`),
  ADD UNIQUE KEY `categoria` (`categoria`);

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`id_comida`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD KEY `FK_comida` (`fk_categoria`),
  ADD KEY `fk_categoria` (`fk_categoria`);

--
-- Indices de la tabla `despachos`
--
ALTER TABLE `despachos`
  ADD KEY `id_comidad` (`id_comidad`) USING BTREE,
  ADD KEY `id_ticketd` (`id_ticketd`),
  ADD KEY `plato` (`plato`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id_ticket`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comida`
--
ALTER TABLE `comida`
  MODIFY `id_comida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comida`
--
ALTER TABLE `comida`
  ADD CONSTRAINT `FK_comida` FOREIGN KEY (`fk_categoria`) REFERENCES `categoria` (`categoria`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `despachos`
--
ALTER TABLE `despachos`
  ADD CONSTRAINT `FK2_despachos` FOREIGN KEY (`id_comidad`) REFERENCES `comida` (`id_comida`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_despachos` FOREIGN KEY (`id_ticketd`) REFERENCES `ticket` (`id_ticket`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `despachos_ibfk_2` FOREIGN KEY (`id_comidad`) REFERENCES `comida` (`id_comida`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
