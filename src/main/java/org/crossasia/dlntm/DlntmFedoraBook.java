package org.crossasia.dlntm;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

import static org.crossasia.dlntm.Latitude.addLatitude;
import static org.crossasia.dlntm.fedora.Alternative.addAlternatives;
import static org.crossasia.dlntm.fedora.Category.addCategories;
import static org.crossasia.dlntm.fedora.CeYear.addCeYear;
import static org.crossasia.dlntm.fedora.Code.addCodes;
import static org.crossasia.dlntm.fedora.CodeNumber.addCodeNumber;
import static org.crossasia.dlntm.fedora.Complete.addComplete;
import static org.crossasia.dlntm.fedora.Condition.addCondition;
import static org.crossasia.dlntm.fedora.DateOriginal.addDateOriginal;
import static org.crossasia.dlntm.fedora.Description.addDescriptions;
import static org.crossasia.dlntm.fedora.DirectlyDigitised.addDirectlyDigitised;
import static org.crossasia.dlntm.fedora.Exact.addExact;
import static org.crossasia.dlntm.fedora.Extent.addExtent;
import static org.crossasia.dlntm.fedora.FedoraFooterBook.addFedoraFooter;
import static org.crossasia.dlntm.fedora.FedoraHeader.addFedoraHeader;
import static org.crossasia.dlntm.fedora.FullLocationName.addFullLocationName;
import static org.crossasia.dlntm.fedora.FullLocationNameLao.addFullLocationNameLao;
import static org.crossasia.dlntm.fedora.HasColophon.addHasColophon;
import static org.crossasia.dlntm.fedora.Illustration.addIllustration;
import static org.crossasia.dlntm.fedora.InCollection.addCollection;
import static org.crossasia.dlntm.fedora.Index.addIndexes;
import static org.crossasia.dlntm.fedora.Keywords.addKeywords;
import static org.crossasia.dlntm.fedora.Language.addLanguages;
import static org.crossasia.dlntm.fedora.Legibility.addLegibility;
import static org.crossasia.dlntm.fedora.LocationsId.addLocationsId;
import static org.crossasia.dlntm.fedora.Longitude.addLongitude;
import static org.crossasia.dlntm.fedora.ManuscriptsCount.addManuscriptsCount;
import static org.crossasia.dlntm.fedora.Material.addMaterials;
import static org.crossasia.dlntm.fedora.NumberOfDigitalImages.addNumberOfDigitalImages;
import static org.crossasia.dlntm.fedora.NumberOfFascicles.addNumberOfFascicles;
import static org.crossasia.dlntm.fedora.NumberOfFolios.addNumberOfFolios;
import static org.crossasia.dlntm.fedora.Place.addPlaces;
import static org.crossasia.dlntm.fedora.Roll.addRoll;
import static org.crossasia.dlntm.fedora.Script.addScripts;
import static org.crossasia.dlntm.fedora.Title.addTitles;
import static org.crossasia.dlntm.fedora.Website.addWebsite;
import static org.crossasia.dlntm.fedora.Year.addYear;
import static org.crossasia.dlntm.fedora.constants.Constants.ABSOLUTE_PATH_BOOKS;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class DlntmFedoraBook {
    public static JSONObject jsonObj;
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException , IOException {
        File dir = new File(String.valueOf(ABSOLUTE_PATH_BOOKS));
        File[] filesInDir = dir.listFiles();
            for (File file : filesInDir) {
                StringBuilder sb = new StringBuilder();
                jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

                String id = "";

                if (jsonObj.has("id")) {
                    id = (String) jsonObj.get("id").toString();
                }

                sb.append(addFedoraHeader());

                sb.append(QUOTE + "id" + QUOTE + ":" +QUOTE+ "dlntm_0000"+ id  + QUOTE+"," + '\n');

                System.out.println(id);
                sb.append(addCodeNumber());
                sb.append(addRoll());
                sb.append(addCeYear());
                sb.append(addYear());

                sb.append(addNumberOfFascicles());
                sb.append(addNumberOfFolios());
                sb.append(addNumberOfDigitalImages());
                sb.append(addExtent());
                sb.append(addHasColophon());
                sb.append(addTitles());
                sb.append(addExact());

                sb.append(addDescriptions());
                sb.append(addDirectlyDigitised());
                sb.append(addWebsite());
                sb.append(addLocationsId());
                sb.append(addIllustration());
                sb.append(addLegibility());

                sb.append(addComplete());
                sb.append(addMaterials());
                sb.append(addFullLocationName());
                sb.append(addFullLocationNameLao());
                sb.append(addPlaces());
                sb.append(addIndexes());

                sb.append(addLatitude());
                sb.append(addLongitude());
                sb.append(addCondition());
                sb.append(addAlternatives());
                sb.append(addCodes());
                sb.append(addDateOriginal());

                sb.append(addManuscriptsCount());
                sb.append(addCategories());
                sb.append(addLanguages());
                sb.append(addKeywords());
                sb.append(addCollection());
                sb.append(addScripts());
                sb.append(addFedoraFooter());

                sb.deleteCharAt(sb.length() - 1);
                PrintStream out = new PrintStream(new FileOutputStream("/data/dlmnt/fedora/books/"+id+".json"));
                out.println(""+sb.toString()+"}");
            }
        }
    }

