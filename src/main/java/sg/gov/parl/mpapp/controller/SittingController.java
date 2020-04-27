package sg.gov.parl.mpapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.gov.parl.mpapp.bo.AllSittings;
import sg.gov.parl.mpapp.bo.DocsBO;
import sg.gov.parl.mpapp.bo.NotificationBo;
import sg.gov.parl.mpapp.bo.NotificationInfoBO;
import sg.gov.parl.mpapp.bo.PreSittingBO;
import sg.gov.parl.mpapp.bo.PreSittingInfo;
import sg.gov.parl.mpapp.bo.SittingBO;
import sg.gov.parl.mpapp.bo.SittingInfoBO;
import sg.gov.parl.mpapp.bo.SittingdocBO;
import sg.gov.parl.mpapp.bo.SubtitlesBO;

@RestController
@CrossOrigin
public class SittingController {

	private static String host = "";
	// private static int port = 0;


	@Value("${message.default.filesPath}")
	private String url;

	@RequestMapping(value = "/api/getSittigs")
	public ResponseEntity<Object> getAllSittings() {/*
													 * List<SittingBO> resList = new ArrayList<SittingBO>(); int val =
													 * 94;
													 * 
													 * Map<Integer, String> map = new HashMap<Integer, String>();
													 * map.put(1, "25-09-2019"); map.put(2, "23-08-2019"); map.put(3,
													 * "20-07-2019"); map.put(4, "17-06-2019"); map.put(5,
													 * "10-05-2019");
													 * 
													 * for(int i = 0;i<= 5; i++) { SittingBO bo = new SittingBO();
													 * bo.setId(i+1); bo.setParlNo(i+1); bo.setSessionNO(i+1);
													 * bo.setSittingDate(map.get(i+1)); bo.setVolumeNo(val--);
													 * resList.add(bo); } return new ResponseEntity(resList,
													 * HttpStatus.OK);
													 * 
													 * 
													 */

		SittingInfoBO sittingInfoBO = new SittingInfoBO();
		List<AllSittings> allsittings = new ArrayList<AllSittings>();

		AllSittings sittng1 = new AllSittings();
		sittng1.setParliament(13);
		sittng1.setSession(1);
		sittng1.setVolume(94);
		sittng1.setSittings(prepareSittings());

		AllSittings sittng2 = new AllSittings();
		sittng2.setParliament(13);
		sittng2.setSession(2);
		sittng2.setVolume(94);
		sittng2.setSittings(prepareSittings());

		AllSittings sittng3 = new AllSittings();
		sittng3.setParliament(12);
		sittng3.setSession(2);
		sittng3.setVolume(93);
		sittng3.setSittings(prepareSittings());

		allsittings.add(sittng1);
		allsittings.add(sittng2);
		allsittings.add(sittng3);

		sittingInfoBO.setAllsittings(allsittings);

		return new ResponseEntity(sittingInfoBO, HttpStatus.OK);

	}

