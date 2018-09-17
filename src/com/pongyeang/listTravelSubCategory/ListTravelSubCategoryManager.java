package com.pongyeang.listTravelSubCategory;

import java.sql.*;

import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListTravelSubCategoryManager {
	private int noOfRecords;

	public SubCategoryTravel getListTravelSubCategory(String TravelSubID, int offset, int noOfRecords) {
		SubCategoryTravel subCategoryTravel = new SubCategoryTravel();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategorytravelID,subcategorytravelName "
				+ "from subcategorytravel where subcategorytravelID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, TravelSubID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				subCategoryTravel.setSubcategorytravelID(rs.getString(1));
				subCategoryTravel.setSubcategorytravelName(rs.getString(2));
				subCategoryTravel.setVectortraveldetail(this.getDetailTravel(TravelSubID, offset, noOfRecords));
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
		return subCategoryTravel;
	}

	public Vector<TravelDetail> getDetailTravel(String TravelSubID, int offset, int noOfRecords) {
		Vector<TravelDetail> vtravel = new Vector<TravelDetail>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select SQL_CALC_FOUND_ROWS traveldetail.traveldetailID,traveldetail.traveldetailName"
				+ ",traveldetail.traveldetailData,traveldetail.traveldetailTitle,traveldetail.statisticsvisit"
				+ ",address.addressID,address.datecreate,address.statusapproved "
				+ "from traveldetail inner join address on address.addressID = traveldetail.addressID "
				+ "where traveldetail.subcategorytravelID= ?  and address.statusapproved='yes' "
				+ "order by  traveldetail.statisticsvisit desc limit ? , ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, TravelSubID);
			stmt.setInt(2, offset);
			stmt.setInt(3, noOfRecords);
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
				travelDetail.getAddress().setVectorimages(this.getImgListOne(travelDetail.getAddress().getAddressID()));

				vtravel.add(travelDetail);
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
		return vtravel;
	}

	public Vector<Images> getImgListOne(int addressID) {
		Vector<Images> listimges = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select address.addressID,image.imageID,image.imageName," + "image.imageDetail "
				+ "from address inner join image on image.addressID = address.addressID where address.addressID= ? ;";
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

	public int getNoOfRecords() {
		return noOfRecords;
	}
}
