package com.inspur.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inspur.common.ConnectionUtil;
import com.inspur.entity.Emp;

public class EmpDao {

	private Connection conn;

	private PreparedStatement pstmt;

	private ResultSet rs;

	/**
	 * �������е�Ա����Ϣ
	 */
	public List<Emp> queryAllEmp() {
		List<Emp> empList = new ArrayList<Emp>();
		String sql = "select empno,ename,job,sal,comm,deptno from emp";

		// 1.�õ����ݿ����Ӷ���
		try {
			conn = ConnectionUtil.getConnection();
			// 3.�õ�����sql�ĵĶ���
			pstmt = conn.prepareStatement(sql);
			
			// 4.statment������sql�ĵ�oracle��������ִ��
            rs=pstmt.executeQuery();
			// 5.������
			while (rs.next()) {
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job")==null?"":rs.getString("job");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				String deptno = rs.getString("deptno");

				Emp emp = new Emp(empno, ename, job, sal, comm, deptno);
				empList.add(emp);
				// System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal+"\t"+comm+"\t"+deptno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// �ͷ����ݿ���Դ[��Ҫ]
		} finally {

			ConnectionUtil.close(conn, pstmt, rs);

		}

		return empList;

	}

	/**
	 * ����Ա����������Ա����Ϣ
	 */
	public List<Emp> queryEmpByEname(String name) {
		List<Emp> empList = new ArrayList<Emp>();
		String sql = "select empno,ename,job,sal,comm,deptno from emp where ename like '%'||?||'%'";

		// 1.��������
		try {
			conn = ConnectionUtil.getConnection();
			// 3.�õ�����sql�ĵĶ���
			pstmt = conn.prepareStatement(sql);

			// ��̬�󶨲���
			pstmt.setString(1, name);

			// 4.statment������sql�ĵ�oracle��������ִ��
			rs = pstmt.executeQuery();
			System.out.println("�T�����:" + "\t" + "������" + "\t" + "������" + "\t"
					+ "\t" + "���ʣ�" + "\t" + "����" + "\t" + "���ű��");
			// 5.������
			while (rs.next()) {
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				String deptno = rs.getString("deptno");

				Emp emp = new Emp(empno, ename, job, sal, comm, deptno);
				empList.add(emp);
				// System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal+"\t"+comm+"\t"+deptno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// �ͷ����ݿ���Դ[��Ҫ]
		} finally {

			ConnectionUtil.close(conn, pstmt, rs);

		}

		return empList;

	}

	/**
	 * �����Ա����Ϣ
	 * 
	 * @param emp
	 * @return
	 */
	public int insertEmp(Emp emp) {

		int count = 0;

		String sql = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,to_date(?,'YYYY-MM-DD'),?,?,?)";

		try {
			conn = ConnectionUtil.getConnection();
			
			
			// 3.�õ�����sql�ĵĶ���
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setString(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setDouble(6, emp.getSal());
			pstmt.setDouble(7, emp.getComm());
			pstmt.setString(8, emp.getDeptno());
			// 4.ִ��sql��
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// �ͷ���Դ����Ҫ��
		} finally {
			ConnectionUtil.close(conn, pstmt);
		}

		return count;

	}

	public static void main(String[] args) {

		EmpDao empDao = new EmpDao();
		List<Emp> empList=empDao.queryAllEmp();
//		List<Emp> empList = empDao.queryEmpByEname("S");
//		for (Emp emp : empList) {
//			System.out.println(emp.getEmpno() + "\t" + emp.getEname() + "\t"
//					+ emp.getJob() + "\t" + emp.getSal() + "\t" + emp.getComm()
//					+ "\t" + emp.getDeptno());
//		}

//		Emp emp = new Emp();
//		emp.setEmpno("24");
//		emp.setEname("jone");
//		emp.setJob("Manager");
//		emp.setHiredate("2009-09-09");
//		emp.setMgr("7902");
//		emp.setSal(900.00);
//		emp.setComm(100.0);
//		emp.setDeptno("10");
//
//		int count = empDao.insertEmp(emp);
//
//		if (count > 0) {
//			System.out.println("��Ա����ӳɹ�");
//		} else {
//			System.out.println("���ʧ��");
//		}
	}

}
