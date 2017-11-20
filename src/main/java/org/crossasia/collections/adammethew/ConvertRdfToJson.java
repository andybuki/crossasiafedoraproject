package org.crossasia.collections.adammethew;

import org.apache.camel.Exchange;
import org.apache.camel.component.solr.SolrConstants;
import org.json.XML;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.XPathBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.crossasia.domain.Products;
import org.fcrepo.client.FcrepoClient;

import javax.jms.ConnectionFactory;

public class ConvertRdfToJson {

    private static final String INDEXING_URI = "CamelIndexingUri";

    private String userID = "bypassAdmin";

    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:dcterms=\"http://purl.org/dc/terms/\" xmlns:collex=\"http://www.collex.org/schema#\" xmlns:amd=\"http://www.amdigital.co.uk/schema#\" xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\" xmlns:role=\"http://www.loc.gov/loc.terms/relators/\">\n" +
                "  <amd:document rdf:about=\"http://www.archivesdirect.amdigital.co.uk/Documents/Details/115149\">\n" +
                "    <dc:title>Supply of aircraft to China</dc:title>\n" +
                "    <collex:date>1955</collex:date>\n" +
                "    <dc:date>1955</dc:date>\n" +
                "    <role:PBL>Foreign Office</role:PBL>\n" +
                "    <dc:source>Archives Direct</dc:source>\n" +
                "    <collex:genre>Collection</collex:genre>\n" +
                "    <collex:fulltext><![CDATA[FO 371/115149\n" +
                "Supply of aircraft to China\n" +
                "(1955)\n" +
                "115149\n" +
                "mmmm\n" +
                "n n n n p\n" +
                "u u u u C\n" +
                "FAR EASTERN DEPARTMENT\n" +
                "K\n" +
                "FROM\n" +
                "teHihv\n" +
                "<1/\n" +
                "F\n" +
                "^#f>oavn ov\n" +
                "Dated\n" +
                "sjo\n" +
                "/TfU^U ^\n" +
                "/4qjX. ^WO A6iiv &, ^ 001^4\n" +
                "Received in /\\\n" +
                "Registry- ^jUKL U\n" +
                "References to former relevant papers\n" +
                "fCU /I .\n" +
                "MINUTES\n" +
                "Vm/\" L5u|6 .\n" +
                "-\n" +
                "(Print)\n" +
                "115149\n" +
                "(How disposed of)\n" +
                "U-**\n" +
                "cu*\n" +
                "t-vw-\n" +
                ",v*n\n" +
                "H. .&*'b .\n" +
                "^,'Tcp/\n" +
                "rt\n" +
                "u<, /vLJU ^ ^ ^\n" +
                "(Action\n" +
                "completed)\n" +
                "^il7\n" +
                "d\n" +
                "(Index)\n" +
                ",IM^(\n" +
                "1 1 Vs?\n" +
                "References to later relevant papas\n" +
                "TW r<«< iw-U«\n" +
                "toj %P uJLJ$*Kr VlAf fhtt AdKz (4*Ot/Js tR*n\\S.\n" +
                "m^m/UI Jlr J* **L fa MtJZ*/ /n,\n" +
                "1* .\n" +
                "*** A^o CjuU****\n" +
                "w\n" +
                "44875\n" +
                "y\n" +
                "* .\n" +
                "y y \"\n" +
                "Arvx*-^*^** ^ »?\">»*«»*«\n" +
                "tlVv ZtUvUCy («..t.i)\n" +
                "H,* r.tcn .\n" +
                "A .A.\n" +
                "Number of copies\n" +
                "3\n" +
                "Number-of -copies'\n" +
                "of enclosures\n" +
                ".T3V.. ;t..v .Yf«wwv, V. rwuwr\n" +
                "* . » i, Oi !.\n" +
                "?>? - '.V-\n" +
                "\\ \" xx.\n" +
                "' ^ v.eV\n" +
                "0000\n" +
                ".iifF\n" +
                "FROM A*' . AcMtO,\n" +
                "/vo. f //55\n" +
                "Da/ed 7\n" +
                "Received in t 4) 4\n" +
                "Registry- . ?>/ fl.\n" +
                "References to former relevant papers\n" +
                "(Print)\n" +
                "(How disposed of)\n" +
                ".Ixj. .kS.x.. ... Av.CC.\n" +
                "<»CJ. . 1)^ .\n" +
                "Itf-\n" +
                "\"*il\n" +
                "(Action\n" +
                "completed)\n" +
                "(Index)\n" +
                "FAR EASTERN DEPARTMENT\n" +
                "CHINA\n" +
                "I\n" +
                "F\n" +
                "cnx*\n" +
                "of\n" +
                "<tiUL\n" +
                "<2W- ' ,<w\n" +
                "MINUTES\n" +
                "References to Inter relevant papers\n" +
                "is UxKmaCU^i ddAlk u ^\n" +
                "ck UuvxUt uUmaUU sm tU |vuu/Um. ^\n" +
                "WlViUdLvu^WlSU\n" +
                "^ k*1 14 ^ai CWTU-lu'i )^WA 4itta ttc\n" +
                "^VKtu tvl ivUwV) tic CiuvUid tui\n" +
                "a> ^ CWnuc ^ ^\n" +
                "\"K^.Wu^ho lUfuU ^ CW Uuh,**U. d.t\n" +
                "tU (W^ . ScvWt «\n" +
                "^AuU^tsYUC^btUuv^^Uk*^\n" +
                "VvUuJ fmV-C^yU^ ke^udl.SAtt, .*. t^UV,\n" +
                "^ H-Tg's 4<uUU^\\wtt«.\n" +
                "WttUvL.\n" +
                "V ,y | 46(X>4 }) Avf ttu^f 4^ n\\.1t.- *vwl>*»|o\n" +
                ".y u*<f.\n" +
                "Ua. Vt'iW U4k ixowH, tHvwtLUti.X >0. ti.uvf X\n" +
                "rtU 4 4*u'#1i ttwi« , tW iw^ IXulW W iw\n" +
                "''e CW* wWiwy ^ rtrtiwtu. fvw. tkc\n" +
                "W Ut frttiXiU\n" +
                "4; Wt\n" +
                "M/T:cv4,\n" +
                "U\\%^ ^ ttuv UtCv\n" +
                "^wN^yi»\n" +
                "juu<*y£'\n" +
                "\"/,\n" +
                "l*U\n" +
                "u< fv>-tv<w<y U A-/ A i x\n" +
                "cA\n" +
                "!\n" +
                "\"T**\n" +
                "lL>\n" +
                "JUj\n" +
                "w.^i> A w ^»-\n" +
                "S. tf. n ^ mtm\n" +
                "^ *i t^UuGd U,iK ,\n" +
                "n*»\n" +
                "<h\n" +
                "Number of copies\n" +
                "3\n" +
                ". . ?\n" +
                "Numo i ur cop es\n" +
                "of enclosures\n" +
                "JU<W-e^ *.«.#** .\n" +
                "n n n n L.\n" +
                "u u u u O\n" +
                "\\\n" +
                "M Cl3%(,\n" +
                "_ BRITISH\n" +
                "VA\n" +
                "confukntial\n" +
                "PEKING.\n" +
                "(1384/1/55)\n" +
                "June 30, 1955.\n" +
                "At the reception last night for the Indian Cultural Delegation, Chou\n" +
                "Kn-lai spent almost the whole time before dinner talking to me. The sub¬\n" +
                "ject of our conversation was exclusively the manufacture of civil aircraft\n" +
                "and I used the opportunity to do some propaganda on behalf of Viscounts\n" +
                "and Comets. It was surprising how ignorant Chou En-lai was on the whole\n" +
                "subject . The conversation began by his summoning me across the room to\n" +
                "answer the question whether Convairs were United States or British-made.\n" +
                "Ch'en Ti was also in the group at this moment and didn't know the answer\n" +
                "either . Chou then went on in a very good-humoured way to say how much\n" +
                "the Chinese Government would like to buy civil aircraft from us; and he\n" +
                "even cracked some jokes about the embargo, saying that if he bought civil\n" +
                "aircraft from us he would give a firm promise that only civilians would\n" +
                "travel in them at any time, and also asking whether if we sold aircraft to\n" +
                "Burma, we were not afraid that Burma would pass them on to China. I made\n" +
                "what I hope were appropriate replies and comments at each point. Another\n" +
                "extraordinarily ingenuous question was whether we were manufacturing\n" +
                "4-engined civil aircraft . This gave me an opportunity to say a piece\n" +
                "about Viscount, and with Pu Shou-ch'ang's help, to explain the difference\n" +
                "between turbo-prop and turbo-jet. He expressed amazement when I told him\n" +
                "that the present Prime Minister had gone to and from Geneva last year in a\n" +
                "jet-propelled aircraft and called upon Ri Shou-ch 1 ang to bear witness that\n" +
                "no one had ever told him this before. I then went on to give him a piece\n" +
                "about Comets, drawing on the recent Intel. Chou asked at one moment\n" +
                "whether the civil aircraft industry in England was private enterprise or\n" +
                "state-controlled. The conversation only ended when Chou En-lai was told\n" +
                "that the time had come for him to lead the procession in to dinner.\n" +
                "The only reference to Soviet aircraft construction was when Chou\n" +
                "En-lai remarked incidentally that the Russians were also now m\"Hm, i-t.\n" +
                "- - - - - - ? WV w ? ? KMMrm n ? H ? * - F ? - mm\n" +
                "r- v-LT-t-L x replied tnat 1 knew this and that the\n" +
                "Americans were too, but that for the\n" +
                "time being the United Kingdom had a\n" +
                "substantial lead. He let this pass without comment .\n" +
                "(J. M. Addis)\n" +
                "C. T. Crowe Esq. ,\n" +
                "Foreign Office, S.W.l.\n" +
                "F\n" +
                "FAR EASTERN DEPARTMENT\n" +
                "1. ,\n" +
                "CHINi\n" +
                "Tr\n" +
                "FROM ^ . 0 'fO^XW-\n" +
                "SECRET\n" +
                "fr/a.\n" +
                "a-r/f\n" +
                "QVv. Q ftAJUO (My .\n" +
                "No.\n" +
                "Dated\n" +
                "Received in\n" +
                "Registry- 5 <?/f\n" +
                "References\n" +
                "-A\n" +
                "/Sep ev'H\n" +
                "v*. Cavx-OouA^ .\n" +
                "/mAgLA. (V^v Tl^.\n" +
                "Ci^ L 'b+SJeJl\n" +
                "£Xu**a.\n" +
                "MINUTES\n" +
                "(How disposed of)\n" +
                "Afkr^Y\n" +
                "SU^./Wx.T^SAj./i\n" +
                "(Action\n" +
                "(Index)\n" +
                "completed)\n" +
                "S^i)\n" +
                "[1/uTc^c/^T. i.ft-]\n" +
                "/CUa/ iIaau^\n" +
                "fl#^ i . C./t\n" +
                "Grw^wv# u</v f i(/ ' 4mJ!M(/ |^U (SLa/jc\n" +
                "<\"L vfiVK^tv\n" +
                "^ Ay,.\n" +
                "rt.^. J hJl\n" +
                "^ t'x. ijyiOo^A. ^ <A.\n" +
                "(\"<V. Oc^ijU^ e tvAvwf 'trx.\n" +
                "h-p ua ^ Vvg\n" +
                "(rtFyi^-L k~/vtvM. _ <fx^\n" +
                "At >1 - ^>^>r\n" +
                "A wV yf 2c<# Z^>ia-wi <\n" +
                "AjTZu\n" +
                "40429\n" +
                "n n n n o\n" +
                "u u u u O\n" +
                "*3 /VU3 ft* t).i. - «/\n" +
                "Ul L^J ttu c^x\n" +
                ", . L./aJx . ^ ^ ^\n" +
                "LvW- 1\n" +
                "4^ Axx-Mg *->\n" +
                "tW\" U, U<^ .-> ZU^t ^Ltl£^ aJl r~<\n" +
                "IT Ikg kL_g - Il<f1 ^\n" +
                "i . ,l. ^ It fa\n" +
                "li) JL/kv^ ,i\"*\n" +
                "^.ul-a n SKac4 ^ ^ -A.\n" +
                "/Luu f ''-i£>. ^\n" +
                "CyL -\n" +
                "fr_ ;\n" +
                "rwU\n" +
                "^v*rVt\n" +
                "/ Z«t4\n" +
                "M '\n" +
                ",3\n" +
                "^drxAlcjls, ^xXyf* ^(a<. A»ctc-i<w^f\n" +
                "(f+sU+^ (vc^< IL n 's **<-'-<-\n" +
                "foLj ^tVWXAL,^ 6\\_*^ IuaU~'£\\J^1\\\n" +
                "Pin. <*< 6ST\"\n" +
                "BRITISH SL1BA33Y\n" +
                "PEKING\n" +
                "F\n" +
                "J33\n" +
                "3/0 No. aagg\n" +
                "(1380/6/55)\n" +
                "CONFIDENTIAL\n" +
                "May 18, 1955\n" +
                "Dear Department\n" +
                "1 4 JUN 1966\n" +
                "Fc 'rtf/**'\n" +
                "In our despatch No. 404 of December 31\n" +
                "1954 about the British Trade Mission which\n" +
                "visited Peking in November last, we\n" +
                "reported that the aircraft in which they\n" +
                "were to travel from Canton to Peking was a\n" +
                "Convair. We have now also seen a Convair\n" +
                "at Peking Airfield.\n" +
                "Far Eastern Department,\n" +
                "Foreign Office, 3.W. 1\n" +
                "Yours ever\n" +
                "Minutes.\n" +
                "ji&y^ lk's {h?C~~7 /tX\"7 <Vv </~r t\\.\n" +
                "AAXac/x /Ux/Vc- kvc- (AC^. \\A**(/^U\\^\n" +
                "h . ^ *<< .\n" +
                "/( W<v. /f7 . .\n" +
                "^ /^r 4j\n" +
                "Aaa /V %yy^ Y ?\n" +
                "3'V^' (JLaU^/ t^V\n" +
                "nj h 1,1 '\n" +
                "^ WaV ] ZK^Zaj\n" +
                "Wy, j \"ft\n" +
                "fie /V Mwy Gkuw.^1\n" +
                "^ cUu*:.\n" +
                "«vO- ^ ?P^1 M **\n" +
                "/L'K. Au,, w-U 4c - 4k ^ ,U^U-X\n" +
                "^ (V^' f U ^ U^/'\"\n" +
                "' 7>KrtJ<\n" +
                "7, (k*j>)\n" +
                "OblMTWlO. (AH z^twW A ?>W- «u^'\n" +
                "/k\n" +
                "000 I l\n" +
                "JM -\n" +
                "Minutes,\n" +
                "j <$/ cio eyJb^/\"\n" +
                "J*<sMu CAf-t CCtA*.\n" +
                "s\n" +
                "e\n" +
                "s\n" +
                "<\n" +
                "s\n" +
                "<2\n" +
                "z\n" +
                "i-\n" +
                "U1\n" +
                "t\n" +
                "QC\n" +
                "111\n" +
                "OQ\n" +
                "2\n" +
                "<5\n" +
                "Z\n" +
                "I-\n" +
                "O\n" +
                "1 1\n" +
                "5 5\n" +
                "?r\n" +
                "El\n" +
                "a a\n" +
                "M\n" +
                "o\n" +
                "u>\n" +
                "LA\n" +
                "h-k\n" +
                "?u\n" +
                "sO\n" +
                "x\n" +
                "m\n" +
                "I\n" +
                "x\n" +
                "CZ)\n" +
                "N)\n" +
                "000 :e\n" +
                "SECRET\n" +
                "raOM fHOMQ TO foreign office\n" +
                "013%,\n" +
                "Cyphex/OO?\n" +
                "Mr, O'Neill\n" +
                "MmMZ\n" +
                "August 27, 1955.\n" +
                "DEPARTMENTAL\n" +
                "DISTRIBUTION\n" +
                "D.6.A3 a.m. August 27, 1955.\n" +
                "R.12.A0 p.m. August 27, 1955.\n" +
                "smm fc/ ^ 6 /i\n" +
                "Chancery letter 333 of May 18 to Par Eastern Department.\n" +
                "i\n" +
                "Civil Aviation in China.\n" +
                "I learn on reliable authority that Indian Cultural\n" +
                "Delegation, who were in China from June to August, made\n" +
                "their tour of China in 5 Convairs, and on one occasion when\n" +
                "one aircraft had engine trouble a 6th Convair was produced\n" +
                "at short notice.\n" +
                "DISTRIBUTED TO\n" +
                "Par Eastern Department\n" +
                "South East Asia Department\n" +
                "General Department\n" +
                "B B B\n" +
                "a AUG\n" +
                "£ '*> E\n" +
                "V ^\n" +
                "V.\n" +
                "/\n" +
                "&\n" +
                "It\n" +
                "if\n" +
                "ro\n" +
                "Ul\n" +
                "m\n" +
                "V)\n" +
                ".5?\n" +
                "M\n" +
                "NOTHING TO BE WRITTEN IN THIS MARGIN.\n" +
                "000\n" +
                "13\n" +
                "E.\n" +
                "T\n" +
                "Secret.\n" +
                "OtiCQMtitil\n" +
                "v .\n" +
                "R.\n" +
                "N.\n" +
                "a&x.\n" +
                "yr\n" +
                "Draft.\n" +
                "The Chancery,\n" +
                "Peking.\n" +
                "»l386/3\n" +
                "From: -\n" +
                "Far Eastern\n" +
                "Dept.\n" +
                "rjOJ.\n" +
                "SECRET\n" +
                "out riLB\n" +
                "JrOO\n" +
                "FOREIGN OFFICE , S.W. 1.\n" +
                "V\n" +
                "September, 1955.\n" +
                "Dear Chancery,\n" +
                "Please refer to your telegram No. 81 2\n" +
                "of August 27 about civil aviation in China.\n" +
                "2. We were very interested to hear that the\n" +
                "had\n" +
                "Indian Cultural Delegation/made their tour bv\n" +
                "JiaatVisfa'Wt\n" +
                "Gonvairs. . We have, been trying to Wo ok down\n" +
                "thmk that » ia\n" +
                "me ^ unlikely that the aircraft can have been\n" +
                "imported from the U.S.A. since 1950; the\n" +
                "U.S. security export controls are very\n" +
                "strictly enforced and we do not believe that\n" +
                "the aircraft could have slipped through\n" +
                "without the U.S. authorities being aware of]#».\n" +
                "it. Nevertheless it would be useful if you\n" +
                "could find anything about their date of\n" +
                "C%iK<n«*k«>L\n" +
                "manufacture/ In this connexion we are not\n" +
                "certain that all the Convairs owned by the\n" +
                "Nationalists were flown^to Hong Kong in 1949 ,\n" +
                "bofero thw fleot wao humdul uver to the *\n" +
                "i athnri ttt*? r \"\n" +
                "3. We have also considered the possibility\n" +
                "that these Convairs might have been mistaken\n" +
                "for IL 1 2j|. Convairs apparently look very\n" +
                "similar to these aircraft. Perhaps you\n" +
                "could bear this in mind if you have any\n" +
                "further opportunity to investigate the\n" +
                "existence of these alleged Convairs.\n" +
                "Yours ever,\n" +
                "FAR EASTERN DEPARTMENT.\n" +
                "Hi\n" +
                "VU i FILS\n" +
                "(SO 1386/3)\n" +
                "VOBBZGHf OmOE, 3«Vi. .\n" +
                "QepteiBbey 5, 1935.\n" +
                "Dear Ohnnoopy,\n" +
                "Please refer to your telegram Mb. 312 of\n" +
                "August 27 about civil aviation in China*\n" +
                "2. We were very interested to hear that the*\n" +
                "Indian Cultural Delegation had made their tour\n" +
                "by Convslre. We have been trying to discover how\n" +
                "the Chinese have these aircraft available.\n" +
                "We think that it la unlikely that the aircraft can\n" +
                "have been imported from the United States since\n" +
                "1950 1 the United States security export controls\n" +
                "are very strictly enforced and we do not believe\n" +
                "that the aircraft could have slipped through\n" +
                "without the United States authorities being aware\n" +
                "of it, nevertheless It would be useful if you\n" +
                "could find anything about their date of manufacture\n" +
                "or acquisition by the Chinese Communists, In this\n" +
                "connexion we are not certain that all the Convairs\n" +
                "owned by the nationalists were flown out to Hong\n" +
                "Kong in 1949.\n" +
                "3. We have also considered the possibility that\n" +
                "these Convnlro might hove been mistaken for IL 12*3,\n" +
                "Oonvniro apparently look very similar to these\n" +
                "aircraft, Poxtiape you could bear this in mind if\n" +
                "you have any further opport unity to Investigate the\n" +
                "existence of these alleged Convairs,\n" +
                "Yours ever,\n" +
                "PAR KAflTBHN DEPARTMENT,\n" +
                "The Chancery,\n" +
                "British Embassy,\n" +
                "Peking,\n" +
                "X\n" +
                "n n n\n" +
                "u u u\n" +
                "FAR EASTERN DEPARTMENT\n" +
                "CHINA\n" +
                "FROM jU. . Qctcb*,\n" +
                "40\n" +
                "No- I'hro / n /* $\n" +
                "Dated\n" +
                "Received in\n" +
                "Registry- ^ i\n" +
                "References to former relevant papers\n" +
                "(Print)\n" +
                "(How disposed of)\n" +
                "(Action , , x\n" +
                "completed) V*®\"'\n" +
                "Va-\n" +
                "References to later relevant papers\n" +
                "u\n" +
                "I\n" +
                "MINUTES\n" +
                "V\\v . kVtc A ^ W/Ccu i3a^kAsA\n" +
                "* AVt^Ut Ctpvj VttVv w> - 2, Vo\n" +
                "0 TtiAa* cvimjoAuw ktttv ux \"3, U v> UnUiuA^\n" +
                "^eA ttxAU. WrK- Utv^uJk, tvitu \\ L %2 J\n" +
                "X- fc*-\n" +
                "v - ' \"4\"\n" +
                "<VM_ *W (<_ OvT-^\n" +
                "|k iGrt«'*x^Kx\\ C*T>1 fat* Plr^1^\n" +
                "Vf. /jw.VcAtx . /tvT\n" +
                "(1\n" +
                "47524\n" +
                "oA-\n" +
                "Yi\n" +
                "i\n" +
                "END\n" +
                "I\n" +
                "CONFIDENTIAL\n" +
                "(1380/11/55)\n" +
                "It v>\n" +
                "BRITISH\n" +
                "EE KINO.\n" +
                "August 30, 1955.\n" +
                "r\n" +
                "? ^\n" +
                "The information in our telegram No, 812 of August 7 about\n" +
                "the presence of six Convairs in China was obtained by me from\n" +
                "Brigadier Malik, the Military Attache at the Indian Embassy.\n" +
                "In conversation with him and some friendly Western diplomats I\n" +
                "had drawn attention to an illustration in \"People's China\" or\n" +
                "\"China Reconstructs\" in which a recognisable Convair was shown\n" +
                "taking off from the airfield at Shanghai and had commented that\n" +
                "so far as we knew the Chinese Civil Aviation Corporation only\n" +
                "possessed one Convair. Malik afterwards drew me on one side\n" +
                "and gave me the information reported in our telegram under\n" +
                "reference. Malik did not himself accompany the Indial Cul¬\n" +
                "tural Delegation during any part of their tour in China but\n" +
                "two other diplomatic members of the Indian Embassy staff did.\n" +
                "I have seen a fair amount of Malik since his arrival two or\n" +
                "three months ago and am satisfied that he is a sound staff-\n" +
                "officer who would not make a positive assertion of this kind\n" +
                "without first carefully checking the reliability of the\n" +
                "evidence.\n" +
                "We have of course discussed among ourselves here possible\n" +
                "ways in which the Convairs might have reached China. The only\n" +
                "possible clue, if indeed it rates as such, is Chou En-lai's\n" +
                "jocular reference to the possibility of civil aircraft reaching\n" +
                "China through Burma which I reported in my letter No. 1384/1/55 x j\n" +
                "of June 30, though you will see from the same letter that Chou ^\n" +
                "professed not to know whether Convairs were American or British.\n" +
                "(J. M. Addis)\n" +
                "C. T. Crowe Esq.,\n" +
                "Foreign Office.\n" +
                "]]></collex:fulltext>\n" +
                "  </amd:document>\n" +
                "</rdf:RDF>";

        String json = XML.toJSONObject(xml).toString();
        CamelContext context = new DefaultCamelContext();
        FcrepoClient client = FcrepoClient.client().build();

        final GsonDataFormat gsonDataFormat = new GsonDataFormat();

        gsonDataFormat.setUnmarshalType(Products.class);
        XPathBuilder xpath = new XPathBuilder("/rdf:RDF/rdf:Description/rdf:type[@rdf:resource='http://fedora.info/definitions/v4/indexing#Indexable']");
        xpath.namespace("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        context.setTracing(true);
        context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://10.46.3.100:61616"));
        context.getShutdownStrategy().setLogInflightExchangesOnTimeout(true);
        context.getShutdownStrategy().setTimeout(120000);

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "tcp://localhost:61616");
        context.addComponent("jms",
                JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.stopRoute("nonAuto");

        context.addRoutes(new RouteBuilder() {
                              @Override
                              public void configure() throws Exception {
                                  from("file:data/json")
                                          .unmarshal(gsonDataFormat)
                                          .setBody().simple("${body.products}")
                                          .split(body())
                                          .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_ADD_BEAN))
                                          .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                                          .to("solr://10.46.3.100:8980/solr/andrew_methew");
                              }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}