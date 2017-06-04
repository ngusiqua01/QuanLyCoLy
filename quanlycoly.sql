-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2017 at 09:15 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlycoly`
--

-- --------------------------------------------------------

--
-- Table structure for table `congtrinh`
--

CREATE TABLE `congtrinh` (
  `MaCT` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `TenCT` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `NgayCT` date DEFAULT NULL,
  `NgayKT` date DEFAULT NULL,
  `ToaDoX` double NOT NULL,
  `ToaDoY` double NOT NULL,
  `CaoDoZ` double NOT NULL,
  `ChieuSauLK` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `congtrinh`
--

INSERT INTO `congtrinh` (`MaCT`, `TenCT`, `NgayCT`, `NgayKT`, `ToaDoX`, `ToaDoY`, `CaoDoZ`, `ChieuSauLK`) VALUES
('CT1', 'cong trinh 1', '2017-12-25', '2018-12-27', 100, 200, 300, 400),
('CT3', 'cong trinh 3', '1995-12-25', '2019-03-13', 10, 20, 30, 40);

-- --------------------------------------------------------

--
-- Table structure for table `diatang`
--

CREATE TABLE `diatang` (
  `MaDT` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `TenDT` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `MaCT` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `MoTa` text COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ketquathinghiem`
--

CREATE TABLE `ketquathinghiem` (
  `MaKQ` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `SHMau` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `DoAm` double NOT NULL,
  `GHChay` double NOT NULL,
  `GHDeo` double NOT NULL,
  `ChiSoDeo` double NOT NULL,
  `DoSet` double NOT NULL,
  `KLTheTich` double NOT NULL,
  `KLTheTichKho` double NOT NULL,
  `DoLoRong` double NOT NULL,
  `HeSoRong` double NOT NULL,
  `LucDinhKet` double NOT NULL,
  `DoBaoHoa` double NOT NULL,
  `GocMasatTrong` double NOT NULL,
  `HSNenLun` double NOT NULL,
  `SucChiuTai` double NOT NULL,
  `NgayBC` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mau`
--

CREATE TABLE `mau` (
  `SHMau` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `MaDT` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `NgayLayMau` date NOT NULL,
  `ChieuDaiMau` double NOT NULL,
  `ChieuDaiMauTu` double NOT NULL,
  `ChieuDaiMauDen` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `mau`
--

INSERT INTO `mau` (`SHMau`, `MaDT`, `NgayLayMau`, `ChieuDaiMau`, `ChieuDaiMauTu`, `ChieuDaiMauDen`) VALUES
('sh1', 'DT1', '2017-02-01', 50, 600, 150);

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE `nguoidung` (
  `TenND` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(100) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`TenND`, `MatKhau`) VALUES
('admin', 'e10adc3949ba59abbe56e057f20f883e');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `congtrinh`
--
ALTER TABLE `congtrinh`
  ADD PRIMARY KEY (`MaCT`);

--
-- Indexes for table `diatang`
--
ALTER TABLE `diatang`
  ADD PRIMARY KEY (`MaDT`);

--
-- Indexes for table `ketquathinghiem`
--
ALTER TABLE `ketquathinghiem`
  ADD PRIMARY KEY (`MaKQ`);

--
-- Indexes for table `mau`
--
ALTER TABLE `mau`
  ADD PRIMARY KEY (`SHMau`);

--
-- Indexes for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`TenND`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
