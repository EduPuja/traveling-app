-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-11-2022 a las 18:42:34
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `m6_uf2_a2_edudani`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `billets`
--

CREATE TABLE `billets` (
  `id_billet` int(11) NOT NULL,
  `id_viatge` int(11) NOT NULL,
  `tipus_billet` varchar(30) NOT NULL,
  `preu` int(11) NOT NULL,
  `max_billets_tipus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipatge`
--

CREATE TABLE `equipatge` (
  `id_equip` int(11) NOT NULL,
  `num_factura` int(11) NOT NULL,
  `linia_factura` int(11) NOT NULL,
  `pes_kg` int(11) NOT NULL,
  `num_maletes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estacio`
--

CREATE TABLE `estacio` (
  `id_estacio` int(11) NOT NULL,
  `descrip` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `num_factura` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `preu_total` int(11) NOT NULL,
  `data_factura` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linia_factura`
--

CREATE TABLE `linia_factura` (
  `linia_factura` int(11) NOT NULL,
  `num_factura` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `preu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `data_naix` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viatges`
--

CREATE TABLE `viatges` (
  `id_viatge` int(11) NOT NULL,
  `id_origen` int(11) NOT NULL,
  `id_desti` int(11) NOT NULL,
  `pais` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `billets`
--
ALTER TABLE `billets`
  ADD PRIMARY KEY (`id_billet`);

--
-- Indices de la tabla `equipatge`
--
ALTER TABLE `equipatge`
  ADD PRIMARY KEY (`id_equip`),
  ADD KEY `fk_linia_fact` (`linia_factura`),
  ADD KEY `fk_num_linia` (`num_factura`);

--
-- Indices de la tabla `estacio`
--
ALTER TABLE `estacio`
  ADD PRIMARY KEY (`id_estacio`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`num_factura`);

--
-- Indices de la tabla `linia_factura`
--
ALTER TABLE `linia_factura`
  ADD PRIMARY KEY (`linia_factura`),
  ADD KEY `fk_num_factura` (`num_factura`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `viatges`
--
ALTER TABLE `viatges`
  ADD PRIMARY KEY (`id_viatge`),
  ADD KEY `fk_origen` (`id_origen`),
  ADD KEY `fk_desti` (`id_desti`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `billets`
--
ALTER TABLE `billets`
  MODIFY `id_billet` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `equipatge`
--
ALTER TABLE `equipatge`
  MODIFY `id_equip` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estacio`
--
ALTER TABLE `estacio`
  MODIFY `id_estacio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `num_factura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `linia_factura`
--
ALTER TABLE `linia_factura`
  MODIFY `linia_factura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `viatges`
--
ALTER TABLE `viatges`
  MODIFY `id_viatge` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipatge`
--
ALTER TABLE `equipatge`
  ADD CONSTRAINT `fk_linia_fact` FOREIGN KEY (`linia_factura`) REFERENCES `linia_factura` (`linia_factura`),
  ADD CONSTRAINT `fk_num_linia` FOREIGN KEY (`num_factura`) REFERENCES `factura` (`num_factura`);

--
-- Filtros para la tabla `linia_factura`
--
ALTER TABLE `linia_factura`
  ADD CONSTRAINT `fk_num_factura` FOREIGN KEY (`num_factura`) REFERENCES `factura` (`num_factura`);

--
-- Filtros para la tabla `viatges`
--
ALTER TABLE `viatges`
  ADD CONSTRAINT `fk_desti` FOREIGN KEY (`id_desti`) REFERENCES `estacio` (`id_estacio`),
  ADD CONSTRAINT `fk_origen` FOREIGN KEY (`id_origen`) REFERENCES `estacio` (`id_estacio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
