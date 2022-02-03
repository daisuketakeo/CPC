delete from user_master;
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('ko01','KO01','a','KO01');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('cp01','CP01','a','CP01');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('cp02','CP02','a','CP02');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('cp03','CP03','a','CP03');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('qa01','QA01','a','QA01');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('qc01','QC01','a','QC01');
insert into user_master (USERID, USERNAME, PASSWORD, AUTHORITY) values ('qc02','QC02','a','QC02');

delete from WORK_MASTER;
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('QC','QC01','001','１） A "Received Label" issued by QA is attached to the received product, and it is transported to the receiving test site.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('QC','QC02','001','１） Enter the Lot # and expiration date, and perform the acceptance test according to the "(SOP-M-MSC-001Appx1) Acceptance Form".','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('QC','QC03','001','１） Print out the "User lot #" that will be issued after QA approval and attach it to the product.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('QC','QC04','001','１）Store incoming products in accordance with the product handling instructions, either on racks in a storage room (20°C-28°C), in a refrigerated showcase for medicines (4°C), in a medical freezer (-30°C), or in a deep freezer (-80°C), and indicate the storage location.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('QA','QA01','001','','QA01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('IS','IS01','001','','QA01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('IS','IS02','001','','QA01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP101','001','１） Print out the kit label and attach it to the kit product basket.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP101','002','２） Place the items listed in the table below in the kit basket and scan the RFID.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP101','003','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP102','001','１） Print out the kit label and attach it to the kit product basket.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP102','002','２） Place the items listed in the table below in the kit basket and scan the RFID.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP102','003','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP103','001','１） Print out the kit label and attach it to the kit product basket.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP103','002','２） Place the items listed in the table below in the kit basket and scan the RFID.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP103','003','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP104','001','','CP02,CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP1','EP105','001','','CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','001','１） Preheat the dry bath to 37°C.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','002','２） Heat 5 mL of medium to 37°C.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','003','３） Heat the vial of frozen cells in a dry bath and collect the thawed solution in a 15-mL centrifuge tube.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','004','４) Add 1 ml of medium to a 15 ml tube and mix gently.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','005','５） Centrifugation 1500 rpm for 3 min at room temperature.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','006','６） Remove the supernatant and suspend the cells in 500-1000 µL of the medium.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','007','７） Add an equal volume of trypan blue to 10 µL of cell suspension and mix.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','008','８） Count cell number of 10µL.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','009','９） Adjust the cell density to 1.5x104 cells/mL and seed 39 mL into a T175 flask.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','010','１０）Incubate for　4 days at 37℃ under 2% CO2 condition.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','011','１１）After incubation, remove the supernatant and rise the precipitation with 19mL of PBS.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','012','１２） Remove PBS and add 5.8 mL of TrypLE Select.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','013','１３）Incubate for 3min at 37℃.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','014','１４） Add 19 mL of a medium and pipette once or twice.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','015','１５） Collect the cell suspension in a centrifuge tube and add 38 mL of culture medium.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','016','１６）Centrifuge with 1500rpm for 3min at room temperature','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','017','１７）Remove the supernatant and recover the precipitant with 19mL of medium.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP201','018','１８） After counting the cells, adjust the cell density 1.5x104 cells/mL and fill 140 mL into a bag.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP202','001','','CP02,CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP2','EP203','001','','CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET1','ET101','001','１） Confirm that there are no significant abnormalities in the shape of the cells or colonies by microscopy.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET1','ET102','001','１）Count the cell number using a one-cell counter. ２） Compare with the number of cells at the time of seeding, determine the doubling time through culture, and confirm that it is within 27 hours. 。','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET1','ET103','001','','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET1','ET104','001','','QA01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP301','001','１） Print out the kit label and attach it to the kit product basket.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP301','002','２） Place the items listed in the table below in the kit basket and scan the RFID.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP301','003','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP302','001','１） Print out the kit label and attach it to the kit product basket.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP302','002','２） Place the items listed in the table below in the kit basket and scan the RFID.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP302','003','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP303','001','１） Print out the kit label and attach it to the kit product basket.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP303','002','２） Place the items listed in the table below in the kit basket and scan the RFID.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP303','003','３）After completing the transfer of all materials to the kit basket, print a label with the expiration date of the kit item. Finish by affixing the label with the expiration date alongside the kit label.','KO01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP304','001','','CP02,CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP3','EP305','001','','CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP401','001','１） Select a culture recipe on the CellQualia control terminal.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP401','002','２） Scan the kit labels [Room Temperature] to verify that they are the intended material.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP401','003','３） Install the consumables according to the display indication of CellQualia. ','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP401','004','４） Follow the instructions to fill the bag with the chemical and connect it to CellQualia. 。','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP402','001','１） Select a culture recipe on the CellQualia control terminal.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP402','002','２） Scan the kit labels [Room Temperature] to verify that they are the intended material.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP402','003','３） Install the consumables according to the display indication of CellQualia. ','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP402','004','４） Follow the instructions to fill the bag with the chemical and connect it to CellQualia. 。','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP403','001','１） Select a culture recipe on the CellQualia control terminal.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP403','002','２） Scan the kit labels [Room Temperature] to verify that they are the intended material.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP403','003','３） Install the consumables according to the display indication of CellQualia. ','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP403','004','４） Follow the instructions to fill the bag with the chemical and connect it to CellQualia. 。','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP404','001','１） After confirming that the QC test has been passed in the preculture, adjust the concentration of the cell suspension and fill the stirring bag. Immediately attach the stirring bag to the device. 。','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP404','002','２）Start run.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP404','003','３） After the completion of the culture, the harvest bag is promptly removed and moved to the next step.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP405','001','４） Review the Post-batch overview (SOP-M-MSC-006Appx.1) and confirm that there are no deviations.　　　Remove and dispose of used chemical bags and channels according to the procedure.','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP406','001','','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP407','001','','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP408','001','','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP409','001','','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP410','001','','CP02,CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP4','EP411','001','','CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET2','ET201','001','１） Quantify the concentration of cysteine in the supernatant of the culture medium using LC-MS. Confirm that its concentration is below the specified value throughout the incubation.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET2','ET202','001','','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET2','ET203','001','','QA01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP5','EP501','001','','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP5','EP502','001','','CP02,CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP5','EP503','001','','CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET3','ET301','001','１） Confirm that there are no significant abnormalities in the shape of the cells or colonies by microscopy.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET3','ET302','001','１）Count the cell number using a one-cell counter. ２） Compare with the number of cells at the time of seeding, determine the doubling time through culture, and confirm that it is within 27 hours. 。','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET3','ET303','001','１） Cell length is measured by image analysis, and at least 90% of the population should be within ±20% of the maximum frequency value.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET3','ET304','001','１） Confirm that the positivity of CD73, CD90, and CD105 is greater than 70%, using FACS.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET3','ET305','001','１） Confirm that less than 30% of cells have mitochondrial size greater than the specified value, using FACS.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET3','ET306','001','','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET3','ET307','001','','QA01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP6','EP601','001','','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP6','EP602','001','','CP02,CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP6','EP603','001','','CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET4','ET401','001','１） Culture the cells after freezing and confirm that the viability is 80% or higher.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET4','ET402','001','１） After the addition of Ionomycin/PMA, quantify IL-10 and INF-γ in the supernatant of the medium by ELISA, and confirm that they are in the specified amounts.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET4','ET403','001','１） Confirm that no cloudiness is observed by naked eye observation, after 14 days of incubation using the membrane filter method.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET4','ET404','001','１） Quantify endotoxin by the kinetic colorimetric method and confirm that it is below the specified level.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET4','ET405','001','１） Confirm that no band of the target amplified product is detected in the electrophoresis image after the Nested-PCR method.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET4','ET406','001','１） Quantify the copy number of the nucleotide sequence in the target region by real-time PCR. Confirm that the copy number is below the detection limit.','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET4','ET407','001','','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET4','ET408','001','','QA01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('BR','BR01','001','','QA01');

delete from PROCESS_MASTER;
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
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('QC','QC03','Registered','01','QA01','Q05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('QC','QC04','Storage','04','QC03','Q06');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('QA','QA01','Approve','05','QC02','Q04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('IS','IS01','指図作成','－','','I01');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('IS','IS02','指図リリース','－','IS01','I02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP1','EP101','1. Kitting for Preculture (Room Temperature)','06','IS02','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP1','EP102','2. Kitting for Preculture (4℃)','06','EP101','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP1','EP103','3. Kitting for Preculture (－20℃)','06','EP102','P03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP1','EP104','Confirm','101','EP103','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP1','EP105','Approve','102','EP104','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP2','EP201','1. Preculture','07','EP105','P03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP2','EP202','Confirm','101','EP201','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP2','EP203','Approve','102','EP202','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET1','ET101','1. Microscopy','14','EP203','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET1','ET102','2. Growth','15','ET101','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET1','ET103','Confirm','101','ET102','T03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET1','ET104','Approve','102','ET103','T04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP3','EP301','1. Kitting for Expansion (Room Temperature)','06','ET104','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP3','EP302','2. Kitting for Expansion (4℃)','06','EP301','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP3','EP303','3. Kitting for Expansion (－20℃)','06','EP302','P03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP3','EP304','Confirm','101','EP303','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP3','EP305','Approve','102','EP304','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP401','1. Preparation (Room Temperature)','08','EP305','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP402','1. Preparation (4℃)','08','EP401','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP403','1. Preparation (－20℃)','08','EP402','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP404','2. Culture','09','EP403','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP405','3. Clearance','01','EP404','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP406','Batch progress','10','EP405','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP407','Camera vision','11','EP406','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP408','Post-Batch Overview','12','EP407','P02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP409','Pre-Batch Overview','13','EP408','P03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP410','Confirm','16','EP409','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP4','EP411','Approve','16','EP410','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET2','ET201','1. Medium analysis','14','EP411','T03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET2','ET202','Confirm','101','ET201','T04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET2','ET203','Approve','102','ET202','T05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP5','EP501','Buffer exchange','','EP409','P03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP5','EP502','Confirm','16','EP501','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP5','EP503','Approve','16','EP502','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET301','1. Microscopy','14','EP503','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET302','2. Growth','15','ET301','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET303','3. Distribution of cell shapes','14','ET302','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET304','4. Antigen Analysis','17','ET303','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET305','5. Size of mitochondria','18','ET304','T03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET306','Confirm','101','ET305','T04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET3','ET307','Approve','102','ET306','T05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP6','EP601','Freezing','','EP503','P03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP6','EP602','Confirm','101','EP601','P04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('EP6','EP603','Approve','102','EP602','P05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET401','1. Cell viability after freezing and thawing','15','EP603','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET402','2. Cytokine secretion','15','ET401','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET403','3. Sterility test','18','ET402','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET404','4. Endotoxin test','15','ET403','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET405','5. Mycoplasma test','18','ET404','T02');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET406','6. Virus test','15','ET405','T03');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET407','Confirm','101','ET406','T04');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('ET4','ET408','Approve','102','ET407','T05');
insert into WORK_GROUP_MASTER (PROCESS_ID,WORK_GROUP,WORK_GROUP_NAME,DISPLAY_TYPE,BEFORE_WORK_GROUP,STATUS) values ('BR','BR01','Batch Record Review','19','ET408','B03');


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

