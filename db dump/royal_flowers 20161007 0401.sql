-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema royal_flowers
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ royal_flowers;
USE royal_flowers;

--
-- Table structure for table `royal_flowers`.`advertising`
--

DROP TABLE IF EXISTS `advertising`;
CREATE TABLE `advertising` (
  `idadvertising` int(11) NOT NULL auto_increment,
  `add_title` varchar(100) default NULL,
  `on_date` timestamp NULL default NULL,
  `description` varchar(255) default NULL,
  `img_url` varchar(45) default NULL,
  `website_url` varchar(150) default NULL,
  `advertising_location_idadvertising_location` int(11) NOT NULL,
  `advertising_status_idadvertising_status` int(11) NOT NULL,
  `advertising_date_plans_idadvertising_date_plans` int(11) NOT NULL,
  `company_idcompanies` int(11) NOT NULL,
  `advertising_category_idadvertising_category` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY  (`idadvertising`),
  KEY `fk_advertising_advertising_location1` (`advertising_location_idadvertising_location`),
  KEY `fk_advertising_advertising_status1` (`advertising_status_idadvertising_status`),
  KEY `fk_advertising_advertising_date_plans1` (`advertising_date_plans_idadvertising_date_plans`),
  KEY `fk_advertising_advertising_category1` (`advertising_category_idadvertising_category`),
  KEY `fk_advertising_user1` (`user_iduser`),
  CONSTRAINT `fk_advertising_advertising_date_plans1` FOREIGN KEY (`advertising_date_plans_idadvertising_date_plans`) REFERENCES `advertising_date_plans` (`idadvertising_date_plans`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_advertising_advertising_location1` FOREIGN KEY (`advertising_location_idadvertising_location`) REFERENCES `advertising_location` (`idadvertising_location`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_advertising_advertising_status1` FOREIGN KEY (`advertising_status_idadvertising_status`) REFERENCES `advertising_status` (`idadvertising_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_advertising_company1` FOREIGN KEY (`company_idcompanies`) REFERENCES `company` (`idcompanies`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`advertising`
--

/*!40000 ALTER TABLE `advertising` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertising` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`advertising_date_plans`
--

DROP TABLE IF EXISTS `advertising_date_plans`;
CREATE TABLE `advertising_date_plans` (
  `idadvertising_date_plans` int(11) NOT NULL auto_increment,
  `date_count` int(11) default NULL,
  `pakage` varchar(45) default NULL,
  `price` double default NULL,
  `discount` double default NULL,
  `advertising_status_idadvertising_status` int(11) NOT NULL,
  PRIMARY KEY  (`idadvertising_date_plans`),
  KEY `fk_advertising_date_plans_advertising_status1` (`advertising_status_idadvertising_status`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`advertising_date_plans`
--

/*!40000 ALTER TABLE `advertising_date_plans` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertising_date_plans` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`advertising_location`
--

DROP TABLE IF EXISTS `advertising_location`;
CREATE TABLE `advertising_location` (
  `idadvertising_location` int(11) NOT NULL auto_increment,
  `img_size` varchar(45) default NULL,
  `location` varchar(45) default NULL,
  `price` double default NULL,
  `discount` double default NULL,
  PRIMARY KEY  (`idadvertising_location`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`advertising_location`
--

/*!40000 ALTER TABLE `advertising_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertising_location` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`advertising_status`
--

DROP TABLE IF EXISTS `advertising_status`;
CREATE TABLE `advertising_status` (
  `idadvertising_status` int(11) NOT NULL auto_increment,
  `status` varchar(45) default NULL,
  PRIMARY KEY  (`idadvertising_status`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`advertising_status`
--

/*!40000 ALTER TABLE `advertising_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertising_status` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`brand`
--

DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `idbrand` int(11) NOT NULL auto_increment,
  `brand_name` varchar(255) default NULL,
  PRIMARY KEY  (`idbrand`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`brand`
--

/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `idcart` int(11) NOT NULL auto_increment,
  `product_count` int(11) default NULL,
  `total_amount` double default NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY  (`idcart`),
  KEY `fk_cart_user1` (`user_iduser`),
  CONSTRAINT `fk_cart_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`cart`
--

/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`cart_has_products`
--

DROP TABLE IF EXISTS `cart_has_products`;
CREATE TABLE `cart_has_products` (
  `idcart_has_products` int(11) NOT NULL auto_increment,
  `cart_idcart` int(11) NOT NULL,
  `product_idproduct` int(11) NOT NULL,
  `qty` int(11) default NULL,
  `is_purchased` int(11) default NULL,
  `amount` double default NULL,
  PRIMARY KEY  (`idcart_has_products`),
  KEY `fk_cart_has_products_cart1_idx` (`cart_idcart`),
  KEY `fk_cart_has_products_product1_idx` (`product_idproduct`),
  CONSTRAINT `fk_cart_has_products_cart1` FOREIGN KEY (`cart_idcart`) REFERENCES `cart` (`idcart`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_has_products_product1` FOREIGN KEY (`product_idproduct`) REFERENCES `product` (`idproduct`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`cart_has_products`
--

/*!40000 ALTER TABLE `cart_has_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_has_products` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`catagory`
--

DROP TABLE IF EXISTS `catagory`;
CREATE TABLE `catagory` (
  `idcatagory` int(11) NOT NULL auto_increment,
  `catagory` varchar(255) default NULL,
  PRIMARY KEY  (`idcatagory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`catagory`
--

/*!40000 ALTER TABLE `catagory` DISABLE KEYS */;
/*!40000 ALTER TABLE `catagory` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `idcompanies` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `biz_type` varchar(45) DEFAULT NULL,
  `website_url` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcompanies`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`company`
--

/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;



--
-- Table structure for table `royal_flowers`.`cover_photos`
--

DROP TABLE IF EXISTS `cover_photos`;
CREATE TABLE `cover_photos` (
  `idcover_photos` int(11) NOT NULL auto_increment,
  `code` varchar(45) default NULL,
  `img_url` varchar(45) default NULL,
  `advertising_status_idadvertising_status` int(11) NOT NULL,
  PRIMARY KEY  (`idcover_photos`),
  KEY `fk_cover_photos_advertising_status1` (`advertising_status_idadvertising_status`),
  CONSTRAINT `fk_cover_photos_advertising_status1` FOREIGN KEY (`advertising_status_idadvertising_status`) REFERENCES `advertising_status` (`idadvertising_status`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`cover_photos`
--

/*!40000 ALTER TABLE `cover_photos` DISABLE KEYS */;
/*!40000 ALTER TABLE `cover_photos` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`delivery`
--

DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
  `iddelivery` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `address1` text,
  `address2` text,
  `city` varchar(255) default NULL,
  `state` varchar(255) default NULL,
  `postal_code` varchar(45) default NULL,
  `cost` double default NULL,
  `shipping_date` timestamp NULL default NULL,
  `invoice_idinvoice` int(11) NOT NULL,
  `delivery_plan_iddelivery_plan` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY  (`iddelivery`),
  KEY `fk_delivery_invoice1_idx` (`invoice_idinvoice`),
  KEY `fk_delivery_delivery_plan1` (`delivery_plan_iddelivery_plan`),
  KEY `fk_delivery_user1` (`user_iduser`),
  CONSTRAINT `fk_delivery_delivery_plan1` FOREIGN KEY (`delivery_plan_iddelivery_plan`) REFERENCES `delivery_plan` (`iddelivery_plan`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_delivery_invoice1` FOREIGN KEY (`invoice_idinvoice`) REFERENCES `invoice` (`idinvoice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`delivery`
--

/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`delivery_plan`
--

DROP TABLE IF EXISTS `delivery_plan`;
CREATE TABLE `delivery_plan` (
  `iddelivery_plan` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `k_10` double default NULL,
  `k_50` double default NULL,
  `k_100` double default NULL,
  `k_100up` double default NULL,
  `delivery_period` int(11) default NULL,
  `description` text,
  PRIMARY KEY  (`iddelivery_plan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`delivery_plan`
--

/*!40000 ALTER TABLE `delivery_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_plan` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`donation_orgs`
--

DROP TABLE IF EXISTS `donation_orgs`;
CREATE TABLE `donation_orgs` (
  `iddonation_orgs` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `wesite_url` varchar(45) default NULL,
  `desciption` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `type` varchar(45) default NULL,
  `acc_num` varchar(45) default NULL,
  PRIMARY KEY  (`iddonation_orgs`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`donation_orgs`
--

/*!40000 ALTER TABLE `donation_orgs` DISABLE KEYS */;
/*!40000 ALTER TABLE `donation_orgs` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`donations`
--

DROP TABLE IF EXISTS `donations`;
CREATE TABLE `donations` (
  `iddonations` int(11) NOT NULL auto_increment,
  `amount` varchar(45) default NULL,
  `date` datetime default NULL,
  `donation_orgs_iddonation_orgs` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL,
  `recipt_num` varchar(45) default NULL,
  PRIMARY KEY  (`iddonations`),
  KEY `fk_donations_donation_orgs1` (`donation_orgs_iddonation_orgs`),
  KEY `fk_donations_user1` (`user_iduser`),
  CONSTRAINT `fk_donations_donation_orgs1` FOREIGN KEY (`donation_orgs_iddonation_orgs`) REFERENCES `donation_orgs` (`iddonation_orgs`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_donations_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`donations`
--

/*!40000 ALTER TABLE `donations` DISABLE KEYS */;
/*!40000 ALTER TABLE `donations` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`email_code`
--

DROP TABLE IF EXISTS `email_code`;
CREATE TABLE `email_code` (
  `idemail_code` int(11) NOT NULL auto_increment,
  `code` text,
  `state` int(11) default NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY  (`idemail_code`),
  KEY `fk_email_code_user1_idx` (`user_iduser`),
  CONSTRAINT `fk_email_code_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`email_code`
--

/*!40000 ALTER TABLE `email_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_code` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`interfaces`
--

DROP TABLE IF EXISTS `interfaces`;
CREATE TABLE `interfaces` (
  `idinterfaces` int(11) NOT NULL auto_increment,
  `url` text,
  `display_name` varchar(255) default NULL,
  PRIMARY KEY  (`idinterfaces`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`interfaces`
--

/*!40000 ALTER TABLE `interfaces` DISABLE KEYS */;
/*!40000 ALTER TABLE `interfaces` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `idinvoice` int(11) NOT NULL auto_increment,
  `invoice_num` varchar(45) default NULL,
  `Time_date` timestamp NULL default NULL,
  `cart_idcart` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY  (`idinvoice`),
  KEY `fk_invoice_cart1_idx` (`cart_idcart`),
  KEY `fk_invoice_user1` (`user_iduser`),
  CONSTRAINT `fk_invoice_cart1` FOREIGN KEY (`cart_idcart`) REFERENCES `cart` (`idcart`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`invoice`
--

/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`login_session`
--

DROP TABLE IF EXISTS `login_session`;
CREATE TABLE `login_session` (
  `idlogin_session` int(11) NOT NULL auto_increment,
  `in_time` datetime default NULL,
  `out_time` datetime default NULL,
  `iduser_login` int(11) NOT NULL,
  PRIMARY KEY  (`idlogin_session`),
  KEY `fk_login_session_user_login1_idx` (`iduser_login`),
  CONSTRAINT `fk_login_session_user_login1` FOREIGN KEY (`iduser_login`) REFERENCES `user_login` (`iduser_login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`login_session`
--

/*!40000 ALTER TABLE `login_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_session` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`p_status`
--

DROP TABLE IF EXISTS `p_status`;
CREATE TABLE `p_status` (
  `idp_status` int(11) NOT NULL auto_increment,
  `state` varchar(45) default NULL,
  PRIMARY KEY  (`idp_status`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`p_status`
--

/*!40000 ALTER TABLE `p_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `p_status` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`p_votes`
--

DROP TABLE IF EXISTS `p_votes`;
CREATE TABLE `p_votes` (
  `idp_votes` int(11) NOT NULL auto_increment,
  `status` varchar(45) default NULL,
  PRIMARY KEY  (`idp_votes`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`p_votes`
--

/*!40000 ALTER TABLE `p_votes` DISABLE KEYS */;
/*!40000 ALTER TABLE `p_votes` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`payment_types`
--

DROP TABLE IF EXISTS `payment_types`;
CREATE TABLE `payment_types` (
  `idpayment_types` int(11) NOT NULL auto_increment,
  `type` varchar(45) default NULL,
  PRIMARY KEY  (`idpayment_types`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`payment_types`
--

/*!40000 ALTER TABLE `payment_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_types` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE `payments` (
  `idpayments` int(11) NOT NULL auto_increment,
  `tranaction_code` varchar(45) default NULL,
  `date` datetime default NULL,
  `acc_num` varchar(45) default NULL,
  `amount` double default NULL,
  `recipt_num` varchar(45) default NULL,
  `payment_types_idpayment_types` int(11) NOT NULL,
  PRIMARY KEY  (`idpayments`),
  KEY `fk_payments_payment_types1` (`payment_types_idpayment_types`),
  CONSTRAINT `fk_payments_payment_types1` FOREIGN KEY (`payment_types_idpayment_types`) REFERENCES `payment_types` (`idpayment_types`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`payments`
--

/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`privilages`
--

DROP TABLE IF EXISTS `privilages`;
CREATE TABLE `privilages` (
  `idprivilages` int(11) NOT NULL auto_increment,
  `user_type_iduser_type` int(11) NOT NULL,
  `interfaces_idinterfaces` int(11) NOT NULL,
  PRIMARY KEY  (`idprivilages`),
  KEY `fk_privilages_user_type1_idx` (`user_type_iduser_type`),
  KEY `fk_privilages_interface1_idx` (`interfaces_idinterfaces`),
  CONSTRAINT `fk_privilages_interface1` FOREIGN KEY (`interfaces_idinterfaces`) REFERENCES `interfaces` (`idinterfaces`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_privilages_user_type1` FOREIGN KEY (`user_type_iduser_type`) REFERENCES `user_type` (`iduser_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`privilages`
--

/*!40000 ALTER TABLE `privilages` DISABLE KEYS */;
/*!40000 ALTER TABLE `privilages` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `idproduct` int(11) NOT NULL auto_increment,
  `sub_category_idsub_category` int(11) NOT NULL,
  `brand_idbrand` int(11) NOT NULL,
  `product_code` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `price` double default NULL,
  `discount` double default NULL,
  `qty` int(11) default NULL,
  `reoder_level` int(11) default NULL,
  `weight` double default NULL,
  `image_url_1` varchar(255) default NULL,
  `image_url_2` varchar(255) default NULL,
  `image_url_3` varchar(255) default NULL,
  `description` text,
  `reg_date` timestamp NULL default NULL,
  `product_color_idcolor` int(11) NOT NULL,
  `p_status_idp_status` int(11) NOT NULL,
  PRIMARY KEY  (`idproduct`),
  KEY `fk_product_brand1_idx` (`brand_idbrand`),
  KEY `fk_product_sub_category1_idx` (`sub_category_idsub_category`),
  KEY `fk_product_product_color1` (`product_color_idcolor`),
  KEY `fk_product_p_status1` (`p_status_idp_status`),
  CONSTRAINT `fk_product_brand1` FOREIGN KEY (`brand_idbrand`) REFERENCES `brand` (`idbrand`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_product_color1` FOREIGN KEY (`product_color_idcolor`) REFERENCES `product_color` (`idcolor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_p_status1` FOREIGN KEY (`p_status_idp_status`) REFERENCES `p_status` (`idp_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_sub_category1` FOREIGN KEY (`sub_category_idsub_category`) REFERENCES `sub_category` (`idsub_category`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`product_color`
--

DROP TABLE IF EXISTS `product_color`;
CREATE TABLE `product_color` (
  `idcolor` int(11) NOT NULL auto_increment,
  `color` varchar(45) default NULL,
  PRIMARY KEY  (`idcolor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`product_color`
--

/*!40000 ALTER TABLE `product_color` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_color` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`product_rating`
--

DROP TABLE IF EXISTS `product_rating`;
CREATE TABLE `product_rating` (
  `idproduct_rating` int(11) NOT NULL auto_increment,
  `bought_count` int(11) default NULL,
  `p_votes_idp_votes` int(11) NOT NULL,
  `product_idproduct` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY  (`idproduct_rating`),
  KEY `fk_product_rating_p_votes1` (`p_votes_idp_votes`),
  KEY `fk_product_rating_product1` (`product_idproduct`),
  KEY `fk_product_rating_user1` (`user_iduser`),
  CONSTRAINT `fk_product_rating_product1` FOREIGN KEY (`product_idproduct`) REFERENCES `product` (`idproduct`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_rating_p_votes1` FOREIGN KEY (`p_votes_idp_votes`) REFERENCES `p_votes` (`idp_votes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_rating_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`product_rating`
--

/*!40000 ALTER TABLE `product_rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_rating` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
CREATE TABLE `sub_category` (
  `idsub_category` int(11) NOT NULL auto_increment,
  `catagory_idcatagory` int(11) NOT NULL,
  `sub_category` varchar(45) default NULL,
  PRIMARY KEY  (`idsub_category`),
  KEY `fk_sub_category_catagory1_idx` (`catagory_idcatagory`),
  CONSTRAINT `fk_sub_category_catagory1` FOREIGN KEY (`catagory_idcatagory`) REFERENCES `catagory` (`idcatagory`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`sub_category`
--

/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL auto_increment,
  `fname` varchar(100) default NULL,
  `lname` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `telephone` varchar(15) default NULL,
  `mobile` varchar(15) default NULL,
  `address1` text,
  `address2` text,
  `address3` varchar(45) default NULL,
  `city` varchar(45) default NULL,
  `p_code` varchar(100) default NULL,
  `district` varchar(45) default NULL,
  `country` varchar(100) default NULL,
  `user_type_iduser_type` int(11) NOT NULL,
  `user_state_iduser_state` int(11) NOT NULL,
  `user_gender_idgender` int(11) default NULL,
  `dob` timestamp NULL default NULL,
  PRIMARY KEY  (`iduser`),
  KEY `fk_user_user_type_idx` (`user_type_iduser_type`),
  KEY `fk_user_user_state1_idx` (`user_state_iduser_state`),
  KEY `fk_user_user_gender1` (`user_gender_idgender`),
  CONSTRAINT `fk_user_user_gender1` FOREIGN KEY (`user_gender_idgender`) REFERENCES `user_gender` (`idgender`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user_state1` FOREIGN KEY (`user_state_iduser_state`) REFERENCES `user_state` (`iduser_state`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user_type` FOREIGN KEY (`user_type_iduser_type`) REFERENCES `user_type` (`iduser_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`user_gender`
--

DROP TABLE IF EXISTS `user_gender`;
CREATE TABLE `user_gender` (
  `idgender` int(11) NOT NULL auto_increment,
  `male` varchar(45) default NULL,
  `female` varchar(45) default NULL,
  PRIMARY KEY  (`idgender`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`user_gender`
--

/*!40000 ALTER TABLE `user_gender` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_gender` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`user_login`
--

DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `iduser_login` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `max_login_attempt` int(11) default NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY  (`iduser_login`),
  KEY `fk_user_login_user1_idx` (`user_iduser`),
  CONSTRAINT `fk_user_login_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`user_login`
--

/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`user_state`
--

DROP TABLE IF EXISTS `user_state`;
CREATE TABLE `user_state` (
  `iduser_state` int(11) NOT NULL auto_increment,
  `state` varchar(45) default NULL,
  PRIMARY KEY  (`iduser_state`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`user_state`
--

/*!40000 ALTER TABLE `user_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_state` ENABLE KEYS */;


--
-- Table structure for table `royal_flowers`.`user_type`
--

DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type` (
  `iduser_type` int(11) NOT NULL auto_increment,
  `type_name` varchar(100) default NULL,
  PRIMARY KEY  (`iduser_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `royal_flowers`.`user_type`
--

/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;


--
-- View structure for view `royal_flowers`.`advertising_category`
--


--
-- View structure for view `royal_flowers`.`product_has_vendors`
--


--
-- View structure for view `royal_flowers`.`product_request_receipt`
--


--
-- View structure for view `royal_flowers`.`product_request_status`
--


--
-- View structure for view `royal_flowers`.`vendors`
--

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
