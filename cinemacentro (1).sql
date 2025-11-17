-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-11-2025 a las 21:51:08
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
  `fila` varchar(100) NOT NULL,
  `numero` int(10) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `id_proyeccion` int(11) NOT NULL,
  `id_sala` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asiento`
--

INSERT INTO `asiento` (`id_lugar`, `fila`, `numero`, `estado`, `id_proyeccion`, `id_sala`) VALUES
(577, 'A', 1, 1, 20, 14),
(578, 'A', 2, 1, 20, 14),
(579, 'A', 3, 1, 20, 14),
(580, 'A', 4, 1, 20, 14),
(581, 'A', 5, 1, 20, 14),
(582, 'A', 6, 1, 20, 14),
(583, 'A', 7, 1, 20, 14),
(584, 'A', 8, 1, 20, 14),
(585, 'A', 9, 1, 20, 14),
(586, 'A', 10, 1, 20, 14),
(587, 'B', 1, 1, 20, 14),
(588, 'B', 2, 1, 20, 14),
(589, 'B', 3, 1, 20, 14),
(590, 'B', 4, 1, 20, 14),
(591, 'B', 5, 1, 20, 14),
(592, 'B', 6, 1, 20, 14),
(593, 'B', 7, 1, 20, 14),
(594, 'B', 8, 1, 20, 14),
(595, 'B', 9, 1, 20, 14),
(596, 'B', 10, 1, 20, 14),
(597, 'C', 1, 1, 20, 14),
(598, 'C', 2, 1, 20, 14),
(599, 'C', 3, 1, 20, 14),
(600, 'C', 4, 1, 20, 14),
(601, 'C', 5, 1, 20, 14),
(602, 'C', 6, 1, 20, 14),
(603, 'C', 7, 1, 20, 14),
(604, 'C', 8, 1, 20, 14),
(605, 'C', 9, 1, 20, 14),
(606, 'C', 10, 1, 20, 14),
(607, 'D', 1, 1, 20, 14),
(608, 'D', 2, 1, 20, 14),
(609, 'D', 3, 1, 20, 14),
(610, 'D', 4, 1, 20, 14),
(611, 'D', 5, 1, 20, 14),
(612, 'D', 6, 1, 20, 14),
(613, 'D', 7, 1, 20, 14),
(614, 'D', 8, 1, 20, 14),
(615, 'D', 9, 1, 20, 14),
(616, 'D', 10, 1, 20, 14),
(617, 'E', 1, 1, 20, 14),
(618, 'E', 2, 1, 20, 14),
(619, 'E', 3, 1, 20, 14),
(620, 'E', 4, 1, 20, 14),
(621, 'E', 5, 1, 20, 14),
(622, 'A', 1, 1, 21, 12),
(623, 'A', 2, 0, 21, 12),
(624, 'A', 3, 1, 21, 12),
(625, 'A', 4, 1, 21, 12),
(626, 'A', 5, 1, 21, 12),
(627, 'A', 6, 1, 21, 12),
(628, 'A', 7, 1, 21, 12),
(629, 'A', 8, 1, 21, 12),
(630, 'A', 9, 1, 21, 12),
(631, 'A', 10, 1, 21, 12),
(632, 'B', 1, 1, 21, 12),
(633, 'B', 2, 1, 21, 12),
(634, 'B', 3, 1, 21, 12),
(635, 'B', 4, 1, 21, 12),
(636, 'B', 5, 1, 21, 12),
(637, 'B', 6, 1, 21, 12),
(638, 'B', 7, 1, 21, 12),
(639, 'B', 8, 1, 21, 12),
(640, 'B', 9, 1, 21, 12),
(641, 'B', 10, 1, 21, 12),
(642, 'C', 1, 1, 21, 12),
(643, 'C', 2, 1, 21, 12),
(644, 'C', 3, 1, 21, 12),
(645, 'C', 4, 1, 21, 12),
(646, 'C', 5, 1, 21, 12),
(647, 'C', 6, 1, 21, 12),
(648, 'C', 7, 1, 21, 12),
(649, 'C', 8, 1, 21, 12),
(650, 'C', 9, 1, 21, 12),
(651, 'C', 10, 1, 21, 12),
(652, 'D', 1, 1, 21, 12),
(653, 'D', 2, 1, 21, 12),
(654, 'D', 3, 1, 21, 12),
(655, 'D', 4, 1, 21, 12),
(656, 'D', 5, 1, 21, 12),
(657, 'D', 6, 1, 21, 12),
(658, 'D', 7, 1, 21, 12),
(659, 'D', 8, 1, 21, 12),
(660, 'D', 9, 1, 21, 12),
(661, 'D', 10, 1, 21, 12),
(662, 'E', 1, 1, 21, 12),
(663, 'E', 2, 1, 21, 12),
(664, 'E', 3, 1, 21, 12),
(665, 'E', 4, 1, 21, 12),
(666, 'E', 5, 1, 21, 12),
(667, 'E', 6, 1, 21, 12),
(668, 'E', 7, 1, 21, 12),
(669, 'E', 8, 1, 21, 12),
(670, 'E', 9, 1, 21, 12),
(671, 'E', 10, 1, 21, 12);

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

--
-- Volcado de datos para la tabla `comprador`
--

INSERT INTO `comprador` (`dni`, `nombre`, `fechaNac`, `password`, `medioDePago`) VALUES
(41750656, 'Valentina Gatica', '1999-03-04', 'abuela12', 'Credito'),
(42909100, 'Lucio Ponce', '2000-08-02', 'abuela12', 'Mercado Pago');

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
(22, 'Los Simpson', 'Matt Groening', 'La Familia', 'Estados Unidos', 'Comedia', '2025-12-09', 1),
(23, 'Jujutsu Kaisen', 'Gege', 'Sukuna, Gojo, Yuji', 'Japones', 'Accion', '2025-11-20', 1);

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
(20, 23, 14, 'Español', 1, 1, '02:32:00', '03:32:12', 10000, 1),
(21, 22, 12, 'Ingles', 0, 1, '01:48:00', '03:48:37', 10000, 1);

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
(12, 1, 0, 50, 'Habilitado'),
(13, 2, 1, 30, 'Habilitado'),
(14, 3, 1, 45, 'Habilitado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket_compra`
--

