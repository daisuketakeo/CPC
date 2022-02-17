delete from user_master;
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('ko01','KO01','a','KO01');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('cp01','CP01','a','CP01');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('cp02','CP02','a','CP02');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('cp03','CP03','a','CP03');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('qa01','QA01','a','QA01');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('qc01','QC01','a','QC01');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('qc02','QC02','a','QC02');

delete from WORK_MASTER;
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('QC','QC01','001','QC01,QC02','１） A "Received Label" issued by QA is attached to the received product, and it is transported to the receiving test site.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('QC','QC02','001','QC01,QC02','１） Enter the Lot # and expiration date, and perform the acceptance test according to the "(SOP-M-MSC-001Appx1) Acceptance Form".');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('QC','QC03','001','QC01,QC02','１） Print out the "User lot #" that will be issued after QA approval and attach it to the product.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('QC','QC04','001','QC01,QC02','１）Store incoming products in accordance with the product handling instructions, either on racks in a storage room (20°C-28°C), in a refrigerated showcase for medicines (4°C), in a medical freezer (-30°C), or in a deep freezer (-80°C), and indicate the storage location.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('QA','QA01','001','QA01','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('IS','IS01','001','QA01','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('IS','IS02','001','QA01','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP101','001','KO01','１） Print out the kit label and attach it to the kit product basket.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP101','002','KO01','２） Place the items listed in the table below in the kit basket and scan the RFID.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP101','003','KO01','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP102','001','KO01','１） Print out the kit label and attach it to the kit product basket.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP102','002','KO01','２） Place the items listed in the table below in the kit basket and scan the RFID.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP102','003','KO01','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP103','001','KO01','１） Print out the kit label and attach it to the kit product basket.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP103','002','KO01','２） Place the items listed in the table below in the kit basket and scan the RFID.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP103','003','KO01','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP104','001','CP02,CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP1','EP105','001','CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','001','CP01','１） Preheat the dry bath to 37°C.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','002','CP01','２） Heat 5 mL of medium to 37°C.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','003','CP01','３） Heat the vial of frozen cells in a dry bath and collect the thawed solution in a 15-mL centrifuge tube.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','004','CP01','４) Add 1 ml of medium to a 15 ml tube and mix gently.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','005','CP01','５） Centrifugation 1500 rpm for 3 min at room temperature.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','006','CP01','６） Remove the supernatant and suspend the cells in 500-1000 µL of the medium.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','007','CP01','７） Add an equal volume of trypan blue to 10 µL of cell suspension and mix.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','008','CP01','８） Count cell number of 10µL.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','009','CP01','９） Adjust the cell density to 1.5x104 cells/mL and seed 39 mL into a T175 flask.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','010','CP01','１０）Incubate for　4 days at 37℃ under 2% CO2 condition.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','011','CP01','１１）After incubation, remove the supernatant and rise the precipitation with 19mL of PBS.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','012','CP01','１２） Remove PBS and add 5.8 mL of TrypLE Select.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','013','CP01','１３）Incubate for 3min at 37℃.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','014','CP01','１４） Add 19 mL of a medium and pipette once or twice.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','015','CP01','１５） Collect the cell suspension in a centrifuge tube and add 38 mL of culture medium.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','016','CP01','１６）Centrifuge with 1500rpm for 3min at room temperature');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','017','CP01','１７）Remove the supernatant and recover the precipitant with 19mL of medium.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP201','018','CP01','１８） After counting the cells, adjust the cell density 1.5x104 cells/mL and fill 140 mL into a bag.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP202','001','CP02,CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP2','EP203','001','CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET1','ET101','001','CP01','１） Confirm that there are no significant abnormalities in the shape of the cells or colonies by microscopy.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET1','ET102','001','CP01','１）Count the cell number using a one-cell counter. ２） Compare with the number of cells at the time of seeding, determine the doubling time through culture, and confirm that it is within 27 hours. 。');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET1','ET103','001','CP02,CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET1','ET104','001','CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP301','001','KO01','１） Print out the kit label and attach it to the kit product basket.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP301','002','KO01','２） Place the items listed in the table below in the kit basket and scan the RFID.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP301','003','KO01','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP302','001','KO01','１） Print out the kit label and attach it to the kit product basket.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP302','002','KO01','２） Place the items listed in the table below in the kit basket and scan the RFID.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP302','003','KO01','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP303','001','KO01','１） Print out the kit label and attach it to the kit product basket.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP303','002','KO01','２） Place the items listed in the table below in the kit basket and scan the RFID.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP303','003','KO01','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP304','001','CP02,CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP3','EP305','001','CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP4','EP401','001','CP01','１） Select a culture recipe on the CellQualia control terminal.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP4','EP401','002','CP01','２） Scan the kit labels [Room Temperature] to verify that they are the intended material.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP4','EP401','003','CP01','３） Install the consumables according to the display indication of CellQualia. ');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP4','EP401','004','CP01','４） Follow the instructions to fill the bag with the chemical and connect it to CellQualia. 。');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP4','EP404','001','CP01','１） After confirming that the QC test has been passed in the preculture, adjust the concentration of the cell suspension and fill the stirring bag. Immediately attach the stirring bag to the device. 。');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP4','EP404','002','CP01','２）Start run.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP4','EP404','003','CP01','３） After the completion of the culture, the harvest bag is promptly removed and moved to the next step.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP4','EP405','001','CP01','４） Review the Post-batch overview (SOP-M-MSC-006Appx.1) and confirm that there are no deviations.　　　Remove and dispose of used chemical bags and channels according to the procedure.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP4','EP406','001','CP02,CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP4','EP407','001','CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET2','ET201','001','QC01,QC02','１） Quantify the concentration of cysteine in the supernatant of the culture medium using LC-MS. Confirm that its concentration is below the specified value throughout the incubation.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET2','ET202','001','QC01,QC02','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET2','ET203','001','QA01','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP5','EP501','001','CP02,CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP5','EP502','001','CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET3','ET301','001','QC01,QC02','１） Confirm that there are no significant abnormalities in the shape of the cells or colonies by microscopy.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET3','ET302','001','QC01,QC02','１）Count the cell number using a one-cell counter. ２） Compare with the number of cells at the time of seeding, determine the doubling time through culture, and confirm that it is within 27 hours. 。');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET3','ET303','001','QC01,QC02','１） Cell length is measured by image analysis, and at least 90% of the population should be within ±20% of the maximum frequency value.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET3','ET304','001','QC01,QC02','１） Confirm that the positivity of CD73, CD90, and CD105 is greater than 70%, using FACS.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET3','ET305','001','QC01,QC02','１） Confirm that less than 30% of cells have mitochondrial size greater than the specified value, using FACS.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET3','ET306','001','QC01,QC02','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET3','ET307','001','QA01','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP6','EP601','001','CP02,CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('EP6','EP602','001','CP03','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET4','ET401','001','QC01,QC02','１） Culture the cells after freezing and confirm that the viability is 80% or higher.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET4','ET402','001','QC01,QC02','１） After the addition of Ionomycin/PMA, quantify IL-10 and INF-γ in the supernatant of the medium by ELISA, and confirm that they are in the specified amounts.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET4','ET403','001','QC01,QC02','１） Confirm that no cloudiness is observed by naked eye observation, after 14 days of incubation using the membrane filter method.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET4','ET404','001','QC01,QC02','１） Quantify endotoxin by the kinetic colorimetric method and confirm that it is below the specified level.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET4','ET405','001','QC01,QC02','１） Confirm that no band of the target amplified product is detected in the electrophoresis image after the Nested-PCR method.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET4','ET406','001','QC01,QC02','１） Quantify the copy number of the nucleotide sequence in the target region by real-time PCR. Confirm that the copy number is below the detection limit.');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET4','ET407','001','QC01,QC02','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('ET4','ET408','001','QA01','');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID,AUTHORITY, WORK) values ('BR','BR01','001','QA01','');

delete from PROCESS_MASTER;
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('IS','Manufacturing order');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('EP1','Kitting for the preculture');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('EP2','preculture');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('EP3','Kitting for the expansion');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('EP4','Expansion (CellQualia)');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('EP5','Buffer exchange');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('EP6','Freezing');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('ET1','QC-1');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('ET2','QC-2');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('ET3','QC-3');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('ET4','QC-4');
insert into PROCESS_MASTER (PROCESS_ID,PROCESS_NAME) values('BR','Batch release');

delete from WORK_GROUP_MASTER;
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('QC','QC01','Receiving','01','','Q02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('QC','QC02','Incoming inspection','02','QC01','Q03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('QC','QC03','Registered','03','QA01','Q05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('QC','QC04','Storage','04','QC03','Q06');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('QA','QA01','Approve','05','QC02','Q04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('IS','IS01','指図作成','－','','I01');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('IS','IS02','指図リリース','－','IS01','I02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP1','EP101','1. Kitting for Preculture (Room Temperature)','06','IS02','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP1','EP102','2. Kitting for Preculture (4℃)','06','EP101','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP1','EP103','3. Kitting for Preculture (-20℃)','06','EP102','P03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP1','EP104','Confirm','101','EP103','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP1','EP105','Approve','102','EP104','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP2','EP201','1. Preculture','07','EP105','P03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP2','EP202','Confirm','101','EP201','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP2','EP203','Approve','102','EP202','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET1','ET101','1. Microscopy','14','EP203','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET1','ET102','2. Growth','15','ET101','T03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET1','ET103','Confirm','103','ET102','T04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET1','ET104','Approve','104','ET103','T05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP3','EP301','1. Kitting for Expansion (Room Temperature)','06','ET104','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP3','EP302','2. Kitting for Expansion (4℃)','06','EP301','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP3','EP303','3. Kitting for Expansion (-20℃)','06','EP302','P03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP3','EP304','Confirm','101','EP303','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP3','EP305','Approve','102','EP304','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP401','1. Preparation','08','EP305','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP404','2. Culture','09','EP401','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP405','3. Clearance','10','EP404','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP406','Confirm','101','EP405','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP407','Approve','102','EP406','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET2','ET201','1. Medium analysis','14','EP407','T03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET2','ET202','Confirm','103','ET201','T04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET2','ET203','Approve','104','ET202','T05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP5','EP501','Confirm','101','EP407','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP5','EP502','Approve','102','EP501','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET301','1. Microscopy','14','EP502','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET302','2. Growth','15','ET301','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET303','3. Distribution of cell shapes','14','ET302','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET304','4. Antigen Analysis','17','ET303','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET305','5. Size of mitochondria','18','ET304','T03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET306','Confirm','103','ET305','T04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET307','Approve','104','ET306','T05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP6','EP601','Confirm','101','EP502','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP6','EP602','Approve','102','EP601','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET401','1. Cell viability after freezing and thawing','15','EP602','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET402','2. Cytokine secretion','15','ET401','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET403','3. Sterility test','18','ET402','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET404','4. Endotoxin test','15','ET403','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET405','5. Mycoplasma test','20','ET404','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET406','6. Virus test','21','ET405','T03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET407','Confirm','103','ET406','T04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET408','Approve','104','ET407','T05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('BR','BR01','Batch Record Review','19','','B03');

delete from STATUS_MASTER;
insert into STATUS_MASTER values ('AC','Q01','Acceptance前');
insert into STATUS_MASTER values ('AC','Q02','Receiving済');
insert into STATUS_MASTER values ('AC','Q03','Incoming inspection済');
insert into STATUS_MASTER values ('AC','Q04','Approved by QA');
insert into STATUS_MASTER values ('AC','Q05','Registered済');
insert into STATUS_MASTER values ('AC','Q06','Storage済');
insert into STATUS_MASTER values ('AC','Q07','中止');
insert into STATUS_MASTER values ('IS','I01','指図作成済');
insert into STATUS_MASTER values ('IS','I02','指図リリース済');
insert into STATUS_MASTER values ('IS','I03','製造中');
insert into STATUS_MASTER values ('IS','I04','製造終了');
insert into STATUS_MASTER values ('IS','I05','完了');
insert into STATUS_MASTER values ('IS','I06','逸脱');
insert into STATUS_MASTER values ('IS','I07','中止');
insert into STATUS_MASTER values ('PR','P01','未実施');
insert into STATUS_MASTER values ('PR','P02','製造中');
insert into STATUS_MASTER values ('PR','P03','確認待ち');
insert into STATUS_MASTER values ('PR','P04','承認待ち');
insert into STATUS_MASTER values ('PR','P05','完了');
insert into STATUS_MASTER values ('PR','P06','中止');
insert into STATUS_MASTER values ('PR','T01','未実施');
insert into STATUS_MASTER values ('PR','T02','試験中');
insert into STATUS_MASTER values ('PR','T03','確認待ち');
insert into STATUS_MASTER values ('PR','T04','承認待ち');
insert into STATUS_MASTER values ('PR','T05','完了');
insert into STATUS_MASTER values ('PR','T06','中止');
insert into STATUS_MASTER values ('PR','B01','未実施');
insert into STATUS_MASTER values ('PR','B02','Decision中');
insert into STATUS_MASTER values ('PR','B03','完了');
insert into STATUS_MASTER values ('PR','B04','中止');
insert into STATUS_MASTER values ('WR','W99','逸脱');

