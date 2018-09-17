package com.pongyeang.listVillageCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListVillageCategoryManager {

	public Vector<VillageCategory> getListVaillage() {
		Vector<VillageCategory> vectorvillagecategoery = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select villagecategory.villageID,villagecategory.villageName,villagecategory.villageDetail,"
				+ "villagecategory.villageImage from villagecategory ";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				VillageCategory villagecategory = new VillageCategory(rs.getInt(1), rs.getString(2), rs.getString(3));
				villagecategory.setVillageImage(rs.getString(4));
				vectorvillagecategoery.add(villagecategory);
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
		return vectorvillagecategoery;
	}

	public Vector<Address> getVillageAddress(int z) {
		Vector<Address> listAddress = new Vector<Address>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select addressID from address where addressID='" + z + "'";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, z);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Address ad = new Address();
				ad.setAddressID(rs.getInt(1));
				ad.setVectorimages(this.getImgListOneVillage(ad.getAddressID()));
				listAddress.add(ad);
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
		return listAddress;
	}

	public Vector<Images> getImgListOneVillage(int addressID) {
		Vector<Images> listimg = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select address.addressID,image.imageID,image.imageName,image.imageDetail "
				+ "from address inner join image on image.addressID = address.addressID where address.addressID= ? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, addressID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Images img = new Images();
				img.setImageID(rs.getInt(2));
				img.setImageName(rs.getString(3));
				img.setImageDetail(rs.getString(4));
				listimg.add(img);
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
		return listimg;
	}
}
