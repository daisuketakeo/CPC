
delete from ACCEPT_TABLE;
insert into ACCEPT_TABLE (MATERIAL_NO, MATERIAL_NAME, CATEGORY_NO, MANUFACTURER, QTY, STATUS) values (
'001',
'Cellartis® MSC Xeno-Free Basal Medium, 475 ml',
'Y50201',
'Takara Bio Inc.',
'30',
'Q01'
);

insert into ACCEPT_TABLE (MATERIAL_NO, MATERIAL_NAME, CATEGORY_NO, MANUFACTURER, QTY, STATUS) values (
'002',
'Cellartis® MSC Xeno-Free Supplement',
'Y50202',
'Takara Bio Inc.',
'20',
'Q01'
);

insert into ACCEPT_TABLE (MATERIAL_NO, MATERIAL_NAME, CATEGORY_NO, MANUFACTURER, QTY, STATUS) values (
'016',
'DPBS, no calcium, no magnesium, 500 ml',
'14190250',
'Thermo Fisher Scientific',
'10',
'Q01'
);

insert into ACCEPT_TABLE (MATERIAL_NO, MATERIAL_NAME, CATEGORY_NO, MANUFACTURER, QTY, STATUS) values (
'017',
'TrypLE Select Enzyme (1X), no phenol red, 500m ml ',
'12563029',
'Thermo Fisher Scientific',
'10',
'Q01'
);

insert into ACCEPT_TABLE (MATERIAL_NO, MATERIAL_NAME, CATEGORY_NO, MANUFACTURER, QTY, STATUS) values (
'018',
'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX',
'123456789',
'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX',
'999',
'Q01'
);

delete from INSTRUCTIONS_TABLE;
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B001','protocol001','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B002','protocol002','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B003','protocol003','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B004','protocol004','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B005','protocol005','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B006','protocol006','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B007','protocol006','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B008','protocol006','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B009','protocol006','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B010','protocol006','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B011','protocol006','2022/01/28','2022/01/29','Q06');
insert into INSTRUCTIONS_TABLE (BATCH_ID,PROTOCOL,STARTING_TIME,FINISH_TIME,STATUS) values ('B012','protocol006','2022/01/28','2022/01/29','Q06');

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
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET1','ET101','001','１） Confirm that there are no significant abnormalities in the shape of the cells or colonies by microscopy.','QC01,QC02','ET101-1.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET1','ET102','001','１）Count the cell number using a one-cell counter. ２） Compare with the number of cells at the time of seeding, determine the doubling time through culture, and confirm that it is within 27 hours. 。','QC01,QC02',NULL,NULL,NULL,NULL,NULL,'ET102-1.csv',NULL,NULL,NULL,NULL);
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
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET2','ET201','001','１） Quantify the concentration of cysteine in the supernatant of the culture medium using LC-MS. Confirm that its concentration is below the specified value throughout the incubation.','QC01,QC02','ET201-1.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET2','ET202','001','','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET2','ET203','001','','QA01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP5','EP501','001','','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP5','EP502','001','','CP02,CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP5','EP503','001','','CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET3','ET301','001','１） Confirm that there are no significant abnormalities in the shape of the cells or colonies by microscopy.','QC01,QC02','ET301-1.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET3','ET302','001','１）Count the cell number using a one-cell counter. ２） Compare with the number of cells at the time of seeding, determine the doubling time through culture, and confirm that it is within 27 hours. 。','QC01,QC02',NULL,NULL,NULL,NULL,NULL,'ET302-1.csv',NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET3','ET303','001','１） Cell length is measured by image analysis, and at least 90% of the population should be within ±20% of the maximum frequency value.','QC01,QC02','ET303-1.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET3','ET304','001','１） Confirm that the positivity of CD73, CD90, and CD105 is greater than 70%, using FACS.','QC01,QC02','ET304-1.png','ET304-2.png','ET304-3.png',NULL,NULL,'ET304-1.csv','ET304-2.csv','ET304-3.csv',NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET3','ET305','001','１） Confirm that less than 30% of cells have mitochondrial size greater than the specified value, using FACS.','QC01,QC02','ET305-1.png',NULL,NULL,NULL,NULL,'ET305-1.csv',NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET3','ET306','001','','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET3','ET307','001','','QA01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP6','EP601','001','','CP01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP6','EP602','001','','CP02,CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('EP6','EP603','001','','CP03');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET4','ET401','001','１） Culture the cells after freezing and confirm that the viability is 80% or higher.','QC01,QC02',NULL,NULL,NULL,NULL,NULL,'ET401-1.csv',NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET4','ET402','001','１） After the addition of Ionomycin/PMA, quantify IL-10 and INF-γ in the supernatant of the medium by ELISA, and confirm that they are in the specified amounts.','QC01,QC02',NULL,NULL,NULL,NULL,NULL,'ET402-1.csv',NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET4','ET403','001','１） Confirm that no cloudiness is observed by naked eye observation, after 14 days of incubation using the membrane filter method.','QC01,QC02','ET403-1.png',NULL,NULL,NULL,NULL,'ET403-1.csv',NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET4','ET404','001','１） Quantify endotoxin by the kinetic colorimetric method and confirm that it is below the specified level.','QC01,QC02',NULL,NULL,NULL,NULL,NULL,'ET404-1.csv',NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET4','ET405','001','１） Confirm that no band of the target amplified product is detected in the electrophoresis image after the Nested-PCR method.','QC01,QC02','ET405-1.png',NULL,NULL,NULL,NULL,'ET405-1.csv',NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY,CAPTURE1,CAPTURE2,CAPTURE3,CAPTURE4,CAPTURE5,CSV1,CSV2,CSV3,CSV4,CSV5) values ('ET4','ET406','001','１） Quantify the copy number of the nucleotide sequence in the target region by real-time PCR. Confirm that the copy number is below the detection limit.','QC01,QC02',NULL,NULL,NULL,NULL,NULL,'ET406-1.csv',NULL,NULL,NULL,NULL);
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET4','ET407','001','','QC01,QC02');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('ET4','ET408','001','','QA01');
insert into WORK_MASTER (PROCESS_ID, WORK_GROUP, WORK_ID, WORK,AUTHORITY) values ('BR','BR01','001','','QA01');

