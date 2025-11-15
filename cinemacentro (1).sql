-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-11-2025 a las 14:52:40
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cinemacentro`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asiento`
--

CREATE TABLE `asiento` (
  `id_lugar` int(11) NOT NULL,
  `fila` varchar(10) NOT NULL,
  `numero` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `id_proyeccion` int(11) NOT NULL,
  `id_sala` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asiento`
--

INSERT INTO `asiento` (`id_lugar`, `fila`, `numero`, `estado`, `id_proyeccion`, `id_sala`) VALUES
(417, 'A', 1, 1, 15, 9),
(418, 'A', 2, 1, 15, 9),
(419, 'A', 3, 1, 15, 9),
(420, 'A', 4, 1, 15, 9),
(421, 'A', 5, 1, 15, 9),
(422, 'A', 6, 1, 15, 9),
(423, 'A', 7, 1, 15, 9),
(424, 'A', 8, 1, 15, 9),
(425, 'A', 9, 1, 15, 9),
(426, 'A', 10, 1, 15, 9),
(427, 'B', 1, 1, 15, 9),
(428, 'B', 2, 1, 15, 9),
(429, 'B', 3, 1, 15, 9),
(430, 'B', 4, 1, 15, 9),
(431, 'B', 5, 1, 15, 9),
(432, 'B', 6, 1, 15, 9),
(433, 'B', 7, 1, 15, 9),
(434, 'B', 8, 1, 15, 9),
(435, 'B', 9, 1, 15, 9),
(436, 'B', 10, 1, 15, 9),
(437, 'C', 1, 1, 15, 9),
(438, 'C', 2, 1, 15, 9),
(439, 'C', 3, 1, 15, 9),
(440, 'C', 4, 1, 15, 9),
(441, 'C', 5, 1, 15, 9),
(442, 'C', 6, 1, 15, 9),
(443, 'C', 7, 1, 15, 9),
(444, 'C', 8, 1, 15, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprador`
--

CREATE TABLE `comprador` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechaNac` date NOT NULL,
  `password` varchar(100) NOT NULL,
  `medioDePago` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_ticket`
--

CREATE TABLE `compra_ticket` (
  `codD` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `id_proyeccion` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `id_sala` int(11) NOT NULL,
  `subtotal` double NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ticket`
--

CREATE TABLE `detalle_ticket` (
  `id_ticket` int(11) NOT NULL,
  `fechaCompra` date NOT NULL,
  `fechaFuncion` date NOT NULL,
  `monto` double NOT NULL,
  `dni` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id_pelicula` int(50) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `director` varchar(50) NOT NULL,
  `actores` varchar(150) NOT NULL,
  `origen` varchar(250) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `estreno` date NOT NULL,
  `enCartelera` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id_pelicula`, `titulo`, `director`, `actores`, `origen`, `genero`, `estreno`, `enCartelera`) VALUES
(19, 'Proyecto Final', 'Profe Juanjo', 'Arias Morena, Ponce Lucio, Guada Bustos', 'Argentina', 'Terror', '2025-11-17', 1),
(20, 'Proyecto Final', 'Profes', 'Morena Arias, Lucio Ponce, Guada Bustos', 'Argentina', 'Ciencia Ficcion', '2025-11-13', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyeccion`
--

CREATE TABLE `proyeccion` (
  `id_proyeccion` int(11) NOT NULL,
  `id_pelicula` int(11) NOT NULL,
  `id_sala` int(11) NOT NULL,
  `idioma` varchar(50) NOT NULL,
  `es3D` tinyint(1) NOT NULL,
  `subtitulada` tinyint(1) NOT NULL,
  `horaInicio` time NOT NULL,
  `horaFin` time NOT NULL,
  `precio` double NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proyeccion`
--

INSERT INTO `proyeccion` (`id_proyeccion`, `id_pelicula`, `id_sala`, `idioma`, `es3D`, `subtitulada`, `horaInicio`, `horaFin`, `precio`, `estado`) VALUES
(15, 19, 9, 'Castellano', 1, 0, '18:21:54', '18:00:00', 11000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `id_Sala` int(11) NOT NULL,
  `NroSala` int(11) NOT NULL,
  `apta3D` tinyint(1) NOT NULL,
  `capacidad` int(100) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`id_Sala`, `NroSala`, `apta3D`, `capacidad`, `estado`) VALUES
(9, 1, 1, 28, 'Habilitado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD PRIMARY KEY (`id_lugar`),
  ADD UNIQUE KEY `fila` (`fila`,`numero`),
  ADD KEY `id_proyeccion` (`id_proyeccion`),
  ADD KEY `id_sala` (`id_sala`);

--
-- Indices de la tabla `comprador`
--
ALTER TABLE `comprador`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `compra_ticket`
--
ALTER TABLE `compra_ticket`
  ADD PRIMARY KEY (`codD`),
  ADD KEY `id_proyeccion` (`id_proyeccion`),
  ADD KEY `id_sala` (`id_sala`),
  ADD KEY `dni` (`dni`);

--
-- Indices de la tabla `detalle_ticket`
--
ALTER TABLE `detalle_ticket`
  ADD PRIMARY KEY (`id_ticket`),
  ADD KEY `dni` (`dni`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id_pelicula`);

--
-- Indices de la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  ADD PRIMARY KEY (`id_proyeccion`),
  ADD KEY `id_pelicula` (`id_pelicula`),
  ADD KEY `id_sala` (`id_sala`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id_Sala`),
  ADD UNIQUE KEY `NroSala` (`NroSala`),
  ADD UNIQUE KEY `NroSala_2` (`NroSala`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asiento`
--
ALTER TABLE `asiento`
  MODIFY `id_lugar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=445;

--
-- AUTO_INCREMENT de la tabla `compra_ticket`
--
ALTER TABLE `compra_ticket`
  MODIFY `codD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id_pelicula` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  MODIFY `id_proyeccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `id_Sala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD CONSTRAINT `asiento_ibfk_1` FOREIGN KEY (`id_proyeccion`) REFERENCES `proyeccion` (`id_proyeccion`),
  ADD CONSTRAINT `asiento_ibfk_2` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_Sala`);

--
-- Filtros para la tabla `compra_ticket`
--
ALTER TABLE `compra_ticket`
  ADD CONSTRAINT `compra_ticket_ibfk_1` FOREIGN KEY (`codD`) REFERENCES `detalle_ticket` (`id_ticket`),
  ADD CONSTRAINT `compra_ticket_ibfk_2` FOREIGN KEY (`id_proyeccion`) REFERENCES `proyeccion` (`id_proyeccion`),
  ADD CONSTRAINT `compra_ticket_ibfk_3` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_Sala`),
  ADD CONSTRAINT `compra_ticket_ibfk_4` FOREIGN KEY (`dni`) REFERENCES `comprador` (`dni`);

--
-- Filtros para la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  ADD CONSTRAINT `proyeccion_ibfk_1` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`),
  ADD CONSTRAINT `proyeccion_ibfk_2` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_Sala`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
