-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Jan 2024 pada 02.11
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ppdb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `nilai`
--

CREATE TABLE `nilai` (
  `no_nilai` int(11) NOT NULL,
  `no_daftar` int(11) NOT NULL,
  `nilai` varchar(20) NOT NULL,
  `jurusan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `nilai`
--

INSERT INTO `nilai` (`no_nilai`, `no_daftar`, `nilai`, `jurusan`) VALUES
(7, 1, 'A', 'MIPA'),
(8, 2, 'A', 'MIPA');

-- --------------------------------------------------------

--
-- Struktur dari tabel `orangtua`
--

CREATE TABLE `orangtua` (
  `id_ortu` int(15) NOT NULL,
  `nama_siswa` varchar(100) NOT NULL,
  `nama_ayah` varchar(100) NOT NULL,
  `pekerjaan_ayah` varchar(100) NOT NULL,
  `penghasilan_ayah` varchar(100) NOT NULL,
  `nama_ibu` varchar(100) NOT NULL,
  `pekerjaan_ibu` varchar(100) NOT NULL,
  `penghasilan_ibu` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `orangtua`
--

INSERT INTO `orangtua` (`id_ortu`, `nama_siswa`, `nama_ayah`, `pekerjaan_ayah`, `penghasilan_ayah`, `nama_ibu`, `pekerjaan_ibu`, `penghasilan_ibu`) VALUES
(1, 'Anton Tsuraya', 'Rizwan', 'PNS/TNI/Polri', '5 juta - 20 juta', 'Anya', 'Pensiunan', '2 juta - 4.999.999'),
(2, 'Rayhan Kisaputra', 'Waffa', 'Karyawan Swasta', '2 juta - 4.999.999', 'Nona', 'Wirausaha', '1 juta - 1.999.999'),
(3, 'Hasani Wafa', 'Angga', 'PNS/TNI/Polri', '5 juta - 20 juta', 'Dwi', 'Pensiunan', '2 juta - 4.999.999'),
(4, 'Anya Kudoharu', 'Maulana', 'Wirausaha', '2 juta - 4.999.999', 'Aminah', 'Wirausaha', '2 juta - 4.999.999'),
(7, 'Angga Dwi', 'Rayhan', 'Pensiunan', '2 juta - 4.999.999', 'Bella', 'Pensiunan', '2 juta - 4.999.999'),
(8, 'Rahmad Ari', 'Angga', 'Pensiunan', '2 juta - 4.999.999', 'Anggi', 'Pensiunan', '2 juta - 4.999.999');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembayaran`
--

CREATE TABLE `pembayaran` (
  `no_pembayaran` int(11) NOT NULL,
  `no_daftar` varchar(15) NOT NULL,
  `id_ortu` int(10) NOT NULL,
  `bayar` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `pembayaran`
--

INSERT INTO `pembayaran` (`no_pembayaran`, `no_daftar`, `id_ortu`, `bayar`) VALUES
(3, '044', 1, '350000'),
(4, '044', 4, '200000'),
(5, '044', 4, '350000'),
(6, '043', 6, '200000'),
(7, '044', 1, '250000'),
(8, '1', 1, '150000'),
(9, '2', 2, '50000'),
(11, '4', 4, '250000'),
(12, '7', 7, '18250000'),
(13, '8', 8, '200000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pendaftaran`
--

CREATE TABLE `pendaftaran` (
  `no_daftar` varchar(11) NOT NULL,
  `nisn` varchar(10) NOT NULL,
  `nik` varchar(16) NOT NULL,
  `nama_siswa` varchar(100) NOT NULL,
  `jengkel` varchar(10) NOT NULL,
  `agama` varchar(100) NOT NULL,
  `ttl` varchar(100) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `asal_sekolah` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `pendaftaran`
--

INSERT INTO `pendaftaran` (`no_daftar`, `nisn`, `nik`, `nama_siswa`, `jengkel`, `agama`, `ttl`, `alamat`, `asal_sekolah`) VALUES
('', '2345670813', '23456708', 'Rahmad Ari', 'Laki-laki', 'Islam', 'Banjarmasin,04-04-2002', 'Landasan Ulin', 'SMPN 1 Banjarmasin'),
('1', '2345670809', '2345670809', 'AntonTsuraya', 'Laki-laki', 'Islam', 'Tanah Bumbu, 04-03-2003', 'BANJARBARU', 'SMPN 1 SUNGAI LOBAN'),
('2', '2345670800', '2345670800', 'Rayhan Kisaputra', 'Laki-laki', 'Hindu', 'Batulicin', 'Karang Anyar', 'SMPN 1 Banjarbaru'),
('3', '2345670810', '2345670810', 'Hasani Wafa', 'Perempuan', 'Kong Hu Chu', 'Banjarbaru,11-10-2002', 'Banjarbaru', 'SMPN 4 Banjarmasin '),
('4', '2345670811', '2345670811', 'Anya Kudoharu', 'Perempuan', 'Kristen Protestan', 'Alabio,02-03-2002', 'Martapura', 'SMPN 1 Loktabat Selatan'),
('8', '2345670813', '2345670813', 'Rahmad Ari', 'Laki-laki', 'Islam', 'Banjarmasin, 04-04-2002', 'Landasan Ulin', 'SMPN 1 Banjarmasin');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`no_nilai`),
  ADD UNIQUE KEY `no_daftar` (`no_daftar`);

--
-- Indeks untuk tabel `orangtua`
--
ALTER TABLE `orangtua`
  ADD PRIMARY KEY (`id_ortu`);

--
-- Indeks untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`no_pembayaran`),
  ADD KEY `no_daftar` (`no_daftar`),
  ADD KEY `id_ortu` (`id_ortu`);

--
-- Indeks untuk tabel `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD PRIMARY KEY (`no_daftar`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `nilai`
--
ALTER TABLE `nilai`
  MODIFY `no_nilai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `orangtua`
--
ALTER TABLE `orangtua`
  MODIFY `id_ortu` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `no_pembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
