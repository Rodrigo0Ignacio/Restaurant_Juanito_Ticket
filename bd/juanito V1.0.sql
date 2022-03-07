-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-03-2022 a las 09:42:07
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
('progamador117'),
('uix86.dll');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cap_datos`
--

CREATE TABLE `cap_datos` (
  `id_datos` int(11) NOT NULL,
  `comanda_ref` varchar(100) NOT NULL,
  `mesa_ref` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cap_datos`
--

INSERT INTO `cap_datos` (`id_datos`, `comanda_ref`, `mesa_ref`) VALUES
(19, '6A31E885D5-P', 3),
(20, 'FD7C10DCC3-O', 9),
(21, '1C1F3CF111-Z', 14),
(22, 'B7C2F52B9B-I', 9),
(23, '86B04BBD0F-R', 4),
(24, '405BC6C4E4-N', 20);

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
-- Estructura de tabla para la tabla `comanda`
--

CREATE TABLE `comanda` (
  `id_comanda` varchar(100) NOT NULL,
  `precio_unitario` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `plato` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `importe` int(11) NOT NULL,
  `fk_comida` int(11) NOT NULL,
  `fk_mesa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comanda`
--

INSERT INTO `comanda` (`id_comanda`, `precio_unitario`, `fecha_hora`, `plato`, `cantidad`, `importe`, `fk_comida`, `fk_mesa`) VALUES
('D36C502FA0-G', 1800, '2022-03-07 06:51:17', 'arroz', 5, 9000, 33, 9),
('D36C502FA0-G', 4800, '2022-03-07 06:51:17', 'papas fritas grandes', 3, 14400, 36, 9),
('D36C502FA0-G', 3000, '2022-03-07 06:51:17', 'papas fritas pequeñas', 3, 9000, 35, 9),
('D36C502FA0-G', 3500, '2022-03-07 06:51:17', 'menu niños nuggetys', 3, 10500, 39, 9),
('CFEECFED0C-U', 10500, '2022-03-07 06:59:07', 'caldillo de congrio nerudiano', 2, 21000, 22, 9),
('CFEECFED0C-U', 13500, '2022-03-07 06:59:07', 'chupe de locos', 2, 27000, 19, 9),
('B3FDEE7770-L', 8900, '2022-03-07 07:02:11', 'chupe de camaron', 3, 26700, 18, 9),
('B3FDEE7770-L', 13500, '2022-03-07 07:02:11', 'chupe de locos', 6, 81000, 19, 9),
('6A31E885D5-P', 1800, '2022-03-07 07:04:35', 'arroz', 4, 7200, 33, 3),
('6A31E885D5-P', 5500, '2022-03-07 07:04:35', 'pollo a la planca con', 3, 16500, 38, 3),
('6A31E885D5-P', 2400, '2022-03-07 07:04:35', 'pure', 3, 7200, 34, 3),
('FD7C10DCC3-O', 2800, '2022-03-07 07:05:06', 'helados', 3, 8400, 52, 9),
('FD7C10DCC3-O', 3800, '2022-03-07 07:05:06', 'Papayas con crema', 2, 7600, 51, 9),
('1C1F3CF111-Z', 8900, '2022-03-07 07:05:40', 'camaron al til-til', 3, 26700, 6, 14),
('1C1F3CF111-Z', 8900, '2022-03-07 07:05:40', 'ensalada de camarones', 4, 35600, 7, 14),
('B7C2F52B9B-I', 2800, '2022-03-07 07:06:31', 'helados', 3, 8400, 52, 9),
('B7C2F52B9B-I', 3800, '2022-03-07 07:06:31', 'Papayas con crema', 2, 7600, 51, 9),
('B7C2F52B9B-I', 2800, '2022-03-07 07:06:31', 'pisco sour', 2, 5600, 54, 9),
('86B04BBD0F-R', 10500, '2022-03-07 07:09:18', 'caldillo de congrio nerudiano', 3, 31500, 22, 4),
('86B04BBD0F-R', 8500, '2022-03-07 07:09:18', 'caldillo de congrio', 3, 25500, 21, 4),
('405BC6C4E4-N', 10500, '2022-03-07 07:11:05', 'caldillo de congrio nerudiano', 3, 31500, 22, 20);

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
-- Estructura de tabla para la tabla `mesa`
--

CREATE TABLE `mesa` (
  `id_mesa` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL
) ;

--
-- Volcado de datos para la tabla `mesa`
--

INSERT INTO `mesa` (`id_mesa`, `estado`) VALUES
(1, 'Disponible'),
(2, 'Disponible'),
(3, 'Disponible'),
(4, 'Ocupado'),
(5, 'Disponible'),
(6, 'Disponible'),
(7, 'Disponible'),
(8, 'Disponible'),
(9, 'Ocupado'),
(10, 'Disponible'),
(11, 'Disponible'),
(12, 'Disponible'),
(13, 'Disponible'),
(14, 'Ocupado'),
(15, 'Disponible'),
(16, 'Disponible'),
(17, 'Disponible'),
(18, 'Disponible'),
(19, 'Disponible'),
(20, 'Disponible'),
(21, 'Disponible'),
(22, 'Disponible'),
(23, 'Disponible'),
(24, 'Disponible');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pre_boleta`
--

CREATE TABLE `pre_boleta` (
  `id_boleta` varchar(100) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `total` int(11) NOT NULL,
  `propina` int(11) NOT NULL,
  `fk_mesa` int(11) NOT NULL,
  `fk_comanda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cap_datos`
--
ALTER TABLE `cap_datos`
  ADD PRIMARY KEY (`id_datos`),
  ADD UNIQUE KEY `fk_comanda_2` (`comanda_ref`),
  ADD KEY `fk_comanda` (`comanda_ref`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_cat`),
  ADD UNIQUE KEY `categoria` (`categoria`);

--
-- Indices de la tabla `comanda`
--
ALTER TABLE `comanda`
  ADD KEY `id_comanda` (`id_comanda`),
  ADD KEY `fk_comida` (`fk_comida`),
  ADD KEY `fk_mesa` (`fk_mesa`);

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`id_comida`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD KEY `fk_categoria_2` (`fk_categoria`);

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`id_mesa`);

--
-- Indices de la tabla `pre_boleta`
--
ALTER TABLE `pre_boleta`
  ADD PRIMARY KEY (`id_boleta`),
  ADD KEY `fk_comanda` (`fk_comanda`),
  ADD KEY `fk_mesa` (`fk_mesa`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cap_datos`
--
ALTER TABLE `cap_datos`
  MODIFY `id_datos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `mesa`
--
ALTER TABLE `mesa`
  MODIFY `id_mesa` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comanda`
--
ALTER TABLE `comanda`
  ADD CONSTRAINT `fk_comanda1` FOREIGN KEY (`fk_comida`) REFERENCES `comida` (`id_comida`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_comanda2` FOREIGN KEY (`fk_mesa`) REFERENCES `mesa` (`id_mesa`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `comida`
--
ALTER TABLE `comida`
  ADD CONSTRAINT `fk_comida` FOREIGN KEY (`fk_categoria`) REFERENCES `categoria` (`categoria`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
