-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 01 Jun 2022 pada 13.37
-- Versi server: 10.5.12-MariaDB
-- Versi PHP: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id18651426_dbmotogp`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblrider`
--

CREATE TABLE `tblrider` (
  `id` int(3) NOT NULL,
  `nama` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `nomor` int(2) NOT NULL,
  `sponsor` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `negara` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `foto` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data untuk tabel `tblrider`
--

INSERT INTO `tblrider` (`id`, `nama`, `nomor`, `sponsor`, `negara`, `foto`, `created_at`, `updated_at`) VALUES
(2, 'Marc Marquez', 93, 'Honda', 'Spanyol', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Marc_M%C3%A1rquez_portrait_2022_%28cropped%29.jpg/800px-Marc_M%C3%A1rquez_portrait_2022_%28cropped%29.jpg', '2022-03-23 10:57:46', NULL),
(3, 'Maverick Vinales', 12, 'Aprilia', 'Spanyol', 'https://img.okezone.com/content/2022/03/17/38/2563554/biodata-dan-agama-maverick-vinales-yang-buka-lembaran-baru-dengan-aprilia-racing-aa2MYK2p3B.jpg', '2022-03-23 10:59:59', NULL),
(4, 'Stevanus Christian', 69, 'UMDP', 'Indonesia', 'https://asset.kompas.com/crops/_AGwMwfg5HHrG0-KwP2iyM2mJ8M=/0x0:900x600/750x500/data/photo/2022/03/18/623445ec8d057.png', '2022-03-23 11:34:29', NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tblrider`
--
ALTER TABLE `tblrider`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tblrider`
--
ALTER TABLE `tblrider`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
