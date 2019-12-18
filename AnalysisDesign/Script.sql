/*    ==Scripting Parameters==

    Source Server Version : SQL Server 2016 (13.0.4001)
    Source Database Engine Edition : Microsoft SQL Server Express Edition
    Source Database Engine Type : Standalone SQL Server

    Target Server Version : SQL Server 2017
    Target Database Engine Edition : Microsoft SQL Server Standard Edition
    Target Database Engine Type : Standalone SQL Server
*/
USE [master]
GO
/****** Object:  Database [QuanLyBongDa]    Script Date: 12/3/2017 7:30:30 AM ******/
CREATE DATABASE [QuanLyBongDa]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyBongDa', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\QuanLyBongDa.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyBongDa_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\QuanLyBongDa_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [QuanLyBongDa] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyBongDa].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyBongDa] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyBongDa] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyBongDa] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyBongDa] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyBongDa] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyBongDa] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyBongDa] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyBongDa] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyBongDa] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyBongDa] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyBongDa] SET QUERY_STORE = OFF
GO
USE [QuanLyBongDa]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [QuanLyBongDa]
GO
/****** Object:  Table [dbo].[Club]    Script Date: 12/3/2017 7:30:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Club](
	[clubID] [nvarchar](10) NOT NULL,
	[clubName] [nvarchar](30) NULL,
	[address] [nvarchar](20) NULL,
	[website] [nvarchar](20) NULL,
	[stadiumID] [nvarchar](10) NULL,
 CONSTRAINT [PK_Club] PRIMARY KEY CLUSTERED 
(
	[clubID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Coach]    Script Date: 12/3/2017 7:30:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Coach](
	[coachID] [nvarchar](10) NOT NULL,
	[coachName] [nvarchar](30) NULL,
	[position] [nvarchar](20) NULL,
	[email] [nvarchar](20) NULL,
	[phone] [nvarchar](20) NULL,
	[dateOfBirth] [date] NULL,
	[sex] [nvarchar](10) NULL,
	[country] [nvarchar](20) NULL,
	[clubID] [nvarchar](10) NULL,
 CONSTRAINT [PK_Coach] PRIMARY KEY CLUSTERED 
(
	[coachID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Manager]    Script Date: 12/3/2017 7:30:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager](
	[managerID] [nvarchar](10) NOT NULL,
	[managerName] [nvarchar](30) NULL,
	[username] [nvarchar](30) NULL,
	[password] [nvarchar](30) NULL,
 CONSTRAINT [PK_Manager] PRIMARY KEY CLUSTERED 
(
	[managerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MatchDetails]    Script Date: 12/3/2017 7:30:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MatchDetails](
	[scheduleID] [nvarchar](10) NULL,
	[playerID] [nvarchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MatchResult]    Script Date: 12/3/2017 7:30:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MatchResult](
	[scheduleID] [nvarchar](10) NOT NULL,
	[homeTeamGoal] [int] NULL,
	[visitorTeamGoal] [int] NULL,
 CONSTRAINT [PK_ResultMatch] PRIMARY KEY CLUSTERED 
(
	[scheduleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Player]    Script Date: 12/3/2017 7:30:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Player](
	[playerID] [nvarchar](10) NOT NULL,
	[playerName] [nvarchar](30) NULL,
	[position] [nvarchar](20) NULL,
	[height] [int] NULL,
	[weight] [int] NULL,
	[dateOfBirth] [date] NULL,
	[sex] [nvarchar](10) NULL,
	[country] [nvarchar](20) NULL,
	[clubID] [nvarchar](10) NULL,
 CONSTRAINT [PK_Player] PRIMARY KEY CLUSTERED 
(
	[playerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Schedule]    Script Date: 12/3/2017 7:30:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Schedule](
	[scheduleID] [nvarchar](10) NOT NULL,
	[round] [int] NULL,
	[day] [date] NULL,
	[time] [nvarchar](10) NULL,
	[stadiumID] [nvarchar](10) NULL,
	[homeTeamID] [nvarchar](10) NULL,
	[visitorTeamID] [nvarchar](10) NULL,
	[managerID] [nvarchar](10) NULL,
 CONSTRAINT [PK_Schedule_1] PRIMARY KEY CLUSTERED 
(
	[scheduleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Stadium]    Script Date: 12/3/2017 7:30:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Stadium](
	[stadiumID] [nvarchar](10) NOT NULL,
	[stadiumName] [nvarchar](30) NULL,
	[foundedYear] [nvarchar](10) NULL,
	[capacity] [nvarchar](10) NULL,
	[note] [nvarchar](10) NULL,
 CONSTRAINT [PK_Stadium] PRIMARY KEY CLUSTERED 
(
	[stadiumID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Club]  WITH CHECK ADD  CONSTRAINT [FK_Club_Stadium] FOREIGN KEY([stadiumID])
REFERENCES [dbo].[Stadium] ([stadiumID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Club] CHECK CONSTRAINT [FK_Club_Stadium]
GO
ALTER TABLE [dbo].[Coach]  WITH CHECK ADD  CONSTRAINT [FK_Coach_Club] FOREIGN KEY([clubID])
REFERENCES [dbo].[Club] ([clubID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Coach] CHECK CONSTRAINT [FK_Coach_Club]
GO
ALTER TABLE [dbo].[MatchDetails]  WITH CHECK ADD  CONSTRAINT [FK_MatchDetails_Schedule] FOREIGN KEY([scheduleID])
REFERENCES [dbo].[Schedule] ([scheduleID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[MatchDetails] CHECK CONSTRAINT [FK_MatchDetails_Schedule]
GO
ALTER TABLE [dbo].[MatchResult]  WITH CHECK ADD  CONSTRAINT [FK_ResultMatch_Schedule] FOREIGN KEY([scheduleID])
REFERENCES [dbo].[Schedule] ([scheduleID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[MatchResult] CHECK CONSTRAINT [FK_ResultMatch_Schedule]
GO
ALTER TABLE [dbo].[Player]  WITH CHECK ADD  CONSTRAINT [FK_Player_Club] FOREIGN KEY([clubID])
REFERENCES [dbo].[Club] ([clubID])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[Player] CHECK CONSTRAINT [FK_Player_Club]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Schedule_Club] FOREIGN KEY([homeTeamID])
REFERENCES [dbo].[Club] ([clubID])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Schedule_Club]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Schedule_Club1] FOREIGN KEY([visitorTeamID])
REFERENCES [dbo].[Club] ([clubID])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Schedule_Club1]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Schedule_Manager] FOREIGN KEY([managerID])
REFERENCES [dbo].[Manager] ([managerID])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Schedule_Manager]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Schedule_Stadium] FOREIGN KEY([stadiumID])
REFERENCES [dbo].[Stadium] ([stadiumID])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Schedule_Stadium]
GO
USE [master]
GO
ALTER DATABASE [QuanLyBongDa] SET  READ_WRITE 
GO
