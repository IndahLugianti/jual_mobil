-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 04 Jan 2018 pada 20.01
-- Versi Server: 5.5.27
-- Versi PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `db_penjualan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_customer`
--

CREATE TABLE IF NOT EXISTS `t_customer` (
  `kode_customer` varchar(15) NOT NULL,
  `jns_customer` varchar(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `kode_pos` varchar(15) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `keterangan_kel` varchar(25) NOT NULL,
  `agama` varchar(15) NOT NULL,
  `no_telp` int(15) NOT NULL,
  PRIMARY KEY (`kode_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `t_customer`
--

INSERT INTO `t_customer` (`kode_customer`, `jns_customer`, `nama`, `alamat`, `kode_pos`, `tgl_lahir`, `keterangan_kel`, `agama`, `no_telp`) VALUES
('CU001M', 'Bisnis', 'Nayla P', 'Jalan Sao Sao, Kendari', '935161', '1983-10-01', 'Kawin', 'Hindu', 2147483647),
('CU002M', 'Pribadi', 'Agus Rahmat P', 'Kecamatan Abeli, Kendari', '931678', '1990-02-10', 'Belum Kawin', 'Islam', 2147483647),
('CU003M', 'Penyewa', 'Ardi Dwi Cahyono', 'Jl. H.E.A Mokodompit, Lrg.Kencana', '931625', '1899-07-23', 'Kawin', 'Islam', 2147483647),
('CU004M', 'Bisnis', 'Indah bin Ahmad Jabal', 'Jl.Balaikota III, Kendari', '931671', '1875-02-17', 'Kawin', 'Islam', 2147483647),
('CU005M', 'Pribadi', 'I Putu Ahuawana', 'Jl.Wayong, Kendari', '931673', '1993-12-11', 'Kawin', 'Hindu', 2147483647),
('CU006M', 'Pribadi', 'Friska Rahayu', 'Jalan Lumba-lumba, Kendari', '935161', '1998-12-01', 'Belum Kawin', 'Islam', 2147483647),
('CU007M', 'Bisnis', 'Indah Lugianti', 'Jl. Bunga Matahari', '931678', '1990-02-16', 'Kawin', 'Kong Hu Cu', 2147483647),
('CU008M', 'Bisnis', 'Chaeril Aksan', 'Kampung Butung, Kendari', '935125', '1986-12-21', 'Kawin', 'Islam', 2147483647),
('CU009M', 'Bisnis', 'Andi Rais', 'jl. HEA.Mokodompit, Kendari', '931678', '1987-12-01', 'Belum Kawin', 'Islam', 2147483647),
('CU010M', 'Pribadi', 'Pini Astati', 'jl. Bunga Amarilis', '935162', '1997-02-23', 'Belum Kawin', 'Islam', 1234556),
('CU011M', 'Bisnis', 'Nina Sularida', 'Jl. Dewi Sartika', '931662', '1995-02-03', 'Kawin', 'Kristen', 123);

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_fact_penjualan`
--

CREATE TABLE IF NOT EXISTS `t_fact_penjualan` (
  `kd_waktu` varchar(50) NOT NULL,
  `kode_customer` varchar(25) NOT NULL,
  `kode_tipe` varchar(25) NOT NULL,
  `kode_warna` varchar(25) NOT NULL,
  `jenis_pelunasan` varchar(25) NOT NULL,
  `gross_profit` varchar(25) NOT NULL,
  `jumlah_unit` int(25) NOT NULL,
  UNIQUE KEY `kode_customer` (`kode_customer`,`kode_tipe`,`kode_warna`,`jenis_pelunasan`),
  KEY `kode_warna` (`kode_warna`),
  KEY `kode_tipe` (`kode_tipe`),
  KEY `jenis_pelunasan` (`jenis_pelunasan`),
  KEY `kd_waktu` (`kd_waktu`),
  KEY `kd_waktu_2` (`kd_waktu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `t_fact_penjualan`
--

INSERT INTO `t_fact_penjualan` (`kd_waktu`, `kode_customer`, `kode_tipe`, `kode_warna`, `jenis_pelunasan`, `gross_profit`, `jumlah_unit`) VALUES
('W01', 'CU001M', 'TYT200012', 'FF0000', 'Cash', 'HJ', 3),
('W02', 'CU002M', 'KIA200143', 'FF1100', 'Credit', 'HJ', 1),
('W03', 'CU003M', 'MIT199701', 'FF0001', 'Cash', 'HJ', 1),
('W04', 'CU004M', 'NSS199703', 'FF1100', 'Cash', 'HJ', 4),
('W05', 'CU005M', 'SZ200378', 'FF1111', 'Credit', 'HJ', 1),
('W06', 'CU006M', 'HND200012', 'FF0000', 'Credit', 'HJ', 2),
('W07', 'CU007M', 'HYD201098', 'FF0101', 'Cash', 'HJ', 5),
('W09', 'CU008M', 'MIT199701', 'FF0001', 'Cash', 'Hj', 1),
('W08', 'CU008M', 'TYT200012', 'FF1100', 'Cash', 'HJ', 3),
('W10', 'CU010M', 'NSS199703', 'FF0000', 'Credit', 'HJ', 2),
('W11', 'CU011M', 'SZ200378', 'FF1111', 'Credit', 'HJ', 1),
('w013', 'CU011M', 'TYT200012', 'FF1111', 'Cash', 'HJ', 6);

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_jenispelunasan`
--

CREATE TABLE IF NOT EXISTS `t_jenispelunasan` (
  `jenis_pelunasan` varchar(25) NOT NULL,
  `ket_pelunasan` varchar(25) NOT NULL,
  PRIMARY KEY (`jenis_pelunasan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `t_jenispelunasan`
--

INSERT INTO `t_jenispelunasan` (`jenis_pelunasan`, `ket_pelunasan`) VALUES
('Cash', 'Lunas'),
('Credit', 'Masih Jalan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_mobil`
--

CREATE TABLE IF NOT EXISTS `t_mobil` (
  `kode_tipe` varchar(25) NOT NULL,
  `nama_tipe` varchar(50) NOT NULL,
  `nama_jenis` varchar(50) NOT NULL,
  `nama_merk` varchar(50) NOT NULL,
  PRIMARY KEY (`kode_tipe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `t_mobil`
--

INSERT INTO `t_mobil` (`kode_tipe`, `nama_tipe`, `nama_jenis`, `nama_merk`) VALUES
('HND200012', 'CRV', 'Sedan', 'Honda'),
('HYD201098', 'Zero', 'Sedan sport', 'Hyundai'),
('KIA200143', 'Pride', 'Sedan', 'KIA'),
('MIT199701', 'Carry2.0', 'Open Cap', 'Mitsubishi'),
('MIT200378', 'Fuso', 'Hino', 'Mitsubishi'),
('NSS199703', 'Colt Diesel', 'Truk', 'Colt'),
('SZ200378', 'Karimun Kotak(Wagon)', 'Sedan', 'Suzuki'),
('TYT200012', 'Starlet New', 'Sedan VIP', 'Toyota'),
('TYT200534', 'Inova', 'Sedan', 'Toyota');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_waktu`
--

CREATE TABLE IF NOT EXISTS `t_waktu` (
  `kd_waktu` varchar(20) NOT NULL,
  `bulan` varchar(15) NOT NULL,
  `semester` int(11) NOT NULL,
  `tahun` int(11) NOT NULL,
  PRIMARY KEY (`kd_waktu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `t_waktu`
--

INSERT INTO `t_waktu` (`kd_waktu`, `bulan`, `semester`, `tahun`) VALUES
('W01', 'Agustus', 2, 2017),
('w013', 'Maret', 1, 2015),
('W02', 'April', 1, 2015),
('W03', 'Desember', 2, 2017),
('W04', 'Februari', 1, 2017),
('W05', 'Januari', 2, 2016),
('W06', 'juli', 1, 2016),
('W07', 'Juni', 1, 2017),
('W08', 'Maret', 1, 2017),
('W09', 'Mei', 1, 2017),
('W10', 'November', 2, 2017),
('W11', 'Oktober', 2, 2017),
('W12', 'September', 2, 2017);

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_warna`
--

CREATE TABLE IF NOT EXISTS `t_warna` (
  `kode_warna` varchar(25) NOT NULL,
  `warna` varchar(25) NOT NULL,
  PRIMARY KEY (`kode_warna`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `t_warna`
--

INSERT INTO `t_warna` (`kode_warna`, `warna`) VALUES
('FF0000', 'Hitam'),
('FF0001', 'Silver'),
('FF0101', 'Hijau'),
('FF1100', 'Merah'),
('FF1111', 'Putih');

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `t_fact_penjualan`
--
ALTER TABLE `t_fact_penjualan`
  ADD CONSTRAINT `t_fact_penjualan_ibfk_1` FOREIGN KEY (`kode_warna`) REFERENCES `t_warna` (`kode_warna`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_fact_penjualan_ibfk_2` FOREIGN KEY (`kode_tipe`) REFERENCES `t_mobil` (`kode_tipe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_fact_penjualan_ibfk_4` FOREIGN KEY (`kode_customer`) REFERENCES `t_customer` (`kode_customer`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_fact_penjualan_ibfk_5` FOREIGN KEY (`jenis_pelunasan`) REFERENCES `t_jenispelunasan` (`jenis_pelunasan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_fact_penjualan_ibfk_6` FOREIGN KEY (`kd_waktu`) REFERENCES `t_waktu` (`kd_waktu`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