	@RequestMapping(value = "/api/getNotifications")
	public ResponseEntity<Object> getNotifications() {

		NotificationInfoBO bo = new NotificationInfoBO();

		bo.setParlBusiness(getNotificationPBs());
		bo.setLeaves(getNotificationLeaves());
		bo.setOthers(getNotificationOthers());

		/*
		 * List<NotificationBo> notifications = new ArrayList<NotificationBo>();
		 * 
		 * NotificationBo nofication1 = new NotificationBo();
		 * nofication1.setDate("24/09/2019");
		 * nofication1.setDescription("Circular for PQS are available");
		 * nofication1.setTime("1.30 pm"); nofication1.setTitle("SG-PARL-SIITNG");
		 * nofication1.setNotificationType("SIITNG"); nofication1.setIsread(false);
		 * 
		 * NotificationBo nofication2 = new NotificationBo();
		 * nofication2.setDate("14/08/2019");
		 * nofication2.setDescription("New papers presented are available");
		 * nofication2.setTime("1.30 pm"); nofication2.setTitle("SG-PARL-MP");
		 * nofication2.setNotificationType("MP"); nofication2.setIsread(true);
		 * 
		 * NotificationBo nofication3 = new NotificationBo();
		 * nofication3.setDate("10/09/2019");
		 * nofication3.setDescription("List of MP's Speaking for the Sitting");
		 * nofication3.setTime("4.30 pm"); nofication3.setTitle("SG-PARL-MP");
		 * nofication3.setNotificationType("MP"); nofication3.setIsread(true);
		 * 
		 * NotificationBo nofication4 = new NotificationBo();
		 * nofication4.setDate("24/09/2019");
		 * nofication4.setDescription("Sitting Resumes at 4.30 pm");
		 * nofication4.setTime("3.00 pm"); nofication4.setTitle("SG-PARL-SIITNG");
		 * nofication4.setNotificationType("SIITNG"); nofication4.setIsread(true);
		 * 
		 * notifications.add(nofication1 ); notifications.add(nofication2);
		 * notifications.add(nofication3 ); notifications.add(nofication4 );
		 * 
		 * bo.setNotifications(notifications);
		 */

		return new ResponseEntity(bo, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/getprePostSittings")
	public ResponseEntity<Object> getprePostSittings() {
		PreSittingInfo bo = new PreSittingInfo();
		List<PreSittingBO> presit = new ArrayList<PreSittingBO>();
		List<PreSittingBO> postSit = new ArrayList<PreSittingBO>();
		List<PreSittingBO> sittings = new ArrayList<PreSittingBO>();

		PreSittingBO preSitting1 = new PreSittingBO();
		PreSittingBO preSitting2 = new PreSittingBO();

		preSitting1.setTitle("Sitting Notice");
		preSitting1.setKey("1");
		preSitting1.setUrl(url + "20090819VS_092754.pdf");
		//preSitting1.setIcon("");
		preSitting1.setDocType("pdf");
		
		preSitting2.setTitle("Order Book");
		preSitting2.setKey("2");
		preSitting2.setUrl(url + "Hansard Admin Module Ministry Training Guide_V1.0.pdf");
		//preSitting2.setIcon("");
		preSitting2.setDocType("pdf");

		PreSittingBO preSitting3 = new PreSittingBO();
		PreSittingBO preSitting4 = new PreSittingBO();
		PreSittingBO preSitting5 = new PreSittingBO();

		preSitting3.setTitle("Standing Order");
		preSitting3.setKey("3");
		preSitting3.setUrl(url + "20090819VS_092754.pdf");
		//preSitting3.setIcon("");
		preSitting3.setDocType("pdf");

		preSitting4.setTitle("Statuses Online");
		preSitting4.setKey("4");
		preSitting4.setUrl("https://www.parliament.gov.sg/");
		//preSitting4.setIcon("");
		preSitting4.setDocType("link");

		preSitting5.setTitle("List of Paper Presented");
		preSitting5.setKey("5");
		preSitting5.setUrl("https://www.parliament.gov.sg/");
		//preSitting5.setIcon("");
		preSitting5.setDocType("link");

		presit.add(preSitting1);
		presit.add(preSitting2);
		presit.add(preSitting3);
		presit.add(preSitting4);

		bo.setPresit(presit);
		bo.setPostsit(getPostSittings());
		bo.setSittings(getSittings());
		return new ResponseEntity(bo, HttpStatus.OK);
	}

	private List<SubtitlesBO> getStandingOrders() {
		List<SubtitlesBO> subtitles = new ArrayList<SubtitlesBO>();

		SubtitlesBO subtittle1 = new SubtitlesBO();
		subtittle1.setTitle("STANDING ORDERS OF THE PARLIAMENT OF SINGAPORE ,2017 Reprint (8 May 2017)");
		subtittle1.setUrl(
				url + "Assent to Bills - President's Opinion for Supply Bill and Sup Supply (FY 2008) Bill.pdf");
		/*
		 * SubtitlesBO subtittle2 = new SubtitlesBO(); subtittle2.
		 * setTitle("NOTICE OF List of paper Presented FOR SITTING , 24 NOV 2019 AT 1.30 PM"
		 * ); subtittle2.setUrl(url+"Report.pdf");
		 * 
		 * SubtitlesBO subtittle3 = new SubtitlesBO();
		 * subtittle3.setTitle("NOTICE OF Standing Orders , 24 NOV 2019 AT 1.30 PM");
		 * subtittle3.setUrl(url+"Report.pdf");
		 * 
		 * SubtitlesBO subtittle4 = new SubtitlesBO();
		 * subtittle4.setTitle("NOTICE OF Statutes Online , 24 NOV 2019 AT 1.30 PM");
		 * subtittle4.setUrl(url+"Report.pdf");
		 */

		subtitles.add(subtittle1);

		return subtitles;
	}

	private List<SubtitlesBO> getOrderBoooks() {
		List<SubtitlesBO> subtitles = new ArrayList<SubtitlesBO>();

		SubtitlesBO subtittle1 = new SubtitlesBO();
		subtittle1.setTitle("ORDER BOOK NO. 61 of 2019, 11 February 2019");
		subtittle1.setUrl(url + "B520120911report (1).pdf");

		/*
		 * SubtitlesBO subtittle2 = new SubtitlesBO(); subtittle2.
		 * setTitle("NOTICE OF List of paper Presented FOR SITTING , 24 NOV 2019 AT 1.30 PM"
		 * ); subtittle2.setUrl(url+"Report.pdf");
		 * 
		 * SubtitlesBO subtittle3 = new SubtitlesBO();
		 * subtittle3.setTitle("NOTICE OF Standing Orders , 24 NOV 2019 AT 1.30 PM");
		 * subtittle3.setUrl(url+"Report.pdf");
		 * 
		 * SubtitlesBO subtittle4 = new SubtitlesBO();
		 * subtittle4.setTitle("NOTICE OF Statutes Online , 24 NOV 2019 AT 1.30 PM");
		 * subtittle4.setUrl(url+"Report.pdf");
		 */

		subtitles.add(subtittle1);

		return subtitles;
	}

	private List<PreSittingBO> getPostSittings() {
		List<PreSittingBO> postsit = new ArrayList<PreSittingBO>();

		PreSittingBO postSitting1 = new PreSittingBO();
		PreSittingBO postSitting2 = new PreSittingBO();
		PreSittingBO postSitting3 = new PreSittingBO();
		PreSittingBO postSitting4 = new PreSittingBO();
		PreSittingBO postSitting5 = new PreSittingBO();

		postSitting1.setTitle("Order Paper");
		postSitting1.setKey("1");
		postSitting1.setUrl(url + "Hansard Admin Module Ministry Training Guide_V1.0.pdf");
		postSitting1.setIcon("");
		postSitting1.setDocType("pdf");

		postSitting2.setTitle("Order Paper Supplement");
		postSitting2.setKey("2");
		postSitting2.setUrl(url + "President Opinions.pdf");
		postSitting2.setIcon("");
		postSitting2.setDocType("pdf");

		postSitting3.setTitle("Daily Working Paper- COS");
		postSitting3.setKey("3");
		postSitting3.setUrl(url + "B520120911report (1).pdf");
		postSitting3.setIcon("");
		postSitting3.setDocType("pdf");

		postSitting4.setTitle("List of bills introduced");
		postSitting4.setKey("4");
		postSitting4.setUrl("https://www.parliament.gov.sg/");
		postSitting4.setIcon("");
		postSitting4.setDocType("link");

		postSitting5.setTitle("List of MP's scheduled to speak");
		postSitting5.setKey("5");
		postSitting5.setUrl(url + "President Opinions.pdf");
		postSitting5.setIcon("");
		postSitting5.setDocType("pdf");

		postsit.add(postSitting1);
		postsit.add(postSitting2);
		postsit.add(postSitting3);
		postsit.add(postSitting4);
		postsit.add(postSitting5);
		return postsit;
	}

	private List<PreSittingBO> getSittings() {
		List<PreSittingBO> postsit = new ArrayList<PreSittingBO>();

		PreSittingBO postSitting1 = new PreSittingBO();
		PreSittingBO postSitting2 = new PreSittingBO();
		PreSittingBO postSitting3 = new PreSittingBO();
		PreSittingBO postSitting4 = new PreSittingBO();
		PreSittingBO postSitting5 = new PreSittingBO();

		postSitting1.setTitle("Official Reports (Hansard)");
		postSitting1.setKey("1");
		postSitting1.setUrl("https://www.parliament.gov.sg/");
		postSitting1.setIcon("");
		postSitting1.setDocType("link");

		postSitting2.setTitle("List of Votes and Proceedings");
		postSitting2.setKey("2");
		postSitting2.setUrl("https://www.parliament.gov.sg/");
		postSitting2.setIcon("");
		postSitting2.setDocType("link");

		postSitting3.setTitle("Circulars for written answers");
		postSitting3.setKey("3");
		postSitting3.setUrl("https://www.parliament.gov.sg/");
		postSitting3.setIcon("");
		postSitting3.setDocType("link");

		postSitting4.setTitle("Circulars for written answers to oral PQ's not reached by end of Question Time");
		postSitting4.setKey("4");
		postSitting4.setUrl("https://www.parliament.gov.sg/");
		postSitting4.setIcon("");
		postSitting4.setDocType("link");

		postSitting5.setTitle("Select Committee Reports");
		postSitting5.setKey("5");
		postSitting5.setUrl("https://www.parliament.gov.sg/");
		postSitting5.setIcon("");
		postSitting5.setDocType("link");


		/*
		 * SubtitlesBO subtittle4 = new SubtitlesBO(); subtittle4.
		 * setTitle("SELECT COMMITEE REPORTS FOR SITTING , 16 OCT 2019 AT 1.30 PM");
		 * subtittle4.setUrl(url+"Report.pdf");
		 */

		postsit.add(postSitting1);
		postsit.add(postSitting2);
		postsit.add(postSitting3);
		postsit.add(postSitting4);
		postsit.add(postSitting5);
		return postsit;
	}

	

	

	private List<SittingBO> prepareSittings() {
		List<SittingBO> sittings = new ArrayList<SittingBO>();
		SittingBO sitting1 = new SittingBO();
		sitting1.setSittingDate("30/10/2019");
		sitting1.setSittingdocs(prepareSittingdocs());
		sitting1.setSittingNo(142);

		SittingBO sitting2 = new SittingBO();
		sitting2.setSittingDate("25/10/2019");
		sitting2.setSittingdocs(prepareSittingdocs());
		sitting2.setSittingNo(141);

		SittingBO sitting3 = new SittingBO();
		sitting3.setSittingDate("16/10/2019");
		sitting3.setSittingdocs(prepareSittingdocs());
		sitting3.setSittingNo(140);

		sittings.add(sitting1);
		sittings.add(sitting2);
		sittings.add(sitting3);

		return sittings;

	}

	private List<SittingdocBO> prepareSittingdocs() {
		List<SittingdocBO> sittingdocs = new ArrayList<SittingdocBO>();

		SittingdocBO sittingdocBO1 = new SittingdocBO();
		sittingdocBO1.setTitle("PARLIAMENT OF SINGAPORE");
		sittingdocBO1.setDocs(prepareDocs());

		SittingdocBO sittingdocBO2 = new SittingdocBO();
		sittingdocBO2.setTitle("PARLIAMENT OF SINGAPORE");
		sittingdocBO2.setDocs(prepareDocs());

		SittingdocBO sittingdocBO3 = new SittingdocBO();
		sittingdocBO3.setTitle("PARLIAMENT OF SINGAPORE");
		sittingdocBO3.setDocs(prepareDocs());

		sittingdocs.add(sittingdocBO1);
		sittingdocs.add(sittingdocBO2);
		sittingdocs.add(sittingdocBO3);

		return sittingdocs;
	}

	private List<DocsBO> prepareDocs() {
		List<DocsBO> docs = new ArrayList<DocsBO>();
		// String baseUrl = protocal+host+":"+port+context+"/files/";
		// String baseUrl = host+context+"/files/";
		String baseUrl = url;
		System.out.println("baseUrl :::" + url);

		DocsBO docsBO1 = new DocsBO();
		docsBO1.setDocTitle("PAC-Rept2008.pdf");
		docsBO1.setUrl(baseUrl + "PAC-Rept2008.pdf");

		DocsBO docsBO2 = new DocsBO();
		docsBO2.setDocTitle("Report.pdf");
		docsBO2.setUrl(baseUrl + "Report.pdf");

		docs.add(docsBO1);
		docs.add(docsBO2);

		return docs;
	}

	public List<NotificationBo> getNotificationLeaves() {

		List<NotificationBo> notificationLeaves = new ArrayList<NotificationBo>();

		NotificationBo noficationLeave1 = new NotificationBo();
		noficationLeave1.setTitle("SG-PARL_LEAVES");
		noficationLeave1.setDescription("Your Leave is Approved");
		noficationLeave1.setDate("04/10/2019");
		noficationLeave1.setTime("1.30 pm");
		noficationLeave1.setNotificationType("LEAVES");
		noficationLeave1.setIsread(false);

		NotificationBo noficationLeave2 = new NotificationBo();
		noficationLeave2.setTitle("SG-PARL-LEAVES");
		noficationLeave2.setDescription("Your Leave from 2nd October to 10 October is Approved");
		noficationLeave2.setDate("2/10/2019");
		noficationLeave2.setTime("1.30 pm");
		noficationLeave2.setNotificationType("LEAVES");
		noficationLeave2.setIsread(true);

		NotificationBo noficationLeave3 = new NotificationBo();
		noficationLeave3.setTitle("SG-PARL-MP");
		noficationLeave3.setDescription("List of MP's Speaking for the Sitting");
		noficationLeave3.setDate("10/09/2019");
		noficationLeave3.setTime("4.30 pm");
		noficationLeave3.setNotificationType("LEAVES");
		noficationLeave3.setIsread(true);

		NotificationBo noficationLeave4 = new NotificationBo();
		noficationLeave4.setTitle("SG-PARL-SIITNG");
		noficationLeave4.setDescription("Sitting Resumes at 4.30 pm");
		noficationLeave4.setDate("24/09/2019");
		noficationLeave4.setTime("3.00 pm");
		noficationLeave4.setNotificationType("LEAVES");
		noficationLeave4.setIsread(false);

		notificationLeaves.add(noficationLeave1);
		notificationLeaves.add(noficationLeave2);
		// notificationLeaves.add(noficationLeave3 );
		// notificationLeaves.add(noficationLeave1 );

		return notificationLeaves;
	}

	public List<NotificationBo> getNotificationPBs() {

		NotificationInfoBO bo = new NotificationInfoBO();
		List<NotificationBo> notificationPBs = new ArrayList<NotificationBo>();

		NotificationBo noficationPBs1 = new NotificationBo();
		// noficationPBs1.setTitle("SG-PARL-SIITNG");
		noficationPBs1.setTitle("PQ");
		noficationPBs1.setDescription(
				"Income Criterion for Citizens Seeking Pro-Bono Services from Legal Aid Bureau  is approved");
		noficationPBs1.setDate("03/10/2019");
		noficationPBs1.setTime("1.30 pm");
		noficationPBs1.setNotificationType("PARL BUSINESS");
		noficationPBs1.setIsread(false);

		NotificationBo noficationPBs2 = new NotificationBo();
		noficationPBs2.setTitle("BILL");
		noficationPBs2.setDescription("Children and Young Persons (Amendment) Bill” is withdrawn");
		noficationPBs2.setDate("02/10/2019");
		noficationPBs2.setTime("12.30 am");
		noficationPBs2.setNotificationType("PARL BUSINESS");
		noficationPBs2.setIsread(true);

		NotificationBo noficationPBs3 = new NotificationBo();
		noficationPBs3.setTitle("SG-PARL-MP");
		noficationPBs3.setDescription("List of MP's Speaking for the Sitting");
		noficationPBs3.setDate("10/09/2019");
		noficationPBs3.setTime("4.30 pm");
		noficationPBs3.setNotificationType("PARL BUSINESS");
		noficationPBs3.setIsread(true);

		NotificationBo noficationPBs4 = new NotificationBo();
		noficationPBs4.setTitle("Adjournment");
		noficationPBs4.setDescription("Adjournment motion won balloting for sitting date 4/10/2019");
		noficationPBs4.setDate("4/09/2019");
		noficationPBs4.setTime("3.00 pm");
		noficationPBs4.setNotificationType("PARL BUSINESS");
		noficationPBs4.setIsread(false);

		notificationPBs.add(noficationPBs1);
		notificationPBs.add(noficationPBs2);
		// notificationPBs.add(noficationPBs3 );
		notificationPBs.add(noficationPBs4);

		return notificationPBs;
	}

	public List<NotificationBo> getNotificationOthers() {

		NotificationInfoBO bo = new NotificationInfoBO();
		List<NotificationBo> notificationOthers = new ArrayList<NotificationBo>();

		NotificationBo noficationOthers1 = new NotificationBo();
		noficationOthers1.setTitle("SG-PARL");
		noficationOthers1.setDescription(
				"Speaker's Visit to Bangkok, Thailand, for the 40th General Assembly of the ASEAN Inter-Parliamentary Assembly");
		noficationOthers1.setDate("24/10/2019");
		noficationOthers1.setTime("1.30 pm");
		noficationOthers1.setNotificationType("OTHERS");
		noficationOthers1.setIsread(false);

		NotificationBo noficationOthers2 = new NotificationBo();
		noficationOthers2.setTitle("SG-PARL");
		noficationOthers2.setDescription("Meeting with Speaker of the Parliament of Bangladesh and her Delegation");
		noficationOthers2.setDate("14/10/2019");
		noficationOthers2.setTime("1.30 pm");
		noficationOthers2.setNotificationType("OTHERS");
		noficationOthers2.setIsread(true);

		NotificationBo noficationOthers3 = new NotificationBo();
		noficationOthers3.setTitle("SG-PARL-MP");
		noficationOthers3.setDescription("List of MP's Speaking for the Sitting");
		noficationOthers3.setDate("10/09/2019");
		noficationOthers3.setTime("4.30 pm");
		noficationOthers3.setNotificationType("MP");
		noficationOthers3.setIsread(true);

		NotificationBo noficationOthers4 = new NotificationBo();
		noficationOthers4.setTitle("SG-PARL-SIITNG");
		noficationOthers4.setDescription("Sitting Resumes at 4.30 pm");
		noficationOthers4.setDate("24/09/2019");
		noficationOthers4.setTime("3.00 pm");
		noficationOthers4.setNotificationType("SIITNG");
		noficationOthers4.setIsread(false);

		notificationOthers.add(noficationOthers1);
		notificationOthers.add(noficationOthers2);
		// notificationOthers.add(noficationOthers3 );
		// notificationOthers.add(noficationOthers4 );

		return notificationOthers;
	}

}
