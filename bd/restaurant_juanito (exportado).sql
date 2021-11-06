-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-11-2021 a las 22:31:42
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
-- Base de datos: `restaurant_juanito`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_cat` int(11) NOT NULL,
  `categoria` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_cat`, `categoria`) VALUES
(5, 'Entradas'),
(6, 'Principales'),
(7, 'Acompañamiento'),
(8, 'Bebidas'),
(9, 'Salsas'),
(10, 'Aperitivos'),
(11, 'Postres'),
(12, 'Sandwich'),
(13, 'Empanadas'),
(14, 'Bebidas Calientes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `id_comida` int(11) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`id_comida`, `categoria`, `nombre`, `precio`, `descripcion`) VALUES
(5, 'Entradas', 'Empanadas de queso', '1600', NULL),
(12, 'Entradas', 'Empanadas de queso', '1600', NULL),
(13, 'Entradas', 'Empanadas de marisco', '2100', NULL),
(14, 'Entradas', 'Empanadas de camaron queso', '2300', NULL),
(15, 'Entradas', 'ceviche tradicional', '6600', NULL),
(16, 'Entradas', 'ceviche mixto (camaron pulto)', '7500', NULL),
(17, 'Entradas', 'ceviche juanito', '9800', NULL),
(18, 'Entradas', 'camaron al til-til', '8900', NULL),
(19, 'Entradas', 'ensalada de camarones', '8900', NULL),
(20, 'Entradas', 'mariscal frio', '9800', NULL),
(21, 'Entradas', 'ostiones parmesano', '10500', NULL),
(22, 'Entradas', 'locos mayo', '13500', NULL),
(23, 'Principales', 'pastel de jaiba', '9800', NULL),
(24, 'Principales', 'chupe de marisco', '8900', NULL),
(25, 'Principales', 'chupe de camaron', '8900', NULL),
(26, 'Principales', 'chupe de locos', '13500', NULL),
(27, 'Principales', 'paila mariscal', '6800', NULL),
(28, 'Principales', 'caldillo de congrio', '8500', NULL),
(29, 'Principales', 'caldillo de congrio nerudiano', '10500', NULL),
(30, 'Principales', 'caldillo de congrio tradicional', '10500', NULL),
(31, 'Principales', 'pulpo a la plancha', '9800', NULL),
(32, 'Principales', 'tallarin salteado de camarones', '8900', NULL),
(33, 'Principales', 'merluza con dos agregados', '4900', NULL),
(34, 'Principales', 'reineta con 2 agregados', '7500', NULL),
(35, 'Principales', 'congrio con 2 agregados', '11500', NULL),
(36, 'Principales', 'atun con 2 agregados', '11000', NULL),
(37, 'Principales', 'salmon con 2 agregados', '9200', NULL),
(38, 'Acompañamiento', 'Ensalada mixta para uno', '2500', NULL),
(39, 'Acompañamiento', 'ensalada mixta familiar', '3800', NULL),
(40, 'Acompañamiento', 'arroz', '1800', NULL),
(41, 'Acompañamiento', 'pure', '2400', NULL),
(42, 'Acompañamiento', 'papas fritas pequeñas', '3000', NULL),
(43, 'Acompañamiento', 'papas fritas grandes', '4800', NULL),
(44, 'Acompañamiento', 'lomo con 2 agregados', '10500', NULL),
(45, 'Acompañamiento', 'pollo a la planca con', '5500', NULL),
(46, 'Acompañamiento', 'menu niños nuggetys', '3500', NULL),
(47, 'Bebidas', 'Bebida lata', '1500', NULL),
(48, 'Bebidas', 'Bebida familiar', '2400', NULL),
(49, 'Bebidas', 'Escudo 500CC', '2500', NULL),
(50, 'Bebidas', 'jugo natural 1/2L', '2200', NULL),
(51, 'Bebidas', 'cusqueña 500CC', '3000', NULL),
(52, 'Bebidas', 'heineken 500CC', '3000', NULL),
(53, 'Salsas', 'Salsa de camaron', '2000', NULL),
(54, 'Salsas', 'Salsa margarita', '2200', NULL),
(55, 'Salsas', 'salsa de champignon', '1800', NULL),
(56, 'Salsas', 'salsa de roquefort', '2800', NULL),
(57, 'Aperitivos', 'Aperol spritz', '4500', NULL),
(58, 'Aperitivos', 'pisco sour', '2800', NULL),
(59, 'Aperitivos', 'vaina', '2800', NULL),
(60, 'Aperitivos', 'whisky sour', '4600', NULL),
(61, 'Postres', 'Papayas con crema', '3800', NULL),
(62, 'Postres', 'helados', '2800', NULL),
(63, 'Sandwich', 'Sandwich de pescado', '5500', 'filete de pescado con hojas de lechuga, tomate, cebolla y mayonesa en marraqueta'),
(64, 'Sandwich', 'Hamburguesa doble con queso', '3800', 'pan frica con hamburguesa, 2 huevos fritos y acompañado de papas fritas'),
(65, 'Sandwich', 'Hamburguesa chemilico', '3500', 'pan frica con hamburguesa, 2 huevos fritos y caompañado de papas fritas'),
(66, 'Sandwich', 'Hamburguesa de la casa', '3800', 'pan frica con hamburguesa, lechuga, tomate, queso, mayonesa y acompañado de papas fritas'),
(67, 'Empanadas', 'queso', '1600', NULL),
(68, 'Empanadas', 'mariscos', '2100', NULL),
(69, 'Empanadas', 'camaron queso', '1600', NULL),
(70, 'Empanadas', 'queso', '2300', NULL),
(71, 'Bebidas Calientes', 'Te', '1200', NULL),
(72, 'Bebidas Calientes', 'Cafe', '1200', NULL),
(73, 'Bebidas Calientes', 'Leche', '1500', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informe`
--

CREATE TABLE `informe` (
  `id_informe` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `id_user` varchar(15) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `valor_total` decimal(10,0) NOT NULL,
  `propina_total` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `rut_usuario` varchar(15) NOT NULL,
  `user_nombre` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`rut_usuario`, `user_nombre`, `password`) VALUES
('0000000-0', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `id_usuario` varchar(15) NOT NULL,
  `id_comida` int(11) NOT NULL,
  `num_mesa` int(11) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`categoria`),
  ADD UNIQUE KEY `id_cat` (`id_cat`);

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`id_comida`),
  ADD KEY `FK_comida` (`categoria`);

--
-- Indices de la tabla `informe`
--
ALTER TABLE `informe`
  ADD PRIMARY KEY (`id_informe`),
  ADD KEY `FK_informe` (`id_user`),
  ADD KEY `FK2_informe` (`id_venta`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`rut_usuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `FK_ticket` (`id_usuario`),
  ADD KEY `FK2_ticket` (`id_comida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_cat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `comida`
--
ALTER TABLE `comida`
  MODIFY `id_comida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT de la tabla `informe`
--
ALTER TABLE `informe`
  MODIFY `id_informe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comida`
--
ALTER TABLE `comida`
  ADD CONSTRAINT `FK_comida` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`categoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `informe`
--
ALTER TABLE `informe`
  ADD CONSTRAINT `FK_informe` FOREIGN KEY (`id_user`) REFERENCES `usuario` (`rut_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FK2_ticket` FOREIGN KEY (`id_comida`) REFERENCES `comida` (`id_comida`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ticket` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`rut_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
