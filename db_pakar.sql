-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2020 at 01:53 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pakar`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(3) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `level` varchar(3) NOT NULL,
  `nik` varchar(25) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tmplahir` varchar(50) NOT NULL,
  `tgllahir` date DEFAULT NULL,
  `alamat` text NOT NULL,
  `telp` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`, `level`, `nik`, `nama`, `tmplahir`, `tgllahir`, `alamat`, `telp`) VALUES
(1, 'admin', 'nimda', 'adm', '123456789', 'Saha Ngaran Maneh Saha', 'Imah Dimana', '2018-08-06', 'Dimana aja aku senang', '08382988892'),
(7, 'harunamanya', '123harun', 'usr', '3273110907980002', 'Harun Nurahman', 'Indramayu', '1970-01-01', 'Jalan Pasir Jaya 3 No. 4, Bandung', '083829874987'),
(8, 'DEDE', 'nazir', 'usr', '123456789', 'M. DEDE', 'Cianyur', '1970-01-01', 'Bandung', '123456789');

-- --------------------------------------------------------

--
-- Table structure for table `penyakit`
--

CREATE TABLE `penyakit` (
  `id` int(5) NOT NULL,
  `gejala1` varchar(255) NOT NULL,
  `gejala2` varchar(255) NOT NULL,
  `gejala3` varchar(255) NOT NULL,
  `diagnosa` varchar(255) NOT NULL,
  `cegah` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penyakit`
--

INSERT INTO `penyakit` (`id`, `gejala1`, `gejala2`, `gejala3`, `diagnosa`, `cegah`) VALUES
(11111, 'Denyut Jantung Tidak Teratur', 'Nyeri Pada Dada', 'Pingsan', 'Aritmia', 'Penyebab : \n1. Ketidakseimbangan kadar elektrolit dalam darah.\n2. Terlalu banyak mengonsumsi alkohol, kafein & nikotin\n3. Hipertensi\n4. Diabetes\n\nPencegahan : \n1. Menghindari atau mengurangi stres.\n2. Menjaga berat badan ideal.\n3. Tidak merokok dan berolahraga secara teratur.\n4. Membatasi konsumsi minuman keras dan berkafein.\n5. Mengonsumsi makanan sehat.\n'),
(11112, 'Denyut Jantung Tidak Teratur', 'Badan Terasa Lelah dan Lemah', 'Bengkak di Kaki dan Tangan', 'Gagal Jantung', 'Penyebab:\n1. Aritmia atau gangguan ritme jantung.\n2. Cacat jantung sejak lahir.\n3. Penyakit jantung koroner.\n4. Kardiomiopati atau gangguan otot jantung.\n5. Hipertensi atau tekanan darah tinggi.\n\nPencegahan:\n1. Mengonsumsi makanan sehat dan membatasi asupan garam, lemak, dan gula.\n2. Berhenti merokok dan membatasi konsumsi minuman keras.\n3. Menjaga kadar kolesterol dan tekanan darah pada batas sehat.\n'),
(11113, 'Sulit Untuk Bernafas', 'Badan Terasa Lelah dan Lemah', 'Bengkak di Kaki dan Tangan', 'Katup Jantung', 'Karena penyakit katup jantung dapat disebabkan oleh demam reumatik, \nwaspadai gejala-gejala yang muncul pada infeksi bakteri Streptococcus pada tenggorokan, seperti demam, sakit tenggorokan dan nyeri menelan, bercak-bercak kecil berwarna merah pada langit-langit mulut, dan pembesaran kelenjar pada leher. \nSegera temui dokter jika Anda mengalami gejala tersebut untuk mendapatkan pengobatan guna mencegah munculnya penyakit katup jantung.'),
(11114, 'Denyut Jantung Tidak Teratur', 'Perut Kembung Karena Cairan Berlebih', 'Pingsan', 'Kardiomiopati', 'Penyebab:\n1. Kelainan genetik.\n2. Irama jantung cepat yang tidak tertangani.\n3. Kekurangan vitamin dan mineral.\n4. Komplikasi akhir kehamilan sampai dengan 6 bulan setelah melahirkan.\n5. Hemokromatosis, amiloidosis, sarkoidosis.\n\nPencegahan:\n1. Mengurangi berat badan jika terdapat obesitas.\n2. Mengelola stres dengan baik.\n3. Memantau dan mengendalikan kondisi kesehatan yang dapat menjadi penyebab kardiomiopati, seperti diabetes.\n4. Menghentikan kebiasaan merokok & minuman beralkohol.\n5. Mengatur waktu dengan baik untuk mendapatkan waktu tidur yang cukup.\n'),
(11115, 'Gelisah dan Cemas', 'Nyeri Pada Dada', 'Sesak Nafas, Lemah dan Pusing', 'Serangan Jantung', 'Penyebab:\n1. Merokok.\n2. Kolesterol tinggi.\n3. Kebiasaan mengkonsumsi makanan berlemak.\n4. Obesitas\n5. Tekanan darah tinggi.\n\nPencegahan:\n1. Mengurangi makanan berlemak.\n2. Olahraga teratur.\n3. Berhenti merokok dan mengkonsumsi minuman berakohol'),
(11116, 'Sulit Untuk Bernafas', 'Badan Terasa Lelah dan Lemas', 'Pingsan', 'Kantong Kering', 'Penyebab:\n1. Foya-Foya\n2. Tidak Ingat Perut\n\nPenanganan Pertama:\n1. Kerja\n2. Hemat Duit\n3. Sholat\n4. Doa\n');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penyakit`
--
ALTER TABLE `penyakit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