CREATE TABLE `ticket_compra` (
  `id_ticket` int(11) NOT NULL,
  `id_lugar` int(11) NOT NULL,
  `fechaFuncion` date NOT NULL,
  `fechaCompra` date NOT NULL,
  `monto` double NOT NULL,
  `dni` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ticket_compra`
--

INSERT INTO `ticket_compra` (`id_ticket`, `id_lugar`, `fechaFuncion`, `fechaCompra`, `monto`, `dni`) VALUES
(18, 623, '2025-11-20', '2025-11-17', 9000, 41750656);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket_detalle`
--

CREATE TABLE `ticket_detalle` (
  `codD` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `id_proyeccion` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `id_sala` int(11) NOT NULL,
  `subtotal` double NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD PRIMARY KEY (`id_lugar`),
  ADD KEY `id_proyeccion` (`id_proyeccion`),
  ADD KEY `id_sala` (`id_sala`);

--
-- Indices de la tabla `comprador`
--
ALTER TABLE `comprador`
  ADD PRIMARY KEY (`dni`);

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
-- Indices de la tabla `ticket_compra`
--
ALTER TABLE `ticket_compra`
  ADD PRIMARY KEY (`id_ticket`),
  ADD KEY `dni` (`dni`);

--
-- Indices de la tabla `ticket_detalle`
--
ALTER TABLE `ticket_detalle`
  ADD PRIMARY KEY (`codD`),
  ADD KEY `id_proyeccion` (`id_proyeccion`),
  ADD KEY `id_sala` (`id_sala`),
  ADD KEY `dni` (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asiento`
--
ALTER TABLE `asiento`
  MODIFY `id_lugar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=672;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id_pelicula` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  MODIFY `id_proyeccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `id_Sala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `ticket_compra`
--
ALTER TABLE `ticket_compra`
  MODIFY `id_ticket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `ticket_detalle`
--
ALTER TABLE `ticket_detalle`
  MODIFY `codD` int(11) NOT NULL AUTO_INCREMENT;

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
-- Filtros para la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  ADD CONSTRAINT `proyeccion_ibfk_1` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`),
  ADD CONSTRAINT `proyeccion_ibfk_2` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_Sala`);

--
-- Filtros para la tabla `ticket_compra`
--
ALTER TABLE `ticket_compra`
  ADD CONSTRAINT `ticket_compra_ibfk_2` FOREIGN KEY (`dni`) REFERENCES `comprador` (`dni`);

--
-- Filtros para la tabla `ticket_detalle`
--
ALTER TABLE `ticket_detalle`
  ADD CONSTRAINT `ticket_detalle_ibfk_1` FOREIGN KEY (`codD`) REFERENCES `ticket_compra` (`id_ticket`),
  ADD CONSTRAINT `ticket_detalle_ibfk_2` FOREIGN KEY (`id_proyeccion`) REFERENCES `proyeccion` (`id_proyeccion`),
  ADD CONSTRAINT `ticket_detalle_ibfk_3` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_Sala`),
  ADD CONSTRAINT `ticket_detalle_ibfk_4` FOREIGN KEY (`dni`) REFERENCES `comprador` (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
