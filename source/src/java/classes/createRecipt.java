/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.DecimalFormat;

/**
 *
 * @author Ashan Nawarathna
 */
public class createRecipt {

    private String trnascode;
    private String invoicenum;
    private int itemcount;
    private double billtotal;
    private double discounttotal;
    private double totalnetamount;
    private DecimalFormat df = new DecimalFormat("#.##");
    private double deliverycosttotal;
    private double fullamount;
    private String fname;
    private String lname;
    private String add1;
    private String add2;
    private String a_city;
    private String ps_cod;
    private String c_name;
    private String c_address;

    public createRecipt(String trnascode, String invoicenum, String c_name, String c_address, int itemcount, double billtotal, double discounttotal, double totalnetamount, double deliverycosttotal, double fullamount, String fname, String lname, String add1, String add2, String a_city, String ps_cod) {
        this.trnascode = trnascode;
        this.invoicenum = invoicenum;
        this.c_name = c_name;
        this.c_address = c_address;
        this.itemcount = itemcount;
        this.billtotal = billtotal;
        this.discounttotal = discounttotal;
        this.totalnetamount = totalnetamount;
        this.deliverycosttotal = deliverycosttotal;
        this.fullamount = fullamount;
        this.fname = fname;
        this.lname = lname;
        this.add1 = add1;
        this.add2 = add2;
        this.a_city = a_city;
        this.ps_cod = ps_cod;
    }

    public String getRecipt() {
        String s = "<body>\n"
                + "	<style type='text/css'>\n"
                + "		table{\n"
                + "			text-align:left;\n"
                + "			background-color:#F1F5FB;\n"
                + "		}\n"
                + "		div {\n"
                + "			margin-left:0;\n"
                + "		}\n"
                + "		.fontcons{\n"
                + "			font-family:consolas;\n"
                + "			font-size:12px;\n"
                + "		}\n"
                + "		.lfgp{\n"
                + "			padding-left:20px;\n"
                + "			\n"
                + "		}\n"
                + "		ul {\n"
                + "			padding:0;\n"
                + "			margin-left:946px;\n"
                + "			margin-top:0px;\n"
                + "		}\n"
                + "		ul li {\n"
                + "			display:inline-block;\n"
                + "			margin-left:5px;\n"
                + "			\n"
                + "		}\n"
                + "		ul li a{\n"
                + "			font-size:11px;\n"
                + "			color:#000;\n"
                + "		}\n"
                + "	</style>\n"
                + "	<div style='margin-left:250px;border:1px solid #CCC;width:806px; padding:5px 3px;'>\n"
                + "	\n"
                + "		<div><span style='color:#85B84F;'>Your transaction successful </span> <img src='_images/_site/_arrows/8-512.png' width='30' height='30'> | Transaction CODE :  <span style='color:#FFF;background-color:#000;display:inline-block;padding:0 3px;'>" + trnascode + "</span> </div>\n"
                + "		<br/>\n"
                + "		<div>Account Number : <span style='font-family:consolas;'> " + invoicenum + " <span></div>\n"
                + "		<div>Customer Name : " + c_name + "</div>\n"
                + "		<div style='margin-bottom:5px;'>Customer address : " + c_address + "</div>\n"
                + "		<table width='800' style='background-color:#F1F5FB;'>\n"
                + "			<tr>\n"
                + "				<th>Tranaction Details</th>\n"
                + "			</tr>\n"
                + "			<tr>\n"
                + "				<td>\n"
                + "					<table width='800'>\n"
                + "						<tr>\n"
                + "							<td width='500'>Purchase Information</td>\n"
                + "							<td width='300'></td>\n"
                + "						</tr>\n"
                + "						\n"
                + "						<tr>\n"
                + "							<td width='500' class='fontcons lfgp'>Item Count</td>\n"
                + "							<td width='300' class='fontcons'>" + itemcount + "</td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500' class='fontcons lfgp'>Total amount</td>\n"
                + "							<td width='300' class='fontcons'>" + billtotal + "(LKR)" + "</td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500' class='fontcons lfgp'>Total Discount</td>\n"
                + "							<td width='300' class='fontcons' >" + discounttotal + "(LKR) </td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500' class='fontcons lfgp'>Net Amount</td>\n"
                + "							<td width='300' class='fontcons'>" + totalnetamount + "(LKR)</td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500' class='fontcons lfgp'>Delivery Charge</td>\n"
                + "							<td width='300' class='fontcons'>" + Double.valueOf(df.format(deliverycosttotal)) + "(LKR)</td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500' class='fontcons lfgp'>Net Amount + Delivery Charge</td>\n"
                + "							<td width='300' class='fontcons'>" + Double.valueOf(df.format(fullamount)) + "(LKR)</td>\n"
                + "						</tr>\n"
                + "						\n"
                + "					</table>\n"
                + "				</td>\n"
                + "			</tr>\n"
                + "			<tr>\n"
                + "				<td>\n"
                + "					<table>\n"
                + "							<tr>\n"
                + "							<td width='500'>Delivery address</td>\n"
                + "							<td width='300' class='fontcons'></td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500'></td>\n"
                + "							<td width='300' class='fontcons'>" + fname + " " + lname + " </td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500'></td>\n"
                + "							<td width='300' class='fontcons'>" + add1 + "</td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500'></td>\n"
                + "							<td width='300' class='fontcons'>" + add2 + "</td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500'></td>\n"
                + "							<td width='300' class='fontcons'>" + a_city + "</td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500'></td>\n"
                + "							<td width='300' class='fontcons'>" + ps_cod + "</td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='500'></td>\n"
                + "							<td width='300' class='fontcons'>Sri Lanka</td>\n"
                + "						</tr>\n"
                + "						<tr>\n"
                + "							<td width='300' colspan='2' style='font-size:12px;'>Your products will delivery to this address withn next 15 days <br/>\n"
                + "							if not please contact +94717533368.\n"
                + "							</td>\n"
                + "						</tr>\n"
                + "					</table>\n"
                + "				</td>\n"
                + "			</tr>\n"
                + "			<tr>\n"
                + "				<td>\n"
                + "					<table>\n"
                + "						<tr>\n"
                + "							<td width='500'></td>\n"
                + "							<td>\n"
                + "								<table>\n"
                + "									<tr>\n"
                + "										<!--td width='350'><span style='font-size:14px;margin-left:-10px;'>View Invoice</span> <a href='report_gen' style='color:#725C8A;font-size:14px;'>click here</a></td-->\n"
                + "									</tr>\n"
                + "								</table>\n"
                + "							</td>\n"
                + "						</tr>\n"
                + "					</table>\n"
                + "				</td>\n"
                + "			</tr>\n"
                + "			\n"
                + "			\n"
                + "		</table>\n"
                + "		<div style='font-size:12px;margin-top:10px;'>This tranaction made thourgh the <a href='index.jsp'>www.royal flowers.com</a> </div>\n"
                + "		<div style='font-size:12px;margin-left:35%;margin-top:10px;margin-bottom:10px;'>Thank you for shopping wiht us.</div>\n"
                + "	</div>\n"
                + "	<ul>\n"
                + "		<li><a href='index.jsp'>home</li>\n"
                + "		<li><a href='#'>about</li>\n"
                + "		<li><a href='#'>contact</li>\n"
                + "	</ul>\n"
                + "</body>";

        return s;
    }
}
