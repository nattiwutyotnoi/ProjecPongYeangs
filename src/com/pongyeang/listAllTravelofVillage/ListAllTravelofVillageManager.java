package com.pongyeang.listAllTravelofVillage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListAllTravelofVillageManager {
	private int noOfRecords;

	public Vector<TravelDetail> getListAllTravelofVillage(String village, int offset, int noOfRecords) {
		Vector<TravelDetail> listtraveldetail = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select SQL_CALC_FOUND_ROWS traveldetail.traveldetailID,traveldetail.traveldetailName"
				+ ",traveldetail.traveldetailData,traveldetail.traveldetailTitle"
				+ ",traveldetail.statisticsvisit,address.addressID,address.datecreate,address.statusapproved,address.villageID "
				+ "from traveldetail inner join address on address.addressID = traveldetail.addressID where address.villageID='"
				+ village + "' and address.statusapproved='yes' limit ? , ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, offset);
			stmt.setInt(2, noOfRecords);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TravelDetail travelDetail = new TravelDetail();
				travelDetail.setTraveldetailID(rs.getInt(1));
				travelDetail.setTraveldetailName(rs.getString(2));
				travelDetail.setTraveldetailData(rs.getString(3));
				travelDetail.setTraveldetailTitel(rs.getString(4));
				travelDetail.setStatisticsvisit(rs.getInt(5));

				travelDetail.getAddress().setAddressID(rs.getInt(6));
				travelDetail.getAddress().setDatecreate(rs.getString(7));
				travelDetail.getAddress().setStatusapproved(rs.getString(8));
				travelDetail.getAddress().setVillageCategoryID(this.getVaillage(rs.getString(9)));;
				travelDetail.getAddress().setVectorimages(this.getImgListOne(travelDetail.getAddress().getAddressID()));
				
				listtraveldetail.add(travelDetail);
			}
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
			if (stmt != null)
				stmt.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listtraveldetail;
	}

	public Vector<Images> getImgListOne(int addressID) {
		Vector<Images> listimges = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select address.addressID,image.imageID,image.imageName," + "image.imageDetail "
				+ "from address inner join image on image.addressID = address.addressID "
				+ "where address.addressID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, addressID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Images imges = new Images();
				imges.setImageID(rs.getInt(2));
				imges.setImageName(rs.getString(3));
				imges.setImageDetail(rs.getString(4));
				listimges.add(imges);
			}
			rs.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listimges;
	}

	public VillageCategory getVaillage(String n) {
		VillageCategory villagecategory = new VillageCategory();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select villageID,villageName,villageDetail from villagecategory where villageID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, n);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				villagecategory.setVillageID(rs.getInt(1));
				villagecategory.setVillageName(rs.getString(2));
				villagecategory.setVillageDetail(rs.getString(3));
			}
			rs.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return villagecategory;
	}

	public int getNoOfRecords() {
		return noOfRecords;
	}
}
