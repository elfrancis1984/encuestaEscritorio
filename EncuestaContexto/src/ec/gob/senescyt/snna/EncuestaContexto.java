/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senescyt.snna;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Text;

/**
 *
 * @author jchalan
 */
public class EncuestaContexto extends javax.swing.JFrame {
  
    private HashMap<String,Component> componentesSeccionUno = new HashMap<>();
    private HashMap<String,Component> componentesSeccionDos = new HashMap<>();
    private HashMap<String,Component> componentesSeccionTres = new HashMap<>();
    private HashMap<String,Component> componentesSeccionCuatro = new HashMap<>();
    private HashMap<String,Component> componentesSeccionCinco = new HashMap<>();
    private HashMap<String,Component> componentesSeccionSeis = new HashMap<>();
    private HashMap<String,Component> allComponents = new HashMap<>();
    private String ruta = "";
    private String fileConfig = "config";
    private Integer index = 0;
    private static String[] paises = {"Canadá","Colombia","Costa rica","Cuba","Chile","Ecuador","Estados unidos","Guatemala","Haití","Honduras","Jamaica","Malvinas islas","México","Nicaragua","Panamá","Paraguay","Perú","Puerto rico","Dominicana, república","El salvador","Trinidad y tobago","Uruguay","Venezuela","Curazao, isla","Bahamas","Barbados","Granada","Guyana","Surinam","Antigua y barbuda","Belice","Dominica","San cristóbal y nevis","Santa lucía","San vicente y las granadinas","Antillas holandesas","Aruba","Bermudas","Guadalupe","Guayana francesa","Caimán, islas","Vírgenes (británicas), islas","Johnston, islas","Martinica","Montserrat isla","Anguila","Turcas y caicos, islas","Vírgenes (de los estados unidos), islas","Marianas del norte, islas","Pacífico, islas administradas por usa","Pacífico, islas del","Samoa americana","Otras naciones de américa","Albania","Alemania","Austria","Bélgica","Bulgaria","Checa, república (checoslovaquia)","Alboran y perejil","Dinamarca","España","Francia","Finlandia","Reino unido (escocia,gran bretaña,inglaterra, gales)","Grecia","Países bajos (holanda)","Hungría","Irlanda","Islandia","Italia","Luxemburgo","Malta","Noruega","Polonia","Portugal","Rumania","Suecia","Suiza","Ucrania","Rusia, federación de (unión soviética)","Yugoslavia (servia de montenegro)","Andorra","Liechtestein","Mónaco","San marino","Vaticano (santa sede), estado de la ciudad del","Gibraltar","Belarusia","Bosnia y herzegovina","Croacia","Eslovenia","Estonia","Groenlandia","Letonia (latvia)","Lituania","Moldavia, república de (moldova)","Macedonia, república de","Eslovaquia","Feroe, islas","Canal, islas (normandas)","Alemania, república democrática","San pedro y miguelón","Bonaire, isla","Territorio británico del oceáno índico","Otras naciones de europa","Armenia","Georgia","Afganistán","Arabia saudita","Myanmar (burma), birmania.","Camboya (cambodia), kampuchea","Corea, república democrática (rpd)","Taiwan, provincia de china (nacionalista)","Filipinas","India","Indonesia","Irak","Irán, república islámica de","Israel","Japón","Jordania","Kuwait","Laos, república democrática (rpd)","Líbano","Malasia","Mongolia","Pakistán","Siria, república arabe","Tailandia","Bahrein","Bangladesh","Bután","Corea del sur, república de","China república popular (pekin)","Chipre","Emiratos árabes unidos","Qatar","Maldivas","Nepal","Omán","Singapur","Sri lanka (ceilan)","Swazilandia","Viet nam del sur","Yemen","Yemen democrático","Brunei darussalam","Turquía","Azerbaijan","Kazajstán","Kirguistán","Tadjikistán","Turkmenistán","Uzbekistán","Zona neutral (palestina)","Hong kong","Macao","Malasia, península de","Otras naciones de asia","Burkina faso (alto volta)","Argelia","Burundi","Camerún","Congo","Etiopía","Gambia","Guinea","Liberia","Libia","Madagascar","Malawi","Mali","Marruecos","Mauritania","Nigeria","Zimbabwe (rhodesia)","Senegal","Sudan","Sudafrica (ciskei)","Sierra leona","Tanzania, (república unida de)","Uganda","Zambia","Benin","Botswana","Centroafricana, república (r.c.a)","Costa de marfil (cote d. Ivoire)","Chad","Egipto","Gabón","Ghana","Guinea -bissau","Guinea ecuatorial","Kenia","Lesotho","Mauricio","Mozambique","Mayotte","Niger","Rwanda","Seychelles","Sahara occidental","Somalia","Santo tome y principe","Togo","Tunez","Zaire ( república democrática del congo)","Angola","Cabo verde","Comoras","Dyibuti","Namibia","Eritrea","Morocco","Reunión","Santa elena","Otras naciones de äfrica","Australia","Nueva zelandia","Samoa occidental","Fiji","Papua nueva guinea","Tonga","Palau (belau) islas","Kiribati","Marshall, islas","Micronesia, estados federados de","Nauru","Salomón islas","Tuvalu","Vanuato","Guam","Cocos (keeling), islas","Cook, islas","Navidad (christmas), isla","Midway, islas","Niue, isla","Norfolk, isla","Nueva caledonia","Pitcairn, isla","Polinesia francesa","Timor del este","Tokelau","Wake, islas","Wallis y fotuna, islas","Cantón y enderbury, islas","Otras naciones de oceanía","Sin especificar"};
    private static String[] codigoPaises = {"1836","1837","1838","1839","1840","1841","1842","1843","1844","1845","1846","1847","1848","1849","1850","1851","1852","1853","1854","1855","1856","1857","1858","1859","1860","1861","1862","1863","1864","1865","1866","1867","1868","1869","1870","1871","1872","1873","1874","1875","1876","1877","1878","1879","1880","1881","1882","1883","1884","1885","1886","1887","1888","1889","1890","1891","1892","1893","1894","1895","1896","1897","1898","1899","1900","1901","1902","1903","1904","1905","1906","1907","1908","1909","1910","1911","1912","1913","1914","1915","1916","1917","1918","1919","1920","1921","1922","1923","1924","1925","1926","1927","1928","1929","1930","1931","1932","1933","1934","1935","1936","1937","1938","1939","1940","1941","1942","1943","1944","1945","1946","1947","1948","1949","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040","2041","2042","2043","2044","2045","2046","2047","2048","2049","2050","2051","2052","2053","2054","2055","2056","2057","2058","2059","2060","2061","2062","2063","2064","2065","2066","2067","2068","2069","2070","2071","2072","2073","2074","2075","2076","2077","2078","2079","2080","2081","2082","2083","2084"};
    
    private static String[] lenguaExtranjeraPadre = {"Achuar","Afrikáans","Aguaruna","Aimara","Albanés","Alemán","Amarakaeri","Amárico","Amuesha","Árabe","Araona","Armenio","Asháninca","Aymara","Azerí","Baure","Bengalí","Bésiro","Bielorruso","Birmano","Bislama","Bora","Bosnio","Búlgaro","Candoshi","Canichana","Capanahua","Caquinte","Cashibo-cacataibo","Cashinahua","Catalán","Cauqui","Cavineño","Cayubaba","Chácobo","Chayahuita","Checo","Chicheua","Chimán","Cingalés","Cocama","Comorense","Coreano","Criollo haitiano","Criollo seychellense","Croata","Culina","Danés","Dzongka","Ese ejja","Eslovaco","Esloveno","Estonio","Filipino","Finés","fiyiano","Francés","Georgiano","Griego","Guaraní","Guarasu’we","Guarayu","Hebreo","Hindi","Hiri motu","Huambisa","Huitoto","Húngaro","Indonesio","Indostano fiyiano","Inglés","Irlandés","Islandés","Italiano","Itonama","Jaqaru","Jébero","Jemer","Kazajo","Kirguís","Kiribatiano","Lao","Latín","Leco","Lengua de signos española","lengua de signos neozelandesa","Letón","Lituano","Luxemburgués","Macedonio","Machajuyai-kallawaya","Machiguenga","Machineri","Malayo","Maldivo","malgache","Maltés","Mandarín","Maorí","Maropa","Marshalés","Matsés","Mojeño-ignaciano","Mojeño-trinitario","Moldavo","Mongol","Moré","Mosetén","Movima","Nauruano","Ndebele meridional","Neerlandés","Nepalí","Noruego","Omagua","Pacawara","palaosiano","Pastún","Persa","Polaco","Portugués","Puquina","Quechua","romanche","ruanda","Rumano","Rundi","Ruso","Serbio","Shipibo-conibo","Sirionó","Somalí","Soto meridional","Soto septentrional","Suahili","Suazi","Sueco","Tacana","Tai","Tamil","Tapiete","Tayiko","Tetum","Ticuna","Tigriña","Tok pisin","Tongano","Toromona","Tsonga","Tsuana","Turco","Turcomano","Tuvaluano","Ucraniano","Urarina","urdu","Uru-chipaya","Uzbeko","Venda","Vietnamita","weenhayek","Xosa","Yagua","yaminawa","Yine","Yuki","Yuracaré","Zamuco","Zulú"};
    private static String[] codigoLenguaExtranjeraPadre = {"2492","2493","2494","2495","2496","2497","2498","2499","2500","2501","2502","2503","2504","2505","2506","2507","2508","2509","2510","2511","2512","2513","2514","2515","2516","2517","2518","2519","2520","2521","2522","2523","2524","2525","2526","2527","2528","2529","2530","2531","2532","2533","2534","2535","2536","2537","2538","2539","2540","2541","2542","2543","2544","2545","2546","2547","2548","2549","2550","2551","2552","2553","2554","2555","2556","2557","2558","2559","2560","2561","2562","2563","2564","2565","2566","2567","2568","2569","2570","2571","2572","2573","2574","2575","2576","2577","2578","2579","2580","2581","2582","2583","2584","2585","2586","2587","2588","2589","2590","2591","2592","2593","2594","2595","2596","2597","2598","2599","2600","2601","2602","2603","2604","2605","2606","2607","2608","2609","2610","2611","2612","2613","2614","2615","2616","2617","2618","2619","2620","2621","2622","2623","2624","2625","2626","2627","2628","2629","2630","2631","2632","2633","2634","2635","2636","2637","2638","2639","2640","2641","2642","2643","2644","2645","2646","2647","2648","2649","2650","2651","2652","2653","2654","2655","2656","2657","2658","2659","2660"};
    
    private static String[] lenguaExtrajeraMadre = {"Achuar","Afrikáans","Aguaruna","Aimara","Albanés","Alemán","Amarakaeri","Amárico","Amuesha","Árabe","Araona","Armenio","Asháninca","Aymara","Azerí","Baure","Bengalí","Bésiro","Bielorruso","Birmano","Bislama","Bora","Bosnio","Búlgaro","Candoshi","Canichana","Capanahua","Caquinte","Cashibo-cacataibo","Cashinahua","Catalán","Cauqui","Cavineño","Cayubaba","Chácobo","Chayahuita","Checo","Chicheua","Chimán","Cingalés","Cocama","Comorense","Coreano","Criollo haitiano","Criollo seychellense","Croata","Culina","Danés","Dzongka","Ese ejja","Eslovaco","Esloveno","Estonio","Filipino","Finés","fiyiano","Francés","Georgiano","Griego","Guaraní","Guarasu’we","Guarayu","Hebreo","Hindi","Hiri motu","Huambisa","Huitoto","Húngaro","Indonesio","Indostano fiyiano","Inglés","Irlandés","Islandés","Italiano","Itonama","Jaqaru","Jébero","Jemer","Kazajo","Kirguís","Kiribatiano","Lao","Latín","Leco","Lengua de signos española","lengua de signos neozelandesa","Letón","Lituano","Luxemburgués","Macedonio","Machajuyai-kallawaya","Machiguenga","Machineri","Malayo","Maldivo","malgache","Maltés","Mandarín","Maorí","Maropa","Marshalés","Matsés","Mojeño-ignaciano","Mojeño-trinitario","Moldavo","Mongol","Moré","Mosetén","Movima","Nauruano","Ndebele meridional","Neerlandés","Nepalí","Noruego","Omagua","Pacawara","palaosiano","Pastún","Persa","Polaco","Portugués","Puquina","Quechua","romanche","ruanda","Rumano","Rundi","Ruso","Serbio","Shipibo-conibo","Sirionó","Somalí","Soto meridional","Soto septentrional","Suahili","Suazi","Sueco","Tacana","Tai","Tamil","Tapiete","Tayiko","Tetum","Ticuna","Tigriña","Tok pisin","Tongano","Toromona","Tsonga","Tsuana","Turco","Turcomano","Tuvaluano","Ucraniano","Urarina","urdu","Uru-chipaya","Uzbeko","Venda","Vietnamita","weenhayek","Xosa","Yagua","yaminawa","Yine","Yuki","Yuracaré","Zamuco","Zulú"};
    private static String[] codigoLenguaExtrajeraMadre = {"2661","2662","2663","2664","2665","2666","2667","2668","2669","2670","2671","2672","2673","2674","2675","2676","2677","2678","2679","2680","2681","2682","2683","2684","2685","2686","2687","2688","2689","2690","2691","2692","2693","2694","2695","2696","2697","2698","2699","2700","2701","2702","2703","2704","2705","2706","2707","2708","2709","2710","2711","2712","2713","2714","2715","2716","2717","2718","2719","2720","2721","2722","2723","2724","2725","2726","2727","2728","2729","2730","2731","2732","2733","2734","2735","2736","2737","2738","2739","2740","2741","2742","2743","2744","2745","2746","2747","2748","2749","2750","2751","2752","2753","2754","2755","2756","2757","2758","2759","2760","2761","2762","2763","2764","2765","2766","2767","2768","2769","2770","2771","2772","2773","2774","2775","2776","2777","2778","2779","2780","2781","2782","2783","2784","2785","2786","2787","2788","2789","2790","2791","2792","2793","2794","2795","2796","2797","2798","2799","2800","2801","2802","2803","2804","2805","2806","2807","2808","2809","2810","2811","2812","2813","2814","2815","2816","2817","2818","2819","2820","2821","2822","2823","2824","2825","2826","2827","2828","2829"};
    
    private static String[] lenguaIndigenaPadre = {"Cha`palaa","A`ingae","Zia pedee","Paicoca","Shiwiar chicham","Tsa`fiqui","Achuar chicham","Awapít","Shuar chicham","Waotededo","Kichwa amazónico","Kichwa región interandina"};
    private static String[] codigoLenguaIndigenaPadre = {"2468","2469","2470","2471","2472","2473","2474","2475","2476","2477","2478","2479"};
    
    private static String[] lenguaIndigenaMadre = {"Cha`palaa","A`ingae","Zia pedee","Paicoca","Shiwiar chicham","Tsa`fiqui","Achuar chicham","Awapít","Shuar chicham","Waotededo","Kichwa amazónico","Kichwa región interandina"};
    private static String[] codigoLenguaIndigenaMadre = {"2480","2481","2482","2483","2484","2485","2486","2487","2488","2489","2490","2491"};
    
    private boolean encuestaTerminada;
    private String archivoGenerado = "";
    /**
     * Creates new form Encuesta
     */
    public EncuestaContexto() {
        initComponents();
        this.setLocationRelativeTo(null);
        /*--------Bloquea el ctrl + v ---------------------------*/
        bloquearPegar(); //No es eficiente Optimizar
        /* -------- Inicializa Secciones ---------- */
        initSeccionUno();
        initSeccionDos();
        intiSeccionTres();
        initSeccionCuatro();
        initSeccionCinco();
        initSeccionSeis();
        /*--------Lee todos los componentes de todas las secciones-------------------------*/
        componentesSeccionUno = obtenerComponentesPorPanel(jPanelSec_1);
        componentesSeccionDos = obtenerComponentesPorPanel(jPanelSec_2);
        componentesSeccionTres = obtenerComponentesPorPanel(jPanelSec_3);
        componentesSeccionCuatro = obtenerComponentesPorPanel(jPanelSec_4);
        componentesSeccionCinco = obtenerComponentesPorPanel(jPanelSec_5);
        componentesSeccionSeis = obtenerComponentesPorPanel(jPanelSec_6);
        /*---------Uno todos los componentes de todas las secciones------------------------*/
        allComponents.putAll(componentesSeccionUno);
        allComponents.putAll(componentesSeccionDos);
        allComponents.putAll(componentesSeccionTres);
        allComponents.putAll(componentesSeccionCuatro);
        allComponents.putAll(componentesSeccionCinco);
        allComponents.putAll(componentesSeccionSeis);
        /*-----Carga respuestas almacenadas----------*/
        cargarXml();
        if(archivoGenerado.equalsIgnoreCase("1")){
            int dialogResult = JOptionPane.showConfirmDialog (null, "¿Deseas llenar la encuesta nuevamente?","aaaa",JOptionPane.YES_NO_OPTION);
            //0 Si  1 No  2 Cancel
            if(dialogResult == 0){
                vaciarXML();
            }
        }
    }
    /**
     * 
     */
    private void vaciarXML(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            org.w3c.dom.Document document = implementation.createDocument(null, fileConfig, null);
            document.setXmlVersion("1.0");
            //Main Node
            org.w3c.dom.Element raiz = document.getDocumentElement();
            org.w3c.dom.Element itemNode = document.createElement("LISTA_RESPUESTAS");
            /*----------Para registrar la seccion actual----------------------------------*/
            org.w3c.dom.Element itemNode1 = document.createElement("SECCIONES");
            org.w3c.dom.Element keyNode1 = document.createElement("SECCION_ACTUAL");
            keyNode1.setAttribute("INDEX", index.toString());
            itemNode1.appendChild(keyNode1);
            raiz.appendChild(itemNode1);
            /*-----------------------------------------------------------------------------*/
            /*------------------Para registrar el usuario----------------------------------*/
            org.w3c.dom.Element itemNode2 = document.createElement("LOGIN");
            org.w3c.dom.Element keyNode2 = document.createElement("USUARIO");
            keyNode2.setAttribute("ID", txt_cedula.getText());
            keyNode2.setAttribute("NOMBRES", txt_nombres.getText());
            keyNode2.setAttribute("APELLIDOS", txt_apellidos.getText());
            if(jButton_Sigueinte.getText().equalsIgnoreCase("Finalizar")){
                keyNode2.setAttribute("FINALIZADO","1");
            }else{
                keyNode2.setAttribute("FINALIZADO","0");
            }
            itemNode2.appendChild(keyNode2);
            raiz.appendChild(itemNode);
            raiz.appendChild(itemNode2);
            //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File("./xml/"+fileConfig+".xml")); //nombre del archivo
            //Result result = new StreamResult(new java.io.File("./src/ec/gob/senescyt/snna/xml/"+fileConfig+".xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            cargarXml();
        } catch (Exception ex) {
            Logger.getLogger(EncuestaContexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     */
    private void bloquearPegar(){
        InputMap mapCedula = txt_cedula.getInputMap(txt_cedula.WHEN_FOCUSED);
        mapCedula.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap mapNombres = txt_nombres.getInputMap(txt_nombres.WHEN_FOCUSED);
        mapNombres.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap mapApellidos = txt_apellidos.getInputMap(txt_apellidos.WHEN_FOCUSED);
        mapApellidos.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map2094 = txt_2094.getInputMap(txt_2094.WHEN_FOCUSED);
        map2094.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map2191 = txt_2191.getInputMap(txt_2191.WHEN_FOCUSED);
        map2191.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map2192 = txt_2192.getInputMap(txt_2192.WHEN_FOCUSED);
        map2192.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map2467 = txt_2467.getInputMap(txt_2467.WHEN_FOCUSED);
        map2467.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map2250 = txt_2250.getInputMap(txt_2250.WHEN_FOCUSED);
        map2250.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    /**
     * 
     */
    private void bloqueaPestanias(int indice){
        int inicio = indice + 1;
        int fin = jTabbedPane1.getTabCount()-1;
        for(int i=inicio;i<=fin;i++){
            jTabbedPane1.setEnabledAt(i,false);
        }
        if(indice == -1){
            for(Component c: jPanelSec_1.getComponents()){
                if(c instanceof JPanel && ((JPanel)c).isVisible()){
                    for(Component d: ((JPanel)c).getComponents()){
                        d.setEnabled(false);
                    }
                }
            }
            for(Component c: jPanelSec_2.getComponents()){
                if(c instanceof JPanel && ((JPanel)c).isVisible()){
                    for(Component d: ((JPanel)c).getComponents()){
                        d.setEnabled(false);
                    }
                }
            }
            for(Component c: jPanelSec_3.getComponents()){
                if(c instanceof JPanel && ((JPanel)c).isVisible()){
                    for(Component d: ((JPanel)c).getComponents()){
                        d.setEnabled(false);
                    }
                }
            }
            for(Component c: jPanelSec_4.getComponents()){
                if(c instanceof JPanel && ((JPanel)c).isVisible()){
                    for(Component d: ((JPanel)c).getComponents()){
                        d.setEnabled(false);
                    }
                }
            }
            for(Component c: jPanelSec_5.getComponents()){
                if(c instanceof JPanel && ((JPanel)c).isVisible()){
                    for(Component d: ((JPanel)c).getComponents()){
                        d.setEnabled(false);
                    }
                }
            }
            for(Component c: jPanelSec_6.getComponents()){
                if(c instanceof JPanel && ((JPanel)c).isVisible()){
                    for(Component d: ((JPanel)c).getComponents()){
                        d.setEnabled(false);
                    }
                }
            }
            jButton_Atras.setEnabled(false);
            jButton_Sigueinte.setEnabled(false);
        }
    }
    /**
     * 
     */
    @Override
    public Image getIconImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("ec/gob/senescyt/snna/resources/bender.png"));
        return icon;
    }
    
    /**
     * 
     */
    private void initSeccionUno(){
        bgSec1_283.add(rad_1812);
        bgSec1_283.add(rad_1813);
        
        bgSec1_285.add(rad_1822);
        bgSec1_285.add(rad_1823);
        
        bgSec1_287.add(rad_1832);
        bgSec1_287.add(rad_1833);
        bgSec1_287.add(rad_1834);
        bgSec1_287.add(rad_1835);
        
        bgSec1_289.add(rad_2085);
        bgSec1_289.add(rad_2086);
        bgSec1_289.add(rad_2087);
        bgSec1_289.add(rad_2088);
        bgSec1_289.add(rad_2089);
        bgSec1_289.add(rad_2090);
        bgSec1_289.add(rad_2091);
        
        bgSec1_290.add(rad_2092);
        bgSec1_290.add(rad_2093);
        
        bgSec1_292.add(rad_2095);
        bgSec1_292.add(rad_2096);
        bgSec1_292.add(rad_2097);
        bgSec1_292.add(rad_2098);
        bgSec1_292.add(rad_2099);
        bgSec1_292.add(rad_2100);
        bgSec1_292.add(rad_2101);
        bgSec1_292.add(rad_2102);
        
        bgSec1_293.add(rad_2103);
        bgSec1_293.add(rad_2104);
        bgSec1_293.add(rad_2105);
        bgSec1_293.add(rad_2106);
        bgSec1_293.add(rad_2107);
        bgSec1_293.add(rad_2108);
        bgSec1_293.add(rad_2109);
        bgSec1_293.add(rad_2110);
        bgSec1_293.add(rad_2111);
        bgSec1_293.add(rad_2112);
        bgSec1_293.add(rad_2113);
        bgSec1_293.add(rad_2114);
        bgSec1_293.add(rad_2115);
        bgSec1_293.add(rad_2116);
        bgSec1_293.add(rad_2117);
        bgSec1_293.add(rad_2118);
        bgSec1_293.add(rad_2119);
        bgSec1_293.add(rad_2120);
        bgSec1_293.add(rad_2121);
        bgSec1_293.add(rad_2122);
        bgSec1_293.add(rad_2123);
        bgSec1_293.add(rad_2124);
        bgSec1_293.add(rad_2125);
        bgSec1_293.add(rad_2126);
        bgSec1_293.add(rad_2127);
        bgSec1_293.add(rad_2128);
        bgSec1_293.add(rad_2129);
        bgSec1_293.add(rad_2130);
        
        bgSec1_294.add(rad_2131);
        bgSec1_294.add(rad_2132);
        bgSec1_294.add(rad_2133);
        bgSec1_294.add(rad_2134);
        bgSec1_294.add(rad_2135);
        bgSec1_294.add(rad_2136);
        bgSec1_294.add(rad_2137);
        bgSec1_294.add(rad_2138);
        
        bgSec1_295.add(rad_2139);
        bgSec1_295.add(rad_2140);
        bgSec1_295.add(rad_2141);
        bgSec1_295.add(rad_2142);
        bgSec1_295.add(rad_2143);
        bgSec1_295.add(rad_2144);
        bgSec1_295.add(rad_2145);
        bgSec1_295.add(rad_2146);
        bgSec1_295.add(rad_2147);
        bgSec1_295.add(rad_2148);
        bgSec1_295.add(rad_2149);
        bgSec1_295.add(rad_2150);
        bgSec1_295.add(rad_2151);
        bgSec1_295.add(rad_2152);
        bgSec1_295.add(rad_2153);
        bgSec1_295.add(rad_2154);
        bgSec1_295.add(rad_2155);
        bgSec1_295.add(rad_2156);
        bgSec1_295.add(rad_2157);
        bgSec1_295.add(rad_2158);
        bgSec1_295.add(rad_2159);
        bgSec1_295.add(rad_2160);
        bgSec1_295.add(rad_2161);
        bgSec1_295.add(rad_2162);
        bgSec1_295.add(rad_2163);
        bgSec1_295.add(rad_2164);
        bgSec1_295.add(rad_2165);
        bgSec1_295.add(rad_2166);
        
        bgSec1_296.add(rad_2167);
        bgSec1_296.add(rad_2168);
        bgSec1_296.add(rad_2169);
        bgSec1_296.add(rad_2170);
        
        bgSec1_297.add(rad_2171);
        bgSec1_297.add(rad_2172);
        bgSec1_297.add(rad_2173);
        bgSec1_297.add(rad_2174);

        jPanel_284.setVisible(false);
        jPanel_286.setVisible(false);
        jPanel_287.setVisible(false);
        jPanel_288.setVisible(false);
        jPanel_289.setVisible(false);
        jPanel_290.setVisible(false);
        jPanel_291.setVisible(false);
        jPanel_293.setVisible(false);
        jPanel_295.setVisible(false);
        jPanel_296.setVisible(false);
        jPanel_297.setVisible(false);
        jPanel_356.setVisible(false);
        jPanel_358.setVisible(false);
        jPanel_360.setVisible(false);
        jPanel_362.setVisible(false);
        
        jLabel_282.setVisible(false);
        jLabel_283.setVisible(false);
        jLabel_284.setVisible(false);
        jLabel_285.setVisible(false);
        jLabel_286.setVisible(false);
        jLabel_287.setVisible(false);
        jLabel_288.setVisible(false);
        jLabel_289.setVisible(false);
        jLabel_290.setVisible(false);
        jLabel_291.setVisible(false);
        jLabel_292.setVisible(false);
        jLabel_293.setVisible(false);
        jLabel_294.setVisible(false);
        jLabel_295.setVisible(false);
        jLabel_296.setVisible(false);
        jLabel_297.setVisible(false);
        jLabel_356.setVisible(false);
        jLabel_358.setVisible(false);
        jLabel_360.setVisible(false);
        jLabel_362.setVisible(false);
        
        jList_288.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = paises;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
        jList_356.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = lenguaIndigenaPadre;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
        jList_360.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = lenguaExtranjeraPadre;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
        jList_358.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = lenguaIndigenaMadre;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
        jList_362.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = lenguaExtrajeraMadre;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
    }
    /**
     * 
     */
    private void initSeccionDos(){
        bgSec2_298.add(rad_2175);
        bgSec2_298.add(rad_2176);
        bgSec2_298.add(rad_2177);
        bgSec2_298.add(rad_2178);
        bgSec2_298.add(rad_2179);
        bgSec2_298.add(rad_2180);
        bgSec2_298.add(rad_2181);
        bgSec2_298.add(rad_2182);
        
        bgSec2_302.add(rad_2193);
        bgSec2_302.add(rad_2194);
        
        bgSec2_303.add(rad_2195);
        bgSec2_303.add(rad_2196);
        bgSec2_303.add(rad_2197);
        bgSec2_303.add(rad_2198);
        bgSec2_303.add(rad_2199);
        
        bgSec2_304.add(rad_2200);
        bgSec2_304.add(rad_2201);
        bgSec2_304.add(rad_2202);
        bgSec2_304.add(rad_2203);
        bgSec2_304.add(rad_2204);
        
        bgSec2_305.add(rad_2205);
        bgSec2_305.add(rad_2206);
        bgSec2_305.add(rad_2207);
        bgSec2_305.add(rad_2208);
        bgSec2_305.add(rad_2209);
        bgSec2_305.add(rad_2210);
        
        bgSec2_306.add(rad_2211);
        bgSec2_306.add(rad_2212);
        bgSec2_306.add(rad_2213);
        bgSec2_306.add(rad_2214);
        
        jPanel_299.setVisible(false);
        
        jLabel_298.setVisible(false);
        jLabel_299.setVisible(false);
        jLabel_300.setVisible(false);
        jLabel_301.setVisible(false);
        jLabel_302.setVisible(false);
        jLabel_303.setVisible(false);
        jLabel_304.setVisible(false);
        jLabel_305.setVisible(false);
        jLabel_306.setVisible(false);
        
    }
    /**
     * 
     */
    private void intiSeccionTres(){
        bgSec3_307.add(rad_2215);
        bgSec3_307.add(rad_2216);
        bgSec3_307.add(rad_2217);
        bgSec3_307.add(rad_2218);
        bgSec3_307.add(rad_2219);
        bgSec3_307.add(rad_2220);
        bgSec3_307.add(rad_2221);
        
        bgSec3_308.add(rad_2222);
        bgSec3_308.add(rad_2223);
        bgSec3_308.add(rad_2224);
        bgSec3_308.add(rad_2225);
        bgSec3_308.add(rad_2226);
        bgSec3_308.add(rad_2227);
        bgSec3_308.add(rad_2228);
        bgSec3_308.add(rad_2229);
        
        bgSec3_309.add(rad_2230);
        bgSec3_309.add(rad_2231);
        bgSec3_309.add(rad_2232);
        bgSec3_309.add(rad_2233);
        bgSec3_309.add(rad_2234);
        bgSec3_309.add(rad_2235);
        bgSec3_309.add(rad_2236);
        bgSec3_309.add(rad_2237);
        bgSec3_309.add(rad_2238);
        bgSec3_309.add(rad_2239);
        
        bgSec3_311.add(rad_2240);
        bgSec3_311.add(rad_2241);
        bgSec3_311.add(rad_2242);
        bgSec3_311.add(rad_2243);
        bgSec3_311.add(rad_2244);
        bgSec3_311.add(rad_2245);
        bgSec3_311.add(rad_2246);
        bgSec3_311.add(rad_2247);
        bgSec3_311.add(rad_2248);
        bgSec3_311.add(rad_2249);
        
        bgSec3_313.add(rad_2251);
        bgSec3_313.add(rad_2252);
        bgSec3_313.add(rad_2253);
        bgSec3_313.add(rad_2254);
        bgSec3_313.add(rad_2255);
        bgSec3_313.add(rad_2256);
        bgSec3_313.add(rad_2257);
        bgSec3_313.add(rad_2258);
        bgSec3_313.add(rad_2259);
        bgSec3_313.add(rad_2260);
        bgSec3_313.add(rad_2261);
        bgSec3_313.add(rad_2262);
        
        bgSec3_314.add(rad_2263);
        bgSec3_314.add(rad_2264);
        bgSec3_314.add(rad_2265);
        bgSec3_314.add(rad_2266);
        bgSec3_314.add(rad_2267);
        bgSec3_314.add(rad_2268);
        bgSec3_314.add(rad_2269);
        bgSec3_314.add(rad_2270);
        bgSec3_314.add(rad_2271);
        bgSec3_314.add(rad_2272);
        bgSec3_314.add(rad_2273);
        
        bgSec3_315.add(rad_2274);
        bgSec3_315.add(rad_2275);
        bgSec3_315.add(rad_2276);
        bgSec3_315.add(rad_2277);
        bgSec3_315.add(rad_2278);
        bgSec3_315.add(rad_2279);
        bgSec3_315.add(rad_2280);
        bgSec3_315.add(rad_2281);
        bgSec3_315.add(rad_2282);
        bgSec3_315.add(rad_2283);
        bgSec3_315.add(rad_2284);
        
        bgSec3_316.add(rad_2285);
        bgSec3_316.add(rad_2286);
        
        bgSec3_317.add(rad_2287);
        bgSec3_317.add(rad_2288);
        
        bgSec3_319.add(rad_2294);
        bgSec3_319.add(rad_2295);
        
        bgSec3_321.add(rad_2303);
        bgSec3_321.add(rad_2304);
        bgSec3_321.add(rad_2305);
        bgSec3_321.add(rad_2306);
        bgSec3_321.add(rad_2307);
        bgSec3_321.add(rad_2308);
        
        bgSec3_322.add(rad_2309);
        bgSec3_322.add(rad_2310);
        bgSec3_322.add(rad_2311);
        bgSec3_322.add(rad_2312);
        bgSec3_322.add(rad_2313);
        bgSec3_322.add(rad_2314);
        bgSec3_322.add(rad_2315);
        bgSec3_322.add(rad_2316);
        bgSec3_322.add(rad_2317);
        
        bgSec3_323.add(rad_2318);
        bgSec3_323.add(rad_2319);
        
        bgSec3_324.add(rad_2320);
        bgSec3_324.add(rad_2321);
        bgSec3_324.add(rad_2322);
        bgSec3_324.add(rad_2323);
        bgSec3_324.add(rad_2324);
        bgSec3_324.add(rad_2325);
        bgSec3_324.add(rad_2326);
        bgSec3_324.add(rad_2327);
        
        bgSec3_325.add(rad_2328);
        bgSec3_325.add(rad_2329);
        
        bgSec3_326.add(rad_2330);
        bgSec3_326.add(rad_2331);
        bgSec3_326.add(rad_2332);
        bgSec3_326.add(rad_2333);
        bgSec3_326.add(rad_2334);
        
        jPanel_310.setVisible(false);
        jPanel_312.setVisible(false);
        jPanel_320.setVisible(false);
        jPanel_324.setVisible(false);
        
        jLabel_307.setVisible(false);
        jLabel_308.setVisible(false);
        jLabel_309.setVisible(false);
        jLabel_310.setVisible(false);
        jLabel_311.setVisible(false);
        jLabel_312.setVisible(false);
        jLabel_313.setVisible(false);
        jLabel_314.setVisible(false);
        jLabel_315.setVisible(false);
        jLabel_316.setVisible(false);
        jLabel_317.setVisible(false);
        jLabel_318.setVisible(false);
        jLabel_319.setVisible(false);
        jLabel_320.setVisible(false);
        jLabel_321.setVisible(false);
        jLabel_322.setVisible(false);
        jLabel_323.setVisible(false);
        jLabel_324.setVisible(false);
        jLabel_325.setVisible(false);
        jLabel_326.setVisible(false);
        
    }
    /**
     * 
     */
    private void initSeccionCuatro(){
        bgSec4_327.add(rad_2335);
        bgSec4_327.add(rad_2336);
        bgSec4_327.add(rad_2337);
        bgSec4_327.add(rad_2338);
        
        bgSec4_328.add(rad_2339);
        bgSec4_328.add(rad_2340);
        bgSec4_328.add(rad_2341);
        bgSec4_328.add(rad_2342);
        bgSec4_328.add(rad_2343);
        bgSec4_328.add(rad_2344);
        
        bgSec4_329.add(rad_2345);
        bgSec4_329.add(rad_2346);
        bgSec4_329.add(rad_2347);
        bgSec4_329.add(rad_2348);
        bgSec4_329.add(rad_2349);
        bgSec4_329.add(rad_2350);
        bgSec4_329.add(rad_2351);
        bgSec4_329.add(rad_2352);
        
        bgSec4_330.add(rad_2353);
        bgSec4_330.add(rad_2354);
        bgSec4_330.add(rad_2355);
        bgSec4_330.add(rad_2356);
        bgSec4_330.add(rad_2357);
        bgSec4_330.add(rad_2358);
        bgSec4_330.add(rad_2359);
        
        bgSec4_331.add(rad_2360);
        bgSec4_331.add(rad_2361);
        bgSec4_331.add(rad_2362);
        bgSec4_331.add(rad_2363);
        
        jPanel_331.setVisible(false);
        
        jLabel_327.setVisible(false);
        jLabel_328.setVisible(false);
        jLabel_329.setVisible(false);
        jLabel_330.setVisible(false);
        jLabel_331.setVisible(false);
    }
    /**
     * 
     */
    private void initSeccionCinco(){
        bgSec5_333.add(rad_2369);
        bgSec5_333.add(rad_2370);
        bgSec5_333.add(rad_2371);
        bgSec5_333.add(rad_2372);
        
        bgSec5_334.add(rad_2373);
        bgSec5_334.add(rad_2374);
        bgSec5_334.add(rad_2375);
        bgSec5_334.add(rad_2376);
        
        bgSec5_336.add(rad_2380);
        bgSec5_336.add(rad_2381);
        bgSec5_336.add(rad_2382);
        bgSec5_336.add(rad_2383);
        bgSec5_336.add(rad_2384);
        
        bgSec5_337.add(rad_2385);
        bgSec5_337.add(rad_2386);
        bgSec5_337.add(rad_2387);
        bgSec5_337.add(rad_2388);
        bgSec5_337.add(rad_2389);
        
        jLabel_332.setVisible(false);
        jLabel_333.setVisible(false);
        jLabel_334.setVisible(false);
        jLabel_335.setVisible(false);
        jLabel_336.setVisible(false);
        jLabel_337.setVisible(false);
    }
    /**
     * 
     */
    private void initSeccionSeis(){
        bgSec6_338.add(rad_2390);
        bgSec6_338.add(rad_2391);
        bgSec6_338.add(rad_2392);
        bgSec6_338.add(rad_2393);
        bgSec6_338.add(rad_2394);
        bgSec6_338.add(rad_2395);
        bgSec6_338.add(rad_2396);
        bgSec6_338.add(rad_2397);
        
        bgSec6_339.add(rad_2398);
        bgSec6_339.add(rad_2399);
        bgSec6_339.add(rad_2400);
        bgSec6_339.add(rad_2401);
        bgSec6_339.add(rad_2402);
        bgSec6_339.add(rad_2403);
        bgSec6_339.add(rad_2404);
        bgSec6_339.add(rad_2405);
        
        bgSec6_340.add(rad_2406);
        bgSec6_340.add(rad_2407);
        bgSec6_340.add(rad_2408);
        bgSec6_340.add(rad_2409);
        
        bgSec6_342.add(rad_2411);
        bgSec6_342.add(rad_2412);
        bgSec6_342.add(rad_2413);
        bgSec6_342.add(rad_2414);
        bgSec6_342.add(rad_2415);
        
        bgSec6_343.add(rad_2416);
        bgSec6_343.add(rad_2417);
        bgSec6_343.add(rad_2418);
        bgSec6_343.add(rad_2419);
        bgSec6_343.add(rad_2420);
        
        bgSec6_344.add(rad_2421);
        bgSec6_344.add(rad_2422);
        bgSec6_344.add(rad_2423);
        bgSec6_344.add(rad_2424);
        bgSec6_344.add(rad_2425);
        
        bgSec6_345.add(rad_2426);
        bgSec6_345.add(rad_2427);
        bgSec6_345.add(rad_2428);
        bgSec6_345.add(rad_2429);
        bgSec6_345.add(rad_2430);
        
        bgSec6_346.add(rad_2431);
        bgSec6_346.add(rad_2432);
        bgSec6_346.add(rad_2433);
        bgSec6_346.add(rad_2434);
        bgSec6_346.add(rad_2435);
        
        bgSec6_348.add(rad_2437);
        bgSec6_348.add(rad_2438);
        bgSec6_348.add(rad_2439);
        bgSec6_348.add(rad_2440);
        bgSec6_348.add(rad_2441);
        
        bgSec6_349.add(rad_2442);
        bgSec6_349.add(rad_2443);
        bgSec6_349.add(rad_2444);
        bgSec6_349.add(rad_2445);
        bgSec6_349.add(rad_2446);
        
        bgSec6_350.add(rad_2447);
        bgSec6_350.add(rad_2448);
        bgSec6_350.add(rad_2449);
        bgSec6_350.add(rad_2450);
        bgSec6_350.add(rad_2451);
        
        bgSec6_351.add(rad_2452);
        bgSec6_351.add(rad_2453);
        bgSec6_351.add(rad_2454);
        bgSec6_351.add(rad_2455);
        bgSec6_351.add(rad_2456);
        
        bgSec6_352.add(rad_2457);
        bgSec6_352.add(rad_2458);
        bgSec6_352.add(rad_2459);
        bgSec6_352.add(rad_2460);
        bgSec6_352.add(rad_2461);
        
        bgSec6_353.add(rad_2462);
        bgSec6_353.add(rad_2463);
        bgSec6_353.add(rad_2464);
        bgSec6_353.add(rad_2465);
        bgSec6_353.add(rad_2466);
        
        jLabel_338.setVisible(false);
        jLabel_339.setVisible(false);
        jLabel_340.setVisible(false);
        jLabel_342.setVisible(false);
        jLabel_343.setVisible(false);
        jLabel_344.setVisible(false);
        jLabel_345.setVisible(false);
        jLabel_346.setVisible(false);
        jLabel_348.setVisible(false);
        jLabel_349.setVisible(false);
        jLabel_350.setVisible(false);
        jLabel_351.setVisible(false);
        jLabel_352.setVisible(false);
        jLabel_353.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSec1_283 = new javax.swing.ButtonGroup();
        bgSec1_285 = new javax.swing.ButtonGroup();
        bgSec1_287 = new javax.swing.ButtonGroup();
        bgSec1_289 = new javax.swing.ButtonGroup();
        bgSec1_290 = new javax.swing.ButtonGroup();
        bgSec1_292 = new javax.swing.ButtonGroup();
        bgSec1_293 = new javax.swing.ButtonGroup();
        bgSec1_294 = new javax.swing.ButtonGroup();
        bgSec1_295 = new javax.swing.ButtonGroup();
        bgSec1_296 = new javax.swing.ButtonGroup();
        bgSec1_297 = new javax.swing.ButtonGroup();
        bgSec2_298 = new javax.swing.ButtonGroup();
        bgSec2_302 = new javax.swing.ButtonGroup();
        bgSec2_303 = new javax.swing.ButtonGroup();
        bgSec2_304 = new javax.swing.ButtonGroup();
        bgSec2_305 = new javax.swing.ButtonGroup();
        bgSec2_306 = new javax.swing.ButtonGroup();
        bgSec3_307 = new javax.swing.ButtonGroup();
        bgSec3_308 = new javax.swing.ButtonGroup();
        bgSec3_309 = new javax.swing.ButtonGroup();
        bgSec3_311 = new javax.swing.ButtonGroup();
        bgSec3_313 = new javax.swing.ButtonGroup();
        bgSec3_314 = new javax.swing.ButtonGroup();
        bgSec3_315 = new javax.swing.ButtonGroup();
        bgSec3_316 = new javax.swing.ButtonGroup();
        bgSec3_317 = new javax.swing.ButtonGroup();
        bgSec3_319 = new javax.swing.ButtonGroup();
        bgSec3_321 = new javax.swing.ButtonGroup();
        bgSec3_322 = new javax.swing.ButtonGroup();
        bgSec3_323 = new javax.swing.ButtonGroup();
        bgSec3_324 = new javax.swing.ButtonGroup();
        bgSec3_325 = new javax.swing.ButtonGroup();
        bgSec3_326 = new javax.swing.ButtonGroup();
        bgSec4_327 = new javax.swing.ButtonGroup();
        bgSec4_328 = new javax.swing.ButtonGroup();
        bgSec4_329 = new javax.swing.ButtonGroup();
        bgSec4_330 = new javax.swing.ButtonGroup();
        bgSec4_331 = new javax.swing.ButtonGroup();
        bgSec5_333 = new javax.swing.ButtonGroup();
        bgSec5_334 = new javax.swing.ButtonGroup();
        bgSec5_336 = new javax.swing.ButtonGroup();
        bgSec5_337 = new javax.swing.ButtonGroup();
        bgSec6_338 = new javax.swing.ButtonGroup();
        bgSec6_339 = new javax.swing.ButtonGroup();
        bgSec6_340 = new javax.swing.ButtonGroup();
        bgSec6_342 = new javax.swing.ButtonGroup();
        bgSec6_343 = new javax.swing.ButtonGroup();
        bgSec6_344 = new javax.swing.ButtonGroup();
        bgSec6_345 = new javax.swing.ButtonGroup();
        bgSec6_346 = new javax.swing.ButtonGroup();
        bgSec6_348 = new javax.swing.ButtonGroup();
        bgSec6_349 = new javax.swing.ButtonGroup();
        bgSec6_350 = new javax.swing.ButtonGroup();
        bgSec6_351 = new javax.swing.ButtonGroup();
        bgSec6_352 = new javax.swing.ButtonGroup();
        bgSec6_353 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelSec_1 = new javax.swing.JPanel();
        jPanel_282 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chk_1802 = new javax.swing.JCheckBox();
        chk_1803 = new javax.swing.JCheckBox();
        chk_1804 = new javax.swing.JCheckBox();
        chk_1805 = new javax.swing.JCheckBox();
        chk_1806 = new javax.swing.JCheckBox();
        chk_1807 = new javax.swing.JCheckBox();
        chk_1808 = new javax.swing.JCheckBox();
        chk_1809 = new javax.swing.JCheckBox();
        chk_1810 = new javax.swing.JCheckBox();
        chk_1811 = new javax.swing.JCheckBox();
        jLabel_282 = new javax.swing.JLabel();
        jPanel_283 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rad_1812 = new javax.swing.JRadioButton();
        rad_1813 = new javax.swing.JRadioButton();
        jLabel_283 = new javax.swing.JLabel();
        jPanel_284 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        chk_1814 = new javax.swing.JCheckBox();
        chk_1815 = new javax.swing.JCheckBox();
        chk_1816 = new javax.swing.JCheckBox();
        chk_1817 = new javax.swing.JCheckBox();
        chk_1818 = new javax.swing.JCheckBox();
        chk_1819 = new javax.swing.JCheckBox();
        chk_1820 = new javax.swing.JCheckBox();
        chk_1821 = new javax.swing.JCheckBox();
        jLabel_284 = new javax.swing.JLabel();
        jPanel_285 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rad_1822 = new javax.swing.JRadioButton();
        rad_1823 = new javax.swing.JRadioButton();
        jLabel_285 = new javax.swing.JLabel();
        jPanel_286 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        chk_1824 = new javax.swing.JCheckBox();
        chk_1825 = new javax.swing.JCheckBox();
        chk_1826 = new javax.swing.JCheckBox();
        chk_1827 = new javax.swing.JCheckBox();
        chk_1828 = new javax.swing.JCheckBox();
        chk_1829 = new javax.swing.JCheckBox();
        chk_1830 = new javax.swing.JCheckBox();
        chk_1831 = new javax.swing.JCheckBox();
        jLabel_286 = new javax.swing.JLabel();
        jPanel_287 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rad_1832 = new javax.swing.JRadioButton();
        rad_1833 = new javax.swing.JRadioButton();
        rad_1834 = new javax.swing.JRadioButton();
        rad_1835 = new javax.swing.JRadioButton();
        jLabel_287 = new javax.swing.JLabel();
        jPanel_288 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel_288 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList_288 = new javax.swing.JList<>();
        jPanel_289 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        rad_2085 = new javax.swing.JRadioButton();
        rad_2086 = new javax.swing.JRadioButton();
        rad_2087 = new javax.swing.JRadioButton();
        rad_2088 = new javax.swing.JRadioButton();
        rad_2089 = new javax.swing.JRadioButton();
        rad_2090 = new javax.swing.JRadioButton();
        rad_2091 = new javax.swing.JRadioButton();
        jLabel_289 = new javax.swing.JLabel();
        jPanel_290 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        rad_2092 = new javax.swing.JRadioButton();
        rad_2093 = new javax.swing.JRadioButton();
        jLabel_290 = new javax.swing.JLabel();
        jPanel_291 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_2094 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel_291 = new javax.swing.JLabel();
        jPanel_292 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        rad_2095 = new javax.swing.JRadioButton();
        rad_2096 = new javax.swing.JRadioButton();
        rad_2097 = new javax.swing.JRadioButton();
        rad_2098 = new javax.swing.JRadioButton();
        rad_2099 = new javax.swing.JRadioButton();
        rad_2100 = new javax.swing.JRadioButton();
        rad_2101 = new javax.swing.JRadioButton();
        rad_2102 = new javax.swing.JRadioButton();
        jLabel_292 = new javax.swing.JLabel();
        jPanel_293 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        rad_2103 = new javax.swing.JRadioButton();
        rad_2104 = new javax.swing.JRadioButton();
        rad_2105 = new javax.swing.JRadioButton();
        rad_2106 = new javax.swing.JRadioButton();
        rad_2107 = new javax.swing.JRadioButton();
        rad_2108 = new javax.swing.JRadioButton();
        rad_2109 = new javax.swing.JRadioButton();
        rad_2110 = new javax.swing.JRadioButton();
        rad_2111 = new javax.swing.JRadioButton();
        rad_2112 = new javax.swing.JRadioButton();
        rad_2113 = new javax.swing.JRadioButton();
        rad_2114 = new javax.swing.JRadioButton();
        rad_2115 = new javax.swing.JRadioButton();
        rad_2116 = new javax.swing.JRadioButton();
        rad_2117 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        rad_2118 = new javax.swing.JRadioButton();
        rad_2119 = new javax.swing.JRadioButton();
        rad_2120 = new javax.swing.JRadioButton();
        rad_2121 = new javax.swing.JRadioButton();
        rad_2122 = new javax.swing.JRadioButton();
        rad_2123 = new javax.swing.JRadioButton();
        rad_2124 = new javax.swing.JRadioButton();
        rad_2125 = new javax.swing.JRadioButton();
        rad_2126 = new javax.swing.JRadioButton();
        rad_2127 = new javax.swing.JRadioButton();
        rad_2128 = new javax.swing.JRadioButton();
        rad_2129 = new javax.swing.JRadioButton();
        rad_2130 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_293 = new javax.swing.JLabel();
        jPanel_294 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        rad_2131 = new javax.swing.JRadioButton();
        rad_2132 = new javax.swing.JRadioButton();
        rad_2133 = new javax.swing.JRadioButton();
        rad_2134 = new javax.swing.JRadioButton();
        rad_2135 = new javax.swing.JRadioButton();
        rad_2136 = new javax.swing.JRadioButton();
        rad_2137 = new javax.swing.JRadioButton();
        rad_2138 = new javax.swing.JRadioButton();
        jLabel_294 = new javax.swing.JLabel();
        jPanel_295 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        rad_2153 = new javax.swing.JRadioButton();
        rad_2152 = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        rad_2151 = new javax.swing.JRadioButton();
        rad_2165 = new javax.swing.JRadioButton();
        rad_2164 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        rad_2166 = new javax.swing.JRadioButton();
        rad_2145 = new javax.swing.JRadioButton();
        rad_2146 = new javax.swing.JRadioButton();
        rad_2149 = new javax.swing.JRadioButton();
        rad_2150 = new javax.swing.JRadioButton();
        rad_2147 = new javax.swing.JRadioButton();
        rad_2148 = new javax.swing.JRadioButton();
        rad_2162 = new javax.swing.JRadioButton();
        rad_2161 = new javax.swing.JRadioButton();
        rad_2144 = new javax.swing.JRadioButton();
        rad_2163 = new javax.swing.JRadioButton();
        rad_2141 = new javax.swing.JRadioButton();
        rad_2140 = new javax.swing.JRadioButton();
        rad_2143 = new javax.swing.JRadioButton();
        rad_2142 = new javax.swing.JRadioButton();
        rad_2154 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        rad_2155 = new javax.swing.JRadioButton();
        rad_2139 = new javax.swing.JRadioButton();
        rad_2156 = new javax.swing.JRadioButton();
        rad_2157 = new javax.swing.JRadioButton();
        rad_2158 = new javax.swing.JRadioButton();
        rad_2159 = new javax.swing.JRadioButton();
        rad_2160 = new javax.swing.JRadioButton();
        jLabel_295 = new javax.swing.JLabel();
        jPanel_296 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        rad_2167 = new javax.swing.JRadioButton();
        rad_2168 = new javax.swing.JRadioButton();
        rad_2169 = new javax.swing.JRadioButton();
        rad_2170 = new javax.swing.JRadioButton();
        jLabel_296 = new javax.swing.JLabel();
        jPanel_297 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        rad_2171 = new javax.swing.JRadioButton();
        rad_2172 = new javax.swing.JRadioButton();
        rad_2173 = new javax.swing.JRadioButton();
        rad_2174 = new javax.swing.JRadioButton();
        jLabel_297 = new javax.swing.JLabel();
        jPanel_356 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel_356 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList_356 = new javax.swing.JList<>();
        jPanel_360 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel_360 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList_360 = new javax.swing.JList<>();
        jPanel_358 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel_358 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList_358 = new javax.swing.JList<>();
        jPanel_362 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jLabel_362 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList_362 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelSec_2 = new javax.swing.JPanel();
        jPanel_298 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        rad_2175 = new javax.swing.JRadioButton();
        rad_2176 = new javax.swing.JRadioButton();
        rad_2177 = new javax.swing.JRadioButton();
        rad_2178 = new javax.swing.JRadioButton();
        rad_2179 = new javax.swing.JRadioButton();
        rad_2180 = new javax.swing.JRadioButton();
        rad_2181 = new javax.swing.JRadioButton();
        rad_2182 = new javax.swing.JRadioButton();
        jLabel_298 = new javax.swing.JLabel();
        jPanel_299 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        rad_2183 = new javax.swing.JRadioButton();
        rad_2184 = new javax.swing.JRadioButton();
        rad_2185 = new javax.swing.JRadioButton();
        rad_2186 = new javax.swing.JRadioButton();
        rad_2187 = new javax.swing.JRadioButton();
        rad_2188 = new javax.swing.JRadioButton();
        rad_2189 = new javax.swing.JRadioButton();
        rad_2190 = new javax.swing.JRadioButton();
        jLabel_299 = new javax.swing.JLabel();
        jPanel_300 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txt_2191 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel_300 = new javax.swing.JLabel();
        jPanel_301 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txt_2192 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel_301 = new javax.swing.JLabel();
        jPanel_302 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        rad_2193 = new javax.swing.JRadioButton();
        rad_2194 = new javax.swing.JRadioButton();
        jLabel_302 = new javax.swing.JLabel();
        jPanel_303 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        rad_2195 = new javax.swing.JRadioButton();
        rad_2196 = new javax.swing.JRadioButton();
        rad_2197 = new javax.swing.JRadioButton();
        rad_2198 = new javax.swing.JRadioButton();
        rad_2199 = new javax.swing.JRadioButton();
        jLabel_303 = new javax.swing.JLabel();
        jPanel_304 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        rad_2200 = new javax.swing.JRadioButton();
        rad_2201 = new javax.swing.JRadioButton();
        rad_2202 = new javax.swing.JRadioButton();
        rad_2203 = new javax.swing.JRadioButton();
        rad_2204 = new javax.swing.JRadioButton();
        jLabel_304 = new javax.swing.JLabel();
        jPanel_305 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        rad_2205 = new javax.swing.JRadioButton();
        rad_2206 = new javax.swing.JRadioButton();
        rad_2207 = new javax.swing.JRadioButton();
        rad_2208 = new javax.swing.JRadioButton();
        rad_2209 = new javax.swing.JRadioButton();
        rad_2210 = new javax.swing.JRadioButton();
        jLabel_305 = new javax.swing.JLabel();
        jPanel_306 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        rad_2211 = new javax.swing.JRadioButton();
        rad_2212 = new javax.swing.JRadioButton();
        rad_2213 = new javax.swing.JRadioButton();
        rad_2214 = new javax.swing.JRadioButton();
        jLabel_306 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanelSec_3 = new javax.swing.JPanel();
        jPanel_307 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        rad_2215 = new javax.swing.JRadioButton();
        rad_2216 = new javax.swing.JRadioButton();
        rad_2217 = new javax.swing.JRadioButton();
        rad_2218 = new javax.swing.JRadioButton();
        rad_2219 = new javax.swing.JRadioButton();
        rad_2220 = new javax.swing.JRadioButton();
        rad_2221 = new javax.swing.JRadioButton();
        jLabel_307 = new javax.swing.JLabel();
        jPanel_308 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        rad_2222 = new javax.swing.JRadioButton();
        rad_2223 = new javax.swing.JRadioButton();
        rad_2224 = new javax.swing.JRadioButton();
        rad_2225 = new javax.swing.JRadioButton();
        rad_2226 = new javax.swing.JRadioButton();
        rad_2227 = new javax.swing.JRadioButton();
        rad_2228 = new javax.swing.JRadioButton();
        rad_2229 = new javax.swing.JRadioButton();
        jLabel_308 = new javax.swing.JLabel();
        jPanel_309 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        rad_2230 = new javax.swing.JRadioButton();
        rad_2231 = new javax.swing.JRadioButton();
        rad_2232 = new javax.swing.JRadioButton();
        rad_2233 = new javax.swing.JRadioButton();
        rad_2234 = new javax.swing.JRadioButton();
        rad_2235 = new javax.swing.JRadioButton();
        rad_2236 = new javax.swing.JRadioButton();
        rad_2237 = new javax.swing.JRadioButton();
        rad_2238 = new javax.swing.JRadioButton();
        rad_2239 = new javax.swing.JRadioButton();
        jLabel_309 = new javax.swing.JLabel();
        jPanel_310 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txt_2467 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel_310 = new javax.swing.JLabel();
        jPanel_311 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        rad_2240 = new javax.swing.JRadioButton();
        rad_2241 = new javax.swing.JRadioButton();
        rad_2242 = new javax.swing.JRadioButton();
        rad_2243 = new javax.swing.JRadioButton();
        rad_2244 = new javax.swing.JRadioButton();
        rad_2245 = new javax.swing.JRadioButton();
        rad_2246 = new javax.swing.JRadioButton();
        rad_2247 = new javax.swing.JRadioButton();
        rad_2248 = new javax.swing.JRadioButton();
        rad_2249 = new javax.swing.JRadioButton();
        jLabel_311 = new javax.swing.JLabel();
        jPanel_312 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        txt_2250 = new javax.swing.JTextField();
        jLabel_312 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jPanel_313 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        rad_2251 = new javax.swing.JRadioButton();
        rad_2252 = new javax.swing.JRadioButton();
        rad_2253 = new javax.swing.JRadioButton();
        rad_2254 = new javax.swing.JRadioButton();
        rad_2255 = new javax.swing.JRadioButton();
        rad_2256 = new javax.swing.JRadioButton();
        rad_2257 = new javax.swing.JRadioButton();
        rad_2258 = new javax.swing.JRadioButton();
        rad_2259 = new javax.swing.JRadioButton();
        rad_2260 = new javax.swing.JRadioButton();
        rad_2261 = new javax.swing.JRadioButton();
        rad_2262 = new javax.swing.JRadioButton();
        jLabel_313 = new javax.swing.JLabel();
        jPanel_314 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        rad_2263 = new javax.swing.JRadioButton();
        rad_2264 = new javax.swing.JRadioButton();
        rad_2265 = new javax.swing.JRadioButton();
        rad_2266 = new javax.swing.JRadioButton();
        rad_2267 = new javax.swing.JRadioButton();
        rad_2268 = new javax.swing.JRadioButton();
        rad_2269 = new javax.swing.JRadioButton();
        rad_2270 = new javax.swing.JRadioButton();
        rad_2271 = new javax.swing.JRadioButton();
        rad_2272 = new javax.swing.JRadioButton();
        rad_2273 = new javax.swing.JRadioButton();
        jLabel_314 = new javax.swing.JLabel();
        jPanel_315 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        rad_2274 = new javax.swing.JRadioButton();
        rad_2275 = new javax.swing.JRadioButton();
        rad_2276 = new javax.swing.JRadioButton();
        rad_2277 = new javax.swing.JRadioButton();
        rad_2278 = new javax.swing.JRadioButton();
        rad_2279 = new javax.swing.JRadioButton();
        rad_2280 = new javax.swing.JRadioButton();
        rad_2281 = new javax.swing.JRadioButton();
        rad_2282 = new javax.swing.JRadioButton();
        rad_2283 = new javax.swing.JRadioButton();
        rad_2284 = new javax.swing.JRadioButton();
        jLabel_315 = new javax.swing.JLabel();
        jPanel_316 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        rad_2285 = new javax.swing.JRadioButton();
        rad_2286 = new javax.swing.JRadioButton();
        jLabel_316 = new javax.swing.JLabel();
        jPanel_317 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        rad_2287 = new javax.swing.JRadioButton();
        rad_2288 = new javax.swing.JRadioButton();
        jLabel_317 = new javax.swing.JLabel();
        jPanel_318 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        chk_2289 = new javax.swing.JCheckBox();
        chk_2290 = new javax.swing.JCheckBox();
        chk_2291 = new javax.swing.JCheckBox();
        chk_2292 = new javax.swing.JCheckBox();
        chk_2293 = new javax.swing.JCheckBox();
        jLabel_318 = new javax.swing.JLabel();
        jPanel_319 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        rad_2294 = new javax.swing.JRadioButton();
        rad_2295 = new javax.swing.JRadioButton();
        jLabel_319 = new javax.swing.JLabel();
        jPanel_320 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        chk_2296 = new javax.swing.JCheckBox();
        chk_2297 = new javax.swing.JCheckBox();
        chk_2298 = new javax.swing.JCheckBox();
        chk_2299 = new javax.swing.JCheckBox();
        chk_2300 = new javax.swing.JCheckBox();
        chk_2301 = new javax.swing.JCheckBox();
        chk_2302 = new javax.swing.JCheckBox();
        jLabel_320 = new javax.swing.JLabel();
        jPanel_321 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        rad_2303 = new javax.swing.JRadioButton();
        rad_2304 = new javax.swing.JRadioButton();
        rad_2305 = new javax.swing.JRadioButton();
        rad_2306 = new javax.swing.JRadioButton();
        rad_2307 = new javax.swing.JRadioButton();
        rad_2308 = new javax.swing.JRadioButton();
        jLabel_321 = new javax.swing.JLabel();
        jPanel_322 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        rad_2309 = new javax.swing.JRadioButton();
        rad_2310 = new javax.swing.JRadioButton();
        rad_2311 = new javax.swing.JRadioButton();
        rad_2312 = new javax.swing.JRadioButton();
        rad_2313 = new javax.swing.JRadioButton();
        rad_2314 = new javax.swing.JRadioButton();
        rad_2315 = new javax.swing.JRadioButton();
        rad_2316 = new javax.swing.JRadioButton();
        rad_2317 = new javax.swing.JRadioButton();
        jLabel_322 = new javax.swing.JLabel();
        jPanel_323 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        rad_2318 = new javax.swing.JRadioButton();
        rad_2319 = new javax.swing.JRadioButton();
        jLabel_323 = new javax.swing.JLabel();
        jPanel_324 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        rad_2320 = new javax.swing.JRadioButton();
        rad_2321 = new javax.swing.JRadioButton();
        rad_2322 = new javax.swing.JRadioButton();
        rad_2323 = new javax.swing.JRadioButton();
        rad_2324 = new javax.swing.JRadioButton();
        rad_2325 = new javax.swing.JRadioButton();
        rad_2326 = new javax.swing.JRadioButton();
        rad_2327 = new javax.swing.JRadioButton();
        jLabel_324 = new javax.swing.JLabel();
        jPanel_325 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        rad_2328 = new javax.swing.JRadioButton();
        rad_2329 = new javax.swing.JRadioButton();
        jLabel_325 = new javax.swing.JLabel();
        jPanel_326 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        rad_2330 = new javax.swing.JRadioButton();
        rad_2331 = new javax.swing.JRadioButton();
        rad_2332 = new javax.swing.JRadioButton();
        rad_2333 = new javax.swing.JRadioButton();
        rad_2334 = new javax.swing.JRadioButton();
        jLabel_326 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanelSec_4 = new javax.swing.JPanel();
        jPanel_327 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        rad_2335 = new javax.swing.JRadioButton();
        rad_2336 = new javax.swing.JRadioButton();
        rad_2337 = new javax.swing.JRadioButton();
        rad_2338 = new javax.swing.JRadioButton();
        jLabel_327 = new javax.swing.JLabel();
        jPanel_328 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        rad_2339 = new javax.swing.JRadioButton();
        rad_2340 = new javax.swing.JRadioButton();
        rad_2341 = new javax.swing.JRadioButton();
        rad_2342 = new javax.swing.JRadioButton();
        rad_2343 = new javax.swing.JRadioButton();
        rad_2344 = new javax.swing.JRadioButton();
        jLabel_328 = new javax.swing.JLabel();
        jPanel_329 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        rad_2345 = new javax.swing.JRadioButton();
        rad_2346 = new javax.swing.JRadioButton();
        rad_2347 = new javax.swing.JRadioButton();
        rad_2348 = new javax.swing.JRadioButton();
        rad_2349 = new javax.swing.JRadioButton();
        rad_2350 = new javax.swing.JRadioButton();
        rad_2351 = new javax.swing.JRadioButton();
        rad_2352 = new javax.swing.JRadioButton();
        jLabel_329 = new javax.swing.JLabel();
        jPanel_330 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        rad_2353 = new javax.swing.JRadioButton();
        rad_2354 = new javax.swing.JRadioButton();
        rad_2355 = new javax.swing.JRadioButton();
        rad_2356 = new javax.swing.JRadioButton();
        rad_2357 = new javax.swing.JRadioButton();
        rad_2358 = new javax.swing.JRadioButton();
        rad_2359 = new javax.swing.JRadioButton();
        jLabel_330 = new javax.swing.JLabel();
        jPanel_331 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        rad_2360 = new javax.swing.JRadioButton();
        rad_2361 = new javax.swing.JRadioButton();
        rad_2362 = new javax.swing.JRadioButton();
        rad_2363 = new javax.swing.JRadioButton();
        jLabel_331 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanelSec_5 = new javax.swing.JPanel();
        jPanel_332 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        chk_2364 = new javax.swing.JCheckBox();
        chk_2365 = new javax.swing.JCheckBox();
        chk_2366 = new javax.swing.JCheckBox();
        chk_2367 = new javax.swing.JCheckBox();
        chk_2368 = new javax.swing.JCheckBox();
        jLabel_332 = new javax.swing.JLabel();
        jPanel_333 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        rad_2369 = new javax.swing.JRadioButton();
        rad_2370 = new javax.swing.JRadioButton();
        rad_2371 = new javax.swing.JRadioButton();
        rad_2372 = new javax.swing.JRadioButton();
        jLabel_333 = new javax.swing.JLabel();
        jPanel_334 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        rad_2373 = new javax.swing.JRadioButton();
        rad_2374 = new javax.swing.JRadioButton();
        rad_2375 = new javax.swing.JRadioButton();
        rad_2376 = new javax.swing.JRadioButton();
        jLabel_334 = new javax.swing.JLabel();
        jPanel_335 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        chk_2377 = new javax.swing.JCheckBox();
        chk_2378 = new javax.swing.JCheckBox();
        chk_2379 = new javax.swing.JCheckBox();
        jLabel_335 = new javax.swing.JLabel();
        jPanel_336 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        rad_2380 = new javax.swing.JRadioButton();
        rad_2381 = new javax.swing.JRadioButton();
        rad_2382 = new javax.swing.JRadioButton();
        rad_2383 = new javax.swing.JRadioButton();
        rad_2384 = new javax.swing.JRadioButton();
        jLabel_336 = new javax.swing.JLabel();
        jPanel_337 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        rad_2385 = new javax.swing.JRadioButton();
        rad_2386 = new javax.swing.JRadioButton();
        rad_2387 = new javax.swing.JRadioButton();
        rad_2388 = new javax.swing.JRadioButton();
        rad_2389 = new javax.swing.JRadioButton();
        jLabel_337 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanelSec_6 = new javax.swing.JPanel();
        jPanel_338 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        rad_2390 = new javax.swing.JRadioButton();
        rad_2391 = new javax.swing.JRadioButton();
        rad_2392 = new javax.swing.JRadioButton();
        rad_2393 = new javax.swing.JRadioButton();
        rad_2394 = new javax.swing.JRadioButton();
        rad_2395 = new javax.swing.JRadioButton();
        rad_2396 = new javax.swing.JRadioButton();
        rad_2397 = new javax.swing.JRadioButton();
        jLabel_338 = new javax.swing.JLabel();
        jPanel_339 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        rad_2398 = new javax.swing.JRadioButton();
        rad_2399 = new javax.swing.JRadioButton();
        rad_2400 = new javax.swing.JRadioButton();
        rad_2401 = new javax.swing.JRadioButton();
        rad_2402 = new javax.swing.JRadioButton();
        rad_2403 = new javax.swing.JRadioButton();
        rad_2404 = new javax.swing.JRadioButton();
        rad_2405 = new javax.swing.JRadioButton();
        jLabel_339 = new javax.swing.JLabel();
        jPanel_340 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        rad_2406 = new javax.swing.JRadioButton();
        rad_2407 = new javax.swing.JRadioButton();
        rad_2408 = new javax.swing.JRadioButton();
        rad_2409 = new javax.swing.JRadioButton();
        jLabel_340 = new javax.swing.JLabel();
        jPanel_341 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel_342 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        rad_2411 = new javax.swing.JRadioButton();
        rad_2412 = new javax.swing.JRadioButton();
        rad_2413 = new javax.swing.JRadioButton();
        rad_2414 = new javax.swing.JRadioButton();
        rad_2415 = new javax.swing.JRadioButton();
        jLabel_342 = new javax.swing.JLabel();
        jPanel_343 = new javax.swing.JPanel();
        rad_2416 = new javax.swing.JRadioButton();
        rad_2417 = new javax.swing.JRadioButton();
        rad_2418 = new javax.swing.JRadioButton();
        rad_2419 = new javax.swing.JRadioButton();
        rad_2420 = new javax.swing.JRadioButton();
        jLabel_343 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanel_344 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        rad_2421 = new javax.swing.JRadioButton();
        rad_2422 = new javax.swing.JRadioButton();
        rad_2423 = new javax.swing.JRadioButton();
        rad_2424 = new javax.swing.JRadioButton();
        rad_2425 = new javax.swing.JRadioButton();
        jLabel_344 = new javax.swing.JLabel();
        jPanel_345 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        rad_2426 = new javax.swing.JRadioButton();
        rad_2427 = new javax.swing.JRadioButton();
        rad_2428 = new javax.swing.JRadioButton();
        rad_2429 = new javax.swing.JRadioButton();
        rad_2430 = new javax.swing.JRadioButton();
        jLabel_345 = new javax.swing.JLabel();
        jPanel_346 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        rad_2431 = new javax.swing.JRadioButton();
        rad_2432 = new javax.swing.JRadioButton();
        rad_2433 = new javax.swing.JRadioButton();
        rad_2434 = new javax.swing.JRadioButton();
        rad_2435 = new javax.swing.JRadioButton();
        jLabel_346 = new javax.swing.JLabel();
        jPanel_347 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jPanel_348 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        rad_2437 = new javax.swing.JRadioButton();
        rad_2438 = new javax.swing.JRadioButton();
        rad_2439 = new javax.swing.JRadioButton();
        rad_2440 = new javax.swing.JRadioButton();
        rad_2441 = new javax.swing.JRadioButton();
        jLabel_348 = new javax.swing.JLabel();
        jPanel_349 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        rad_2442 = new javax.swing.JRadioButton();
        rad_2443 = new javax.swing.JRadioButton();
        rad_2444 = new javax.swing.JRadioButton();
        rad_2445 = new javax.swing.JRadioButton();
        rad_2446 = new javax.swing.JRadioButton();
        jLabel_349 = new javax.swing.JLabel();
        jPanel_350 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        rad_2447 = new javax.swing.JRadioButton();
        rad_2448 = new javax.swing.JRadioButton();
        rad_2449 = new javax.swing.JRadioButton();
        rad_2450 = new javax.swing.JRadioButton();
        rad_2451 = new javax.swing.JRadioButton();
        jLabel_350 = new javax.swing.JLabel();
        jPanel_351 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        rad_2452 = new javax.swing.JRadioButton();
        rad_2453 = new javax.swing.JRadioButton();
        rad_2454 = new javax.swing.JRadioButton();
        rad_2455 = new javax.swing.JRadioButton();
        rad_2456 = new javax.swing.JRadioButton();
        jLabel_351 = new javax.swing.JLabel();
        jPanel_352 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        rad_2457 = new javax.swing.JRadioButton();
        rad_2458 = new javax.swing.JRadioButton();
        rad_2459 = new javax.swing.JRadioButton();
        rad_2460 = new javax.swing.JRadioButton();
        rad_2461 = new javax.swing.JRadioButton();
        jLabel_352 = new javax.swing.JLabel();
        jPanel_353 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        rad_2462 = new javax.swing.JRadioButton();
        rad_2463 = new javax.swing.JRadioButton();
        rad_2464 = new javax.swing.JRadioButton();
        rad_2465 = new javax.swing.JRadioButton();
        rad_2466 = new javax.swing.JRadioButton();
        jLabel_353 = new javax.swing.JLabel();
        jButton_Sigueinte = new javax.swing.JButton();
        jButton_Atras = new javax.swing.JButton();
        jPanel_DatosPersonales = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_apellidos = new javax.swing.JTextField();
        jButton_activarEncuesta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prototipo encuesta");
        setIconImage(getIconImage());
        setLocationByPlatform(true);
        setResizable(false);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusLost(evt);
            }
        });

        jPanel_282.setName("282"); // NOI18N

        jLabel1.setText("<html><b>1.1. ¿Con quién vives?</b><br/>(selección múltiple)</html>");
        jLabel1.setName("1"); // NOI18N

        chk_1802.setText("Solo");
        chk_1802.setName("1802"); // NOI18N
        chk_1802.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1802ActionPerformed(evt);
            }
        });

        chk_1803.setText("Padre");
        chk_1803.setName("1803"); // NOI18N
        chk_1803.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1803ActionPerformed(evt);
            }
        });

        chk_1804.setText("Madre");
        chk_1804.setName("1804"); // NOI18N
        chk_1804.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1804ActionPerformed(evt);
            }
        });

        chk_1805.setText("Hermanas/os");
        chk_1805.setName("1805"); // NOI18N
        chk_1805.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1805ActionPerformed(evt);
            }
        });

        chk_1806.setText("Abuelas/os");
        chk_1806.setName("1806"); // NOI18N
        chk_1806.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1806ActionPerformed(evt);
            }
        });

        chk_1807.setText("Hija/o");
        chk_1807.setName("1807"); // NOI18N
        chk_1807.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1807ActionPerformed(evt);
            }
        });

        chk_1808.setText("Cónyuge o conviviente");
        chk_1808.setName("1808"); // NOI18N
        chk_1808.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1808ActionPerformed(evt);
            }
        });

        chk_1809.setText("Amiga/o");
        chk_1809.setName("1809"); // NOI18N
        chk_1809.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1809ActionPerformed(evt);
            }
        });

        chk_1810.setText("Otros");
        chk_1810.setName("1810"); // NOI18N
        chk_1810.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1810ActionPerformed(evt);
            }
        });

        chk_1811.setText("Me encuentro en situación de privación de libertad");
        chk_1811.setName("1811"); // NOI18N

        jLabel_282.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_282.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_282.setText("* Esta pregunta es obligatoria.");
        jLabel_282.setName("lbl_282"); // NOI18N

        javax.swing.GroupLayout jPanel_282Layout = new javax.swing.GroupLayout(jPanel_282);
        jPanel_282.setLayout(jPanel_282Layout);
        jPanel_282Layout.setHorizontalGroup(
            jPanel_282Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_282Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_282Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_282)
                    .addComponent(chk_1811)
                    .addComponent(chk_1810)
                    .addComponent(chk_1809)
                    .addComponent(chk_1808)
                    .addComponent(chk_1807)
                    .addComponent(chk_1806)
                    .addComponent(chk_1805)
                    .addComponent(chk_1804)
                    .addComponent(chk_1803)
                    .addComponent(chk_1802)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_282Layout.setVerticalGroup(
            jPanel_282Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_282Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_282)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_1802)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1803)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1804)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1805)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1806)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1807)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1808)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1809)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1810)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1811)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("1.- ¿Con quién vives?");

        jPanel_283.setName("283"); // NOI18N

        jLabel2.setText("<html><b>1.2. ¿Alguien en tu familia tiene discapacidad?</b><br/>(selecciona una opción )</html>");
        jLabel2.setName("1"); // NOI18N

        rad_1812.setText("Sí");
        rad_1812.setName("1812"); // NOI18N
        rad_1812.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1812ActionPerformed(evt);
            }
        });

        rad_1813.setText("No");
        rad_1813.setName("1813"); // NOI18N
        rad_1813.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1813ActionPerformed(evt);
            }
        });

        jLabel_283.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_283.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_283.setText("* Esta pregunta es obligatoria.");
        jLabel_283.setName("lbl_283"); // NOI18N

        javax.swing.GroupLayout jPanel_283Layout = new javax.swing.GroupLayout(jPanel_283);
        jPanel_283.setLayout(jPanel_283Layout);
        jPanel_283Layout.setHorizontalGroup(
            jPanel_283Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_283Layout.createSequentialGroup()
                .addGroup(jPanel_283Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_283Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel_283Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_1813)
                            .addComponent(rad_1812)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_283Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_283)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel_283Layout.setVerticalGroup(
            jPanel_283Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_283Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_283)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_1812)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1813)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_284.setName("284"); // NOI18N

        jLabel3.setText("<html><b>1.2.1. ¿Qué miembro de tu familia tiene discapacidad?</b><br/>(selección múltiple )</html>");
        jLabel3.setName("1"); // NOI18N

        chk_1814.setText("Yo");
        chk_1814.setName("1814"); // NOI18N

        chk_1815.setText("Padre");
        chk_1815.setName("1815"); // NOI18N

        chk_1816.setText("Madre");
        chk_1816.setName("1816"); // NOI18N

        chk_1817.setText("Hermanas/os");
        chk_1817.setName("1817"); // NOI18N

        chk_1818.setText("Abuelas/os");
        chk_1818.setName("1818"); // NOI18N

        chk_1819.setText("Hija/o");
        chk_1819.setName("1819"); // NOI18N

        chk_1820.setText("Cónyuge o conviviente");
        chk_1820.setName("1820"); // NOI18N

        chk_1821.setText("Otro");
        chk_1821.setName("1821"); // NOI18N

        jLabel_284.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_284.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_284.setText("* Esta pregunta es obligatoria.");
        jLabel_284.setName("lbl_284"); // NOI18N

        javax.swing.GroupLayout jPanel_284Layout = new javax.swing.GroupLayout(jPanel_284);
        jPanel_284.setLayout(jPanel_284Layout);
        jPanel_284Layout.setHorizontalGroup(
            jPanel_284Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_284Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_284Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_284)
                    .addComponent(chk_1821)
                    .addComponent(chk_1820)
                    .addComponent(chk_1819)
                    .addComponent(chk_1818)
                    .addComponent(chk_1817)
                    .addComponent(chk_1816)
                    .addComponent(chk_1815)
                    .addComponent(chk_1814)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_284Layout.setVerticalGroup(
            jPanel_284Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_284Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_284)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_1814)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1815)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1816)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1817)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1818)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1819)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1820)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1821)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_285.setName("285"); // NOI18N

        jLabel4.setText("<html><b>1.3. ¿Algún miembro de tu familia, incluyéndote a ti, <br/>ha estado en situación de movilidad humana<br/>(migración, retorno, refugio)?</b><br/>(selecciona una opción )</html>\n");
        jLabel4.setName("1"); // NOI18N

        rad_1822.setText("Sí");
        rad_1822.setName("1822"); // NOI18N
        rad_1822.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1822ActionPerformed(evt);
            }
        });

        rad_1823.setText("No");
        rad_1823.setName("1823"); // NOI18N
        rad_1823.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1823ActionPerformed(evt);
            }
        });

        jLabel_285.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_285.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_285.setText("* Esta pregunta es obligatoria.");
        jLabel_285.setName("lbl_285"); // NOI18N

        javax.swing.GroupLayout jPanel_285Layout = new javax.swing.GroupLayout(jPanel_285);
        jPanel_285.setLayout(jPanel_285Layout);
        jPanel_285Layout.setHorizontalGroup(
            jPanel_285Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_285Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_285Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_285)
                    .addComponent(rad_1822)
                    .addComponent(rad_1823)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_285Layout.setVerticalGroup(
            jPanel_285Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_285Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_285)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_1822)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1823)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_286.setName("286"); // NOI18N

        jLabel5.setText("<html><b>1.3.1. ¿Qué miembro de tu familia está en situación de movilidad humana?</b><br/> (selección múltiple)</html>\n\n");
        jLabel5.setName("1"); // NOI18N

        chk_1824.setText("Yo");
        chk_1824.setName("1824"); // NOI18N

        chk_1825.setText("Padre");
        chk_1825.setName("1825"); // NOI18N
        chk_1825.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1825ActionPerformed(evt);
            }
        });

        chk_1826.setText("Madre");
        chk_1826.setName("1826"); // NOI18N
        chk_1826.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1826ActionPerformed(evt);
            }
        });

        chk_1827.setText("Hermanas/os");
        chk_1827.setName("1827"); // NOI18N
        chk_1827.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1827ActionPerformed(evt);
            }
        });

        chk_1828.setText("Abuelas/os");
        chk_1828.setName("1828"); // NOI18N
        chk_1828.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1828ActionPerformed(evt);
            }
        });

        chk_1829.setText("Hija/o");
        chk_1829.setName("1829"); // NOI18N
        chk_1829.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1829ActionPerformed(evt);
            }
        });

        chk_1830.setText("Cónyuge o conviviente");
        chk_1830.setName("1830"); // NOI18N
        chk_1830.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1830ActionPerformed(evt);
            }
        });

        chk_1831.setText("Otro");
        chk_1831.setName("1831"); // NOI18N
        chk_1831.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1831ActionPerformed(evt);
            }
        });

        jLabel_286.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_286.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_286.setText("* Esta pregunta es obligatoria.");
        jLabel_286.setName("lbl_286"); // NOI18N

        javax.swing.GroupLayout jPanel_286Layout = new javax.swing.GroupLayout(jPanel_286);
        jPanel_286.setLayout(jPanel_286Layout);
        jPanel_286Layout.setHorizontalGroup(
            jPanel_286Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_286Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_286Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_286)
                    .addComponent(chk_1831)
                    .addComponent(chk_1830)
                    .addComponent(chk_1829)
                    .addComponent(chk_1828)
                    .addComponent(chk_1827)
                    .addComponent(chk_1826)
                    .addComponent(chk_1825)
                    .addComponent(chk_1824)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_286Layout.setVerticalGroup(
            jPanel_286Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_286Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_286)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_1824)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1825)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1826)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1827)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1828)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1829)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1830)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1831)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_287.setName("287"); // NOI18N

        jLabel6.setText("<html><b>1.3.2. ¿Qué tipo de movilidad?</b><br/>(selecciona una opción)</html>\n");
        jLabel6.setName("1"); // NOI18N

        rad_1832.setText("Migrante Interno");
        rad_1832.setName("1832"); // NOI18N
        rad_1832.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1832ActionPerformed(evt);
            }
        });

        rad_1833.setText("Migrante Internacional ");
        rad_1833.setName("1833"); // NOI18N
        rad_1833.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1833ActionPerformed(evt);
            }
        });

        rad_1834.setText("Migrante Retornado");
        rad_1834.setName("1834"); // NOI18N
        rad_1834.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1834ActionPerformed(evt);
            }
        });

        rad_1835.setText("Refugiado");
        rad_1835.setName("1835"); // NOI18N
        rad_1835.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1835ActionPerformed(evt);
            }
        });

        jLabel_287.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_287.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_287.setText("* Esta pregunta es obligatoria.");
        jLabel_287.setName("lbl_287"); // NOI18N

        javax.swing.GroupLayout jPanel_287Layout = new javax.swing.GroupLayout(jPanel_287);
        jPanel_287.setLayout(jPanel_287Layout);
        jPanel_287Layout.setHorizontalGroup(
            jPanel_287Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_287Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_287Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_287)
                    .addComponent(rad_1835)
                    .addComponent(rad_1834)
                    .addComponent(rad_1833)
                    .addComponent(rad_1832)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel_287Layout.setVerticalGroup(
            jPanel_287Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_287Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_287)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_1832)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1833)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1834)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1835)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_288.setName("288"); // NOI18N

        jLabel7.setText("<html><b>1.3.3. ¿A que país realizó la migración?</b><br/>(selecciona una opción)</html>\n");
        jLabel7.setName("1"); // NOI18N

        jLabel_288.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_288.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_288.setText("* Esta pregunta es obligatoria.");
        jLabel_288.setName("lbl_288"); // NOI18N

        jScrollPane7.setName("lista_288"); // NOI18N

        jList_288.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_288.setName("288"); // NOI18N
        jList_288.setVisibleRowCount(20);
        jScrollPane7.setViewportView(jList_288);

        javax.swing.GroupLayout jPanel_288Layout = new javax.swing.GroupLayout(jPanel_288);
        jPanel_288.setLayout(jPanel_288Layout);
        jPanel_288Layout.setHorizontalGroup(
            jPanel_288Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_288Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_288Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_288Layout.createSequentialGroup()
                        .addComponent(jLabel_288)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel_288Layout.createSequentialGroup()
                        .addComponent(jScrollPane7)
                        .addGap(85, 85, 85))
                    .addGroup(jPanel_288Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel_288Layout.setVerticalGroup(
            jPanel_288Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_288Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_288)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel_289.setName("289"); // NOI18N

        jLabel8.setText("<html><b>1.3.4. ¿Cuál fue el motivo principal?</b><br/>(selecciona una opción)</html>\n");
        jLabel8.setName("1"); // NOI18N

        rad_2085.setText("Trabajo");
        rad_2085.setName("2085"); // NOI18N

        rad_2086.setText("Estudios");
        rad_2086.setName("2086"); // NOI18N

        rad_2087.setText("Negocios");
        rad_2087.setName("2087"); // NOI18N

        rad_2088.setText("Reagrupación Familiar");
        rad_2088.setName("2088"); // NOI18N

        rad_2089.setText("Conflictos sociales");
        rad_2089.setName("2089"); // NOI18N

        rad_2090.setText("Desastres naturales");
        rad_2090.setName("2090"); // NOI18N

        rad_2091.setText("Persecución política");
        rad_2091.setName("2091"); // NOI18N

        jLabel_289.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_289.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_289.setText("* Esta pregunta es obligatoria.");
        jLabel_289.setName("lbl_289"); // NOI18N

        javax.swing.GroupLayout jPanel_289Layout = new javax.swing.GroupLayout(jPanel_289);
        jPanel_289.setLayout(jPanel_289Layout);
        jPanel_289Layout.setHorizontalGroup(
            jPanel_289Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_289Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_289Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_2091)
                    .addComponent(rad_2090)
                    .addComponent(rad_2089)
                    .addComponent(rad_2088)
                    .addComponent(rad_2087)
                    .addComponent(rad_2086)
                    .addComponent(rad_2085)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_289))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_289Layout.setVerticalGroup(
            jPanel_289Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_289Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_289)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2085)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2086)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2087)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2088)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2089)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2090)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2091)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_290.setName("290"); // NOI18N

        jLabel9.setText("<html><b>1.3.5. ¿Recibes algún beneficio económico de esta persona?</b><br/>(selecciona una opción)</html>\n");
        jLabel9.setName("1"); // NOI18N

        rad_2092.setText("Sí");
        rad_2092.setName("2092"); // NOI18N
        rad_2092.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2092ActionPerformed(evt);
            }
        });

        rad_2093.setText("No");
        rad_2093.setName("2093"); // NOI18N
        rad_2093.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2093ActionPerformed(evt);
            }
        });

        jLabel_290.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_290.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_290.setText("* Esta pregunta es obligatoria.");
        jLabel_290.setName("lbl_290"); // NOI18N

        javax.swing.GroupLayout jPanel_290Layout = new javax.swing.GroupLayout(jPanel_290);
        jPanel_290.setLayout(jPanel_290Layout);
        jPanel_290Layout.setHorizontalGroup(
            jPanel_290Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_290Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_290Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_2093)
                    .addComponent(rad_2092)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_290))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_290Layout.setVerticalGroup(
            jPanel_290Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_290Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_290)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2092)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2093)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_291.setName("291"); // NOI18N

        jLabel10.setText("<html><b>1.3.6. ¿Cuánto dinero en promedio recibes mensualmente<br/>de esta persona?</b><html>\n");
        jLabel10.setName("1"); // NOI18N

        txt_2094.setName("2094"); // NOI18N
        txt_2094.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_2094KeyTyped(evt);
            }
        });

        jLabel84.setText("Dólares");

        jLabel_291.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_291.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_291.setText("* Esta pregunta es obligatoria.");
        jLabel_291.setName("lbl_291"); // NOI18N

        javax.swing.GroupLayout jPanel_291Layout = new javax.swing.GroupLayout(jPanel_291);
        jPanel_291.setLayout(jPanel_291Layout);
        jPanel_291Layout.setHorizontalGroup(
            jPanel_291Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_291Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_291Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_291Layout.createSequentialGroup()
                        .addComponent(txt_2094, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel84))
                    .addComponent(jLabel_291))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_291Layout.setVerticalGroup(
            jPanel_291Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_291Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_291)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_291Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_2094, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_292.setName("292"); // NOI18N

        jLabel11.setText("<html><b>1.4. ¿Cómo se identifica tu padre según su cultura y costumbres?</b><br/>(selecciona una opción)</html>\n");
        jLabel11.setName("1"); // NOI18N

        rad_2095.setText("Indígena");
        rad_2095.setName("2095"); // NOI18N
        rad_2095.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2095ActionPerformed(evt);
            }
        });

        rad_2096.setText("Mestizo");
        rad_2096.setName("2096"); // NOI18N
        rad_2096.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2096ActionPerformed(evt);
            }
        });

        rad_2097.setText("Afroecuatoriano/afrodescendiente");
        rad_2097.setName("2097"); // NOI18N
        rad_2097.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2097ActionPerformed(evt);
            }
        });

        rad_2098.setText("Negro");
        rad_2098.setName("2098"); // NOI18N
        rad_2098.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2098ActionPerformed(evt);
            }
        });

        rad_2099.setText("Mulato");
        rad_2099.setName("2099"); // NOI18N
        rad_2099.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2099ActionPerformed(evt);
            }
        });

        rad_2100.setText("Montuvio");
        rad_2100.setName("2100"); // NOI18N
        rad_2100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2100ActionPerformed(evt);
            }
        });

        rad_2101.setText("Blanco");
        rad_2101.setName("2101"); // NOI18N
        rad_2101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2101ActionPerformed(evt);
            }
        });

        rad_2102.setText("No conozco a mi padre");
        rad_2102.setName("2102"); // NOI18N
        rad_2102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2102ActionPerformed(evt);
            }
        });

        jLabel_292.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_292.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_292.setText("* Esta pregunta es obligatoria.");
        jLabel_292.setName("lbl_292"); // NOI18N

        javax.swing.GroupLayout jPanel_292Layout = new javax.swing.GroupLayout(jPanel_292);
        jPanel_292.setLayout(jPanel_292Layout);
        jPanel_292Layout.setHorizontalGroup(
            jPanel_292Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_292Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_292Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_2102)
                    .addComponent(rad_2101)
                    .addComponent(rad_2100)
                    .addComponent(rad_2099)
                    .addComponent(rad_2098)
                    .addComponent(rad_2097)
                    .addComponent(rad_2096)
                    .addComponent(rad_2095)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_292))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_292Layout.setVerticalGroup(
            jPanel_292Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_292Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_292)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2095)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2096)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2097)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2098)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2099)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2100)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2101)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2102)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_293.setName("293"); // NOI18N

        jLabel12.setText("<html><b>1.4.1. ¿A cuál pueblo o nacionalidad pertenece?</b><br/>(selecciona una opción)</html>\n");
        jLabel12.setName("1"); // NOI18N

        rad_2103.setText("Awa");
        rad_2103.setName("2103"); // NOI18N

        rad_2104.setText("Achuar");
        rad_2104.setName("2104"); // NOI18N

        rad_2105.setText("Chachi");
        rad_2105.setName("2105"); // NOI18N

        rad_2106.setText("Cofan");
        rad_2106.setName("2106"); // NOI18N

        rad_2107.setText("Epera");
        rad_2107.setName("2107"); // NOI18N

        rad_2108.setText("Siona");
        rad_2108.setName("2108"); // NOI18N

        rad_2109.setText("Secoya");
        rad_2109.setName("2109"); // NOI18N

        rad_2110.setText("Shiwiar");
        rad_2110.setName("2110"); // NOI18N

        rad_2111.setText("Shuar");
        rad_2111.setName("2111"); // NOI18N

        rad_2112.setText("Tsachila");
        rad_2112.setName("2112"); // NOI18N

        rad_2113.setText("Waorani");
        rad_2113.setName("2113"); // NOI18N

        rad_2114.setText("Zapara");
        rad_2114.setName("2114"); // NOI18N

        rad_2115.setText("Andoa");
        rad_2115.setName("2115"); // NOI18N

        rad_2116.setText("Kichwa amazonia");
        rad_2116.setName("2116"); // NOI18N

        rad_2117.setText("Kichwa de la sierra");
        rad_2117.setName("2117"); // NOI18N

        jLabel13.setText("Pueblos");

        rad_2118.setText("Pastos");
        rad_2118.setName("2118"); // NOI18N

        rad_2119.setText("Natabuela");
        rad_2119.setName("2119"); // NOI18N

        rad_2120.setText("Otavalo");
        rad_2120.setName("2120"); // NOI18N

        rad_2121.setText("Karanki");
        rad_2121.setName("2121"); // NOI18N

        rad_2122.setText("Kayambi");
        rad_2122.setName("2122"); // NOI18N

        rad_2123.setText("Kitukara");
        rad_2123.setName("2123"); // NOI18N

        rad_2124.setText("Panzaleo");
        rad_2124.setName("2124"); // NOI18N

        rad_2125.setText("Chibuleo");
        rad_2125.setName("2125"); // NOI18N

        rad_2126.setText("Salasaka");
        rad_2126.setName("2126"); // NOI18N

        rad_2127.setText("Kisapincha");
        rad_2127.setName("2127"); // NOI18N

        rad_2128.setText("Tomabela");
        rad_2128.setName("2128"); // NOI18N

        rad_2129.setText("Waranka");
        rad_2129.setName("2129"); // NOI18N

        rad_2130.setText("Puruhá");
        rad_2130.setName("2130"); // NOI18N

        jLabel14.setText("Nacionalidades ");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel_293.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_293.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_293.setText("* Esta pregunta es obligatoria.");
        jLabel_293.setName("lbl_293"); // NOI18N

        javax.swing.GroupLayout jPanel_293Layout = new javax.swing.GroupLayout(jPanel_293);
        jPanel_293.setLayout(jPanel_293Layout);
        jPanel_293Layout.setHorizontalGroup(
            jPanel_293Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_293Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_293Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_293Layout.createSequentialGroup()
                        .addGroup(jPanel_293Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_293)
                            .addComponent(rad_2105)
                            .addComponent(rad_2106)
                            .addComponent(rad_2107)
                            .addComponent(rad_2108)
                            .addComponent(rad_2109)
                            .addComponent(rad_2110)
                            .addComponent(rad_2111)
                            .addComponent(rad_2112)
                            .addComponent(rad_2113)
                            .addComponent(rad_2114)
                            .addComponent(rad_2115)
                            .addComponent(rad_2117)
                            .addGroup(jPanel_293Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_293Layout.createSequentialGroup()
                                    .addComponent(rad_2103)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13))
                                .addComponent(rad_2116, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(rad_2104))
                        .addGap(49, 49, 49)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_293Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_293Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rad_2119, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rad_2127, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rad_2120)
                                .addComponent(rad_2121)
                                .addComponent(rad_2122)
                                .addComponent(rad_2123)
                                .addComponent(rad_2124)
                                .addComponent(rad_2125)
                                .addComponent(rad_2126)
                                .addComponent(rad_2128)
                                .addComponent(rad_2129)
                                .addComponent(rad_2130))
                            .addGroup(jPanel_293Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel14))
                            .addComponent(rad_2118)))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel_293Layout.setVerticalGroup(
            jPanel_293Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_293Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel_293Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_293Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_293Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel_293Layout.createSequentialGroup()
                                .addComponent(jLabel_293)
                                .addGroup(jPanel_293Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_293Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                        .addComponent(rad_2103)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rad_2104)
                                        .addGap(3, 3, 3))
                                    .addGroup(jPanel_293Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(rad_2105)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rad_2106)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_2107)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rad_2108)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_2109)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_2110)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_2111)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_2112)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_2113)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_2114)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_2115)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_2116)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_2117)))
                        .addGap(7, 7, 7))
                    .addGroup(jPanel_293Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2118)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2119)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2120)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_2121)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2122)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_2123)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2124)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2125)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2126)
                        .addGap(3, 3, 3)
                        .addComponent(rad_2127)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2128)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2129)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2130)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel_294.setName("294"); // NOI18N

        jLabel15.setText("<html><b>1.5. ¿Cómo se identifica  tu madre según su cultura y costumbres ?</b><br/>(selecciona una opción)</html>\n");
        jLabel15.setName("1"); // NOI18N

        rad_2131.setText("Indígena");
        rad_2131.setName("2131"); // NOI18N
        rad_2131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2131ActionPerformed(evt);
            }
        });

        rad_2132.setText("Mestizo");
        rad_2132.setName("2132"); // NOI18N
        rad_2132.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2132ActionPerformed(evt);
            }
        });

        rad_2133.setText("Afroecuatoriano/afrodescendiente");
        rad_2133.setName("2133"); // NOI18N
        rad_2133.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2133ActionPerformed(evt);
            }
        });

        rad_2134.setText("Negro");
        rad_2134.setName("2134"); // NOI18N
        rad_2134.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2134ActionPerformed(evt);
            }
        });

        rad_2135.setText("Mulato");
        rad_2135.setName("2135"); // NOI18N
        rad_2135.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2135ActionPerformed(evt);
            }
        });

        rad_2136.setText("Montuvio");
        rad_2136.setName("2136"); // NOI18N
        rad_2136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2136ActionPerformed(evt);
            }
        });

        rad_2137.setText("Blanco");
        rad_2137.setName("2137"); // NOI18N
        rad_2137.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2137ActionPerformed(evt);
            }
        });

        rad_2138.setText("No conozco a mi madre");
        rad_2138.setName("2138"); // NOI18N
        rad_2138.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2138ActionPerformed(evt);
            }
        });

        jLabel_294.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_294.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_294.setText("* Esta pregunta es obligatoria.");
        jLabel_294.setName("lbl_294"); // NOI18N

        javax.swing.GroupLayout jPanel_294Layout = new javax.swing.GroupLayout(jPanel_294);
        jPanel_294.setLayout(jPanel_294Layout);
        jPanel_294Layout.setHorizontalGroup(
            jPanel_294Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_294Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_294Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_2138)
                    .addComponent(rad_2137)
                    .addComponent(rad_2136)
                    .addComponent(rad_2135)
                    .addComponent(rad_2134)
                    .addComponent(rad_2133)
                    .addComponent(rad_2132)
                    .addComponent(rad_2131)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_294))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_294Layout.setVerticalGroup(
            jPanel_294Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_294Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_294)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2131)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2132)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2133)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2134)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2135)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2136)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2137)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2138)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_295.setName("295"); // NOI18N

        jLabel16.setText("Pueblos");

        rad_2153.setText("Kichwa de la sierra");
        rad_2153.setName("2153"); // NOI18N

        rad_2152.setText("Kichwa amazonia");
        rad_2152.setName("2152"); // NOI18N
        rad_2152.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2152ActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        rad_2151.setText("Andoa");
        rad_2151.setName("2151"); // NOI18N

        rad_2165.setText("Waranka");
        rad_2165.setName("2165"); // NOI18N

        rad_2164.setText("Tomabela");
        rad_2164.setName("2164"); // NOI18N

        jLabel17.setText("Nacionalidades ");

        rad_2166.setText("Puruhá");
        rad_2166.setName("2166"); // NOI18N

        rad_2145.setText("Secoya");
        rad_2145.setName("2145"); // NOI18N

        rad_2146.setText("Shiwiar");
        rad_2146.setName("2146"); // NOI18N

        rad_2149.setText("Waorani");
        rad_2149.setName("2149"); // NOI18N

        rad_2150.setText("Zapara");
        rad_2150.setName("2150"); // NOI18N

        rad_2147.setText("Shuar");
        rad_2147.setName("2147"); // NOI18N

        rad_2148.setText("Tsachila");
        rad_2148.setName("2148"); // NOI18N

        rad_2162.setText("Salasaka");
        rad_2162.setName("2162"); // NOI18N

        rad_2161.setText("Chibuleo");
        rad_2161.setName("2161"); // NOI18N

        rad_2144.setText("Siona");
        rad_2144.setName("2144"); // NOI18N

        rad_2163.setText("Kisapincha");
        rad_2163.setName("2163"); // NOI18N

        rad_2141.setText("Chachi");
        rad_2141.setName("2141"); // NOI18N

        rad_2140.setText("Achuar");
        rad_2140.setName("2140"); // NOI18N

        rad_2143.setText("Epera");
        rad_2143.setName("2143"); // NOI18N

        rad_2142.setText("Cofan");
        rad_2142.setName("2142"); // NOI18N

        rad_2154.setText("Pastos");
        rad_2154.setName("2154"); // NOI18N

        jLabel18.setText("<html><b>1.5.1. ¿A cuál pueblo o nacionalidad pertenece?</b><br/>(selecciona una opción)</html>\n");
        jLabel18.setName("1"); // NOI18N

        rad_2155.setText("Natabuela");
        rad_2155.setName("2155"); // NOI18N

        rad_2139.setText("Awa");
        rad_2139.setName("2139"); // NOI18N

        rad_2156.setText("Otavalo");
        rad_2156.setName("2156"); // NOI18N

        rad_2157.setText("Karanki");
        rad_2157.setName("2157"); // NOI18N

        rad_2158.setText("Kayambi");
        rad_2158.setName("2158"); // NOI18N

        rad_2159.setText("Kitukara");
        rad_2159.setName("2159"); // NOI18N

        rad_2160.setText("Panzaleo");
        rad_2160.setName("2160"); // NOI18N

        jLabel_295.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_295.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_295.setText("* Esta pregunta es obligatoria.");
        jLabel_295.setName("lbl_294"); // NOI18N

        javax.swing.GroupLayout jPanel_295Layout = new javax.swing.GroupLayout(jPanel_295);
        jPanel_295.setLayout(jPanel_295Layout);
        jPanel_295Layout.setHorizontalGroup(
            jPanel_295Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_295Layout.createSequentialGroup()
                .addGroup(jPanel_295Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_295Layout.createSequentialGroup()
                        .addGroup(jPanel_295Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2152)
                            .addGroup(jPanel_295Layout.createSequentialGroup()
                                .addComponent(rad_2139)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addComponent(rad_2141)
                            .addComponent(rad_2142)
                            .addComponent(rad_2143)
                            .addComponent(rad_2144)
                            .addComponent(rad_2145)
                            .addComponent(rad_2146)
                            .addComponent(rad_2147)
                            .addComponent(rad_2148)
                            .addComponent(rad_2149)
                            .addComponent(rad_2150)
                            .addComponent(rad_2151)
                            .addComponent(rad_2153)
                            .addGroup(jPanel_295Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_295))
                            .addComponent(rad_2140))
                        .addGap(55, 55, 55)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_295Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_295Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rad_2155, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rad_2163, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rad_2156)
                                .addComponent(rad_2157)
                                .addComponent(rad_2158)
                                .addComponent(rad_2159)
                                .addComponent(rad_2160)
                                .addComponent(rad_2161)
                                .addComponent(rad_2162)
                                .addComponent(rad_2164)
                                .addComponent(rad_2165)
                                .addComponent(rad_2166))
                            .addGroup(jPanel_295Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel17))
                            .addComponent(rad_2154)))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_295Layout.setVerticalGroup(
            jPanel_295Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_295Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_295Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_295Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel_295Layout.createSequentialGroup()
                        .addComponent(jLabel_295)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_2139)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2140)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2141)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_2142)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2143)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_2144)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2145)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2146)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2147)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2148)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2149)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2150)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2151)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2152)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2153))
                    .addGroup(jPanel_295Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2154)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2155)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2156)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_2157)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2158)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_2159)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2160)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2161)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2162)
                        .addGap(3, 3, 3)
                        .addComponent(rad_2163)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2164)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2165)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_2166)
                        .addContainerGap())))
        );

        jPanel_296.setName("296"); // NOI18N

        jLabel21.setText("<html><b>1.6. ¿Qué idioma habla como lengua principal tu padre?</b><br/>(selecciona una opción)</html>\n");
        jLabel21.setName("1"); // NOI18N

        rad_2167.setText("Español");
        rad_2167.setName("2167"); // NOI18N
        rad_2167.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2167ActionPerformed(evt);
            }
        });

        rad_2168.setText("Lengua indígena");
        rad_2168.setName("2168"); // NOI18N
        rad_2168.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2168ActionPerformed(evt);
            }
        });

        rad_2169.setText("Lengua extranjera");
        rad_2169.setName("2169"); // NOI18N
        rad_2169.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2169ActionPerformed(evt);
            }
        });

        rad_2170.setText("No habla (lenguaje de señas)");
        rad_2170.setName("2170"); // NOI18N
        rad_2170.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2170ActionPerformed(evt);
            }
        });

        jLabel_296.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_296.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_296.setText("* Esta pregunta es obligatoria.");
        jLabel_296.setName("lbl_296"); // NOI18N

        javax.swing.GroupLayout jPanel_296Layout = new javax.swing.GroupLayout(jPanel_296);
        jPanel_296.setLayout(jPanel_296Layout);
        jPanel_296Layout.setHorizontalGroup(
            jPanel_296Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_296Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_296Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_2170)
                    .addComponent(rad_2169)
                    .addComponent(rad_2168)
                    .addComponent(rad_2167)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_296))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_296Layout.setVerticalGroup(
            jPanel_296Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_296Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_296)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2167)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2168)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2169)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2170)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_297.setName("297"); // NOI18N

        jLabel22.setText("<html><b>1.7. ¿Qué idioma habla como lengua principal tu madre?</b><br/>(selecciona una opción)</html>\n");
        jLabel22.setName("1"); // NOI18N

        rad_2171.setText("Español");
        rad_2171.setName("2171"); // NOI18N
        rad_2171.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2171ActionPerformed(evt);
            }
        });

        rad_2172.setText("Lengua indígena");
        rad_2172.setName("2172"); // NOI18N
        rad_2172.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2172ActionPerformed(evt);
            }
        });

        rad_2173.setText("Lengua extranjera");
        rad_2173.setName("2173"); // NOI18N
        rad_2173.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2173ActionPerformed(evt);
            }
        });

        rad_2174.setText("No habla (lenguaje de señas)");
        rad_2174.setName("2174"); // NOI18N
        rad_2174.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2174ActionPerformed(evt);
            }
        });

        jLabel_297.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_297.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_297.setText("* Esta pregunta es obligatoria.");
        jLabel_297.setName("lbl_297"); // NOI18N

        javax.swing.GroupLayout jPanel_297Layout = new javax.swing.GroupLayout(jPanel_297);
        jPanel_297.setLayout(jPanel_297Layout);
        jPanel_297Layout.setHorizontalGroup(
            jPanel_297Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_297Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_297Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_2174)
                    .addComponent(rad_2173)
                    .addComponent(rad_2172)
                    .addComponent(rad_2171)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_297))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_297Layout.setVerticalGroup(
            jPanel_297Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_297Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_297)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2171)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2172)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2173)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2174)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_356.setName("356"); // NOI18N

        jLabel42.setText("<html><b>1.6.1 ¿Cual es la lengua indígena de tu padre?</b><br/>(selecciona una opción)</html>\n");
        jLabel42.setName("1"); // NOI18N

        jLabel_356.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_356.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_356.setText("* Esta pregunta es obligatoria.");
        jLabel_356.setName("lbl_356"); // NOI18N

        jScrollPane8.setName("lista_356"); // NOI18N

        jList_356.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_356.setName("288"); // NOI18N
        jList_356.setVisibleRowCount(20);
        jScrollPane8.setViewportView(jList_356);

        javax.swing.GroupLayout jPanel_356Layout = new javax.swing.GroupLayout(jPanel_356);
        jPanel_356.setLayout(jPanel_356Layout);
        jPanel_356Layout.setHorizontalGroup(
            jPanel_356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_356Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel_356, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_356Layout.setVerticalGroup(
            jPanel_356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_356Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_356)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        jPanel_360.setName("360"); // NOI18N

        jLabel86.setText("<html><b>1.6.1 ¿Cual es la lengua extranjera de tu padre?</b><br/>(selecciona una opción)</html>\n");
        jLabel86.setName("1"); // NOI18N

        jLabel_360.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_360.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_360.setText("* Esta pregunta es obligatoria.");
        jLabel_360.setName("lbl_360"); // NOI18N

        jScrollPane9.setName("lista_360"); // NOI18N

        jList_360.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_360.setName("288"); // NOI18N
        jList_360.setVisibleRowCount(20);
        jScrollPane9.setViewportView(jList_360);

        javax.swing.GroupLayout jPanel_360Layout = new javax.swing.GroupLayout(jPanel_360);
        jPanel_360.setLayout(jPanel_360Layout);
        jPanel_360Layout.setHorizontalGroup(
            jPanel_360Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_360Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_360Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel86)
                    .addComponent(jLabel_360, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_360Layout.setVerticalGroup(
            jPanel_360Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_360Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_360)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel_358.setName("358"); // NOI18N

        jLabel87.setText("<html><b>1.7.1 ¿Cual es la lengua indígena de tu madre?</b><br/>(selecciona una opción)</html>\n");
        jLabel87.setName("1"); // NOI18N

        jLabel_358.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_358.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_358.setText("* Esta pregunta es obligatoria.");
        jLabel_358.setName("lbl_358"); // NOI18N

        jScrollPane10.setName("lista_358"); // NOI18N

        jList_358.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_358.setName("358"); // NOI18N
        jList_358.setVisibleRowCount(20);
        jScrollPane10.setViewportView(jList_358);

        javax.swing.GroupLayout jPanel_358Layout = new javax.swing.GroupLayout(jPanel_358);
        jPanel_358.setLayout(jPanel_358Layout);
        jPanel_358Layout.setHorizontalGroup(
            jPanel_358Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_358Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_358Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane10)
                    .addComponent(jLabel87)
                    .addComponent(jLabel_358, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_358Layout.setVerticalGroup(
            jPanel_358Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_358Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_358)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel_362.setName("362"); // NOI18N

        jLabel88.setText("<html><b>1.7.1 ¿Cual es la lengua extranjera de tu madre?</b><br/>(selecciona una opción)</html>\n");
        jLabel88.setName("1"); // NOI18N

        jLabel_362.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_362.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_362.setText("* Esta pregunta es obligatoria.");
        jLabel_362.setName("lbl_362"); // NOI18N

        jScrollPane11.setName("lista_362"); // NOI18N

        jList_362.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_362.setName("362"); // NOI18N
        jList_362.setVisibleRowCount(20);
        jScrollPane11.setViewportView(jList_362);

        javax.swing.GroupLayout jPanel_362Layout = new javax.swing.GroupLayout(jPanel_362);
        jPanel_362.setLayout(jPanel_362Layout);
        jPanel_362Layout.setHorizontalGroup(
            jPanel_362Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_362Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_362Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane11)
                    .addComponent(jLabel88)
                    .addComponent(jLabel_362, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_362Layout.setVerticalGroup(
            jPanel_362Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_362Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_362)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanelSec_1Layout = new javax.swing.GroupLayout(jPanelSec_1);
        jPanelSec_1.setLayout(jPanelSec_1Layout);
        jPanelSec_1Layout.setHorizontalGroup(
            jPanelSec_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSec_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_293, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSec_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel_358, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_295, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_292, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel_291, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSec_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel_290, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_289, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_288, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel_287, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel_286, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_285, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel_284, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel_282, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel_283, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel_294, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel_296, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_297, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_356, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_360, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_362, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanelSec_1Layout.setVerticalGroup(
            jPanelSec_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel_282, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_283, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_284, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_285, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_286, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_287, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_288, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_289, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_290, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_291, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_292, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_293, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_294, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_295, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel_296, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_356, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_360, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_297, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_358, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_362, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setViewportView(jPanelSec_1);

        jTabbedPane1.addTab("INFORMACIÓN FAMILIAR", jScrollPane1);
        jScrollPane1.getAccessibleContext().setAccessibleParent(jTabbedPane1);

        jPanel_298.setName("298"); // NOI18N

        jLabel19.setText("<html><b>2.1. Indica las características de la vivienda en la que habitas.</b><br/>(selecciona una opción)</html>");
        jLabel19.setName("1"); // NOI18N

        rad_2175.setText("Suite de lujo");
        rad_2175.setName("2175"); // NOI18N
        rad_2175.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2175ActionPerformed(evt);
            }
        });

        rad_2176.setText("Cuarto (s) en casa de inquilinato");
        rad_2176.setName("2176"); // NOI18N
        rad_2176.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2176ActionPerformed(evt);
            }
        });

        rad_2177.setText("Departamento en casa o edificio");
        rad_2177.setName("2177"); // NOI18N
        rad_2177.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2177ActionPerformed(evt);
            }
        });

        rad_2178.setText("Casa/Villa");
        rad_2178.setName("2178"); // NOI18N
        rad_2178.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2178ActionPerformed(evt);
            }
        });

        rad_2179.setText("Mediagua");
        rad_2179.setName("2179"); // NOI18N
        rad_2179.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2179ActionPerformed(evt);
            }
        });

        rad_2180.setText("Rancho");
        rad_2180.setName("2180"); // NOI18N
        rad_2180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2180ActionPerformed(evt);
            }
        });

        rad_2181.setText("Choza/Covacha/Otro");
        rad_2181.setName("2181"); // NOI18N
        rad_2181.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2181ActionPerformed(evt);
            }
        });

        rad_2182.setText("Vivienda colectiva");
        rad_2182.setName("2182"); // NOI18N
        rad_2182.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2182ActionPerformed(evt);
            }
        });

        jLabel_298.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_298.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_298.setText("* Esta pregunta es obligatoria.");
        jLabel_298.setName("lbl_298"); // NOI18N

        javax.swing.GroupLayout jPanel_298Layout = new javax.swing.GroupLayout(jPanel_298);
        jPanel_298.setLayout(jPanel_298Layout);
        jPanel_298Layout.setHorizontalGroup(
            jPanel_298Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_298Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_298Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_298)
                    .addComponent(rad_2182)
                    .addComponent(rad_2181)
                    .addComponent(rad_2180)
                    .addComponent(rad_2179)
                    .addComponent(rad_2178)
                    .addComponent(rad_2177)
                    .addComponent(rad_2176)
                    .addComponent(rad_2175)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_298Layout.setVerticalGroup(
            jPanel_298Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_298Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_298)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2175)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2176)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2177)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2178)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2179)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2180)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2181)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2182)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_299.setName("299"); // NOI18N

        jLabel25.setText("<html><b>2.1.1. ¿Qué tipo de vivienda colectiva?</b><br/>(selecciona una opción)</html>");
        jLabel25.setName("1"); // NOI18N

        rad_2183.setText("Hotel, pensión, residencial u hospital");
        rad_2183.setName("2183"); // NOI18N
        rad_2183.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2183ActionPerformed(evt);
            }
        });

        rad_2184.setText("Cuartel Militar, Policial o Bomberos");
        rad_2184.setName("2184"); // NOI18N
        rad_2184.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2184ActionPerformed(evt);
            }
        });

        rad_2185.setText("Centro de rehabilitación social/Cárcel");
        rad_2185.setName("2185"); // NOI18N
        rad_2185.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2185ActionPerformed(evt);
            }
        });

        rad_2186.setText("Centro de acogida y protección para niños y niñas");
        rad_2186.setName("2186"); // NOI18N
        rad_2186.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2186ActionPerformed(evt);
            }
        });

        rad_2187.setText("Hospital, clínica");
        rad_2187.setName("2187"); // NOI18N
        rad_2187.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2187ActionPerformed(evt);
            }
        });

        rad_2188.setText("Convento o institución religiosa");
        rad_2188.setName("2188"); // NOI18N
        rad_2188.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2188ActionPerformed(evt);
            }
        });

        rad_2189.setText("Orfanato");
        rad_2189.setName("2189"); // NOI18N
        rad_2189.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2189ActionPerformed(evt);
            }
        });

        rad_2190.setText("Otra vivienda colectiva");
        rad_2190.setName("2190"); // NOI18N
        rad_2190.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2190ActionPerformed(evt);
            }
        });

        jLabel_299.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_299.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_299.setText("* Esta pregunta es obligatoria.");
        jLabel_299.setName("lbl_299"); // NOI18N

        javax.swing.GroupLayout jPanel_299Layout = new javax.swing.GroupLayout(jPanel_299);
        jPanel_299.setLayout(jPanel_299Layout);
        jPanel_299Layout.setHorizontalGroup(
            jPanel_299Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_299Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_299Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_299)
                    .addComponent(rad_2190)
                    .addComponent(rad_2189)
                    .addComponent(rad_2188)
                    .addComponent(rad_2187)
                    .addComponent(rad_2186)
                    .addComponent(rad_2185)
                    .addComponent(rad_2184)
                    .addComponent(rad_2183)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_299Layout.setVerticalGroup(
            jPanel_299Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_299Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_299)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2183)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2184)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2185)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2186)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2187)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2188)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2189)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2190)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_300.setName("300"); // NOI18N

        jLabel26.setText("<html><b>2.2. Número de miembros de tu hogar incluyéndote a ti </b><br/>(Se les considera Miembros de Hogar a los residentes habituales presentes en el momento<br/>de la encuesta que viven permanentemente en el hogar, es decir que duermen la mayor<br/>parte del tiempo en tu hogar)</html>");
        jLabel26.setName("1"); // NOI18N

        txt_2191.setName("2191"); // NOI18N
        txt_2191.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_2191KeyTyped(evt);
            }
        });

        jLabel27.setText("personas");

        jLabel_300.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_300.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_300.setText("* Esta pregunta es obligatoria.");
        jLabel_300.setName("lbl_300"); // NOI18N

        javax.swing.GroupLayout jPanel_300Layout = new javax.swing.GroupLayout(jPanel_300);
        jPanel_300.setLayout(jPanel_300Layout);
        jPanel_300Layout.setHorizontalGroup(
            jPanel_300Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_300Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_300Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_300)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_300Layout.createSequentialGroup()
                        .addComponent(txt_2191, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_300Layout.setVerticalGroup(
            jPanel_300Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_300Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_300)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_300Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_2191, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(7, 7, 7))
        );

        jPanel_301.setName("301"); // NOI18N

        jLabel28.setText("<html><b>2.3. Número de cuartos exclusivos  para dormir que tiene la vivienda</b></html>");
        jLabel28.setName("1"); // NOI18N

        txt_2192.setName("2192"); // NOI18N
        txt_2192.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_2192KeyTyped(evt);
            }
        });

        jLabel29.setText("cuartos");

        jLabel_301.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_301.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_301.setText("* Esta pregunta es obligatoria.");
        jLabel_301.setName("lbl_301"); // NOI18N

        javax.swing.GroupLayout jPanel_301Layout = new javax.swing.GroupLayout(jPanel_301);
        jPanel_301.setLayout(jPanel_301Layout);
        jPanel_301Layout.setHorizontalGroup(
            jPanel_301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_301Layout.createSequentialGroup()
                .addGroup(jPanel_301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_301Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_301)
                            .addGroup(jPanel_301Layout.createSequentialGroup()
                                .addComponent(txt_2192, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29))))
                    .addGroup(jPanel_301Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_301Layout.setVerticalGroup(
            jPanel_301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_301Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_301)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_2192, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(7, 7, 7))
        );

        jPanel_302.setName("302"); // NOI18N

        jLabel30.setText("<html><b>2.4. ¿Dónde está localizada tu vivienda?</b><br/>(selecciona una opción)</html>");
        jLabel30.setName("1"); // NOI18N

        rad_2193.setText("<html>área urbana (Es aquella en la cual se permiten usos urbanos y cuentan, o se hallan<br/>dentro del radio de servicio de infraestructura de: agua, luz eléctrica, aseo de calles<br/>y de otros de naturaleza semejante)</html>");
        rad_2193.setName("2193"); // NOI18N

        rad_2194.setText("<html>área rural (Es una extensión razonable de territorio conformada por localidades<br/>identificadas por un nombre donde se encuentra un asentamiento de viviendas las<br/>mismas que pueden estar dispersas o agrupadas)</html>");
        rad_2194.setName("2194"); // NOI18N

        jLabel_302.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_302.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_302.setText("* Esta pregunta es obligatoria.");
        jLabel_302.setName("lbl_302"); // NOI18N

        javax.swing.GroupLayout jPanel_302Layout = new javax.swing.GroupLayout(jPanel_302);
        jPanel_302.setLayout(jPanel_302Layout);
        jPanel_302Layout.setHorizontalGroup(
            jPanel_302Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_302Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_302Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2193, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2194, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_302))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_302Layout.setVerticalGroup(
            jPanel_302Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_302Layout.createSequentialGroup()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_302)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2193, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2194, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_303.setName("303"); // NOI18N

        jLabel31.setText("<html><b>2.5. Selecciona el material predominante de las paredes exteriores de la vivienda.</b><br/>(selecciona una opción)</html>");
        jLabel31.setName("1"); // NOI18N

        rad_2195.setText("Hormigón");
        rad_2195.setName("2195"); // NOI18N

        rad_2196.setText("Ladrillo o bloque");
        rad_2196.setName("2196"); // NOI18N

        rad_2197.setText("Adobe o tapia");
        rad_2197.setName("2197"); // NOI18N

        rad_2198.setText("Caña revestida o bahareque/Madera");
        rad_2198.setName("2198"); // NOI18N

        rad_2199.setText("Caña no revestida/otros materiales");
        rad_2199.setName("2199"); // NOI18N

        jLabel_303.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_303.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_303.setText("* Esta pregunta es obligatoria.");
        jLabel_303.setName("lbl_303"); // NOI18N

        javax.swing.GroupLayout jPanel_303Layout = new javax.swing.GroupLayout(jPanel_303);
        jPanel_303.setLayout(jPanel_303Layout);
        jPanel_303Layout.setHorizontalGroup(
            jPanel_303Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_303Layout.createSequentialGroup()
                .addGroup(jPanel_303Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_303Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_303Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2198)
                            .addComponent(rad_2197)
                            .addComponent(rad_2196)
                            .addComponent(rad_2195)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2199)))
                    .addGroup(jPanel_303Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_303)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_303Layout.setVerticalGroup(
            jPanel_303Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_303Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_303)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2195)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2196)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2197)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rad_2198)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rad_2199)
                .addContainerGap())
        );

        jPanel_304.setName("304"); // NOI18N

        jLabel32.setText("<html><b>2.6. Selecciona el material predominante del piso de la vivienda.</b><br/>(selecciona una opción)</html>");
        jLabel32.setName("1"); // NOI18N

        rad_2200.setText("Duela, parquet, tablón o piso flotante");
        rad_2200.setName("2200"); // NOI18N

        rad_2201.setText("Cerámica, baldosa, vinil o marmetón ");
        rad_2201.setName("2201"); // NOI18N

        rad_2202.setText("Ladrillo o cemento");
        rad_2202.setName("2202"); // NOI18N

        rad_2203.setText("Tabla sin tratar ");
        rad_2203.setName("2203"); // NOI18N

        rad_2204.setText("Tierra/Caña/Otros materiales ");
        rad_2204.setName("2204"); // NOI18N

        jLabel_304.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_304.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_304.setText("* Esta pregunta es obligatoria.");
        jLabel_304.setName("lbl_304"); // NOI18N

        javax.swing.GroupLayout jPanel_304Layout = new javax.swing.GroupLayout(jPanel_304);
        jPanel_304.setLayout(jPanel_304Layout);
        jPanel_304Layout.setHorizontalGroup(
            jPanel_304Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_304Layout.createSequentialGroup()
                .addGroup(jPanel_304Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_304Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_304Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2203)
                            .addComponent(rad_2202)
                            .addComponent(rad_2201)
                            .addComponent(rad_2200)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2204)))
                    .addGroup(jPanel_304Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_304)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_304Layout.setVerticalGroup(
            jPanel_304Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_304Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_304)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2200)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2201)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2202)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rad_2203)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rad_2204)
                .addContainerGap())
        );

        jPanel_305.setName("305"); // NOI18N

        jLabel33.setText("<html><b>2.7. El tipo de servicio higiénico con que cuenta tu vivienda es: </b><br/>(selecciona una opción)</html>");
        jLabel33.setName("1"); // NOI18N

        rad_2205.setText("No tiene");
        rad_2205.setName("2205"); // NOI18N

        rad_2206.setText("Letrina");
        rad_2206.setName("2206"); // NOI18N

        rad_2207.setText("Con descarga directa al mar, río, lago o quebrada");
        rad_2207.setName("2207"); // NOI18N

        rad_2208.setText("Conectada a pozo ciego");
        rad_2208.setName("2208"); // NOI18N

        rad_2209.setText("Conectado a pozo séptico");
        rad_2209.setName("2209"); // NOI18N

        rad_2210.setText("Conectado a red pública del alcantarillado");
        rad_2210.setName("2210"); // NOI18N

        jLabel_305.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_305.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_305.setText("* Esta pregunta es obligatoria.");
        jLabel_305.setName("lbl_305"); // NOI18N

        javax.swing.GroupLayout jPanel_305Layout = new javax.swing.GroupLayout(jPanel_305);
        jPanel_305.setLayout(jPanel_305Layout);
        jPanel_305Layout.setHorizontalGroup(
            jPanel_305Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_305Layout.createSequentialGroup()
                .addGroup(jPanel_305Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_305Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_305Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2208)
                            .addComponent(rad_2207)
                            .addComponent(rad_2206)
                            .addComponent(rad_2205)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2209)
                            .addComponent(rad_2210)))
                    .addGroup(jPanel_305Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_305)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_305Layout.setVerticalGroup(
            jPanel_305Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_305Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_305)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2205)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2206)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2207)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rad_2208)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rad_2209)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rad_2210)
                .addContainerGap())
        );

        jPanel_306.setName("306"); // NOI18N

        jLabel34.setText("<html><b>2.8. ¿Cuántos cuartos  de baño con ducha de uso exclusivo tiene  tu hogar?</b><br/>(selecciona una opción)</html>");
        jLabel34.setName("1"); // NOI18N

        rad_2211.setText("No tiene cuarto de baño exclusivo con ducha en el hogar");
        rad_2211.setName("2211"); // NOI18N

        rad_2212.setText("Tiene 1 cuarto de baño exclusivo con ducha");
        rad_2212.setName("2212"); // NOI18N

        rad_2213.setText("Tiene 2 cuartos de baño exclusivos con ducha");
        rad_2213.setName("2213"); // NOI18N

        rad_2214.setText("Tiene 3 o mas cuartos de baño exclusivos con ducha");
        rad_2214.setName("2214"); // NOI18N

        jLabel_306.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_306.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_306.setText("* Esta pregunta es obligatoria.");
        jLabel_306.setName("lbl_306"); // NOI18N

        javax.swing.GroupLayout jPanel_306Layout = new javax.swing.GroupLayout(jPanel_306);
        jPanel_306.setLayout(jPanel_306Layout);
        jPanel_306Layout.setHorizontalGroup(
            jPanel_306Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_306Layout.createSequentialGroup()
                .addGroup(jPanel_306Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_306Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_306Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2214)
                            .addComponent(rad_2213)
                            .addComponent(rad_2212)
                            .addComponent(rad_2211)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_306Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_306)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_306Layout.setVerticalGroup(
            jPanel_306Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_306Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_306)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2211)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2212)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2213)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2214)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSec_2Layout = new javax.swing.GroupLayout(jPanelSec_2);
        jPanelSec_2.setLayout(jPanelSec_2Layout);
        jPanelSec_2Layout.setHorizontalGroup(
            jPanelSec_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSec_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_301, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_303, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_304, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_305, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_306, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_302, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelSec_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel_298, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_299, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_300, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(100, 100, 100))
        );
        jPanelSec_2Layout.setVerticalGroup(
            jPanelSec_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_2Layout.createSequentialGroup()
                .addComponent(jPanel_298, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_299, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_300, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_301, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_302, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_303, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_304, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_305, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_306, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jScrollPane2.setViewportView(jPanelSec_2);

        jTabbedPane1.addTab("TIPOLOGIA DE LA VIVIENDA", jScrollPane2);

        jPanel_307.setName("307"); // NOI18N

        jLabel35.setText("<html><b>3.1. ¿Quién es el jefe/a de tu hogar?</b><br/>(selecciona una opción)</html>");
        jLabel35.setName("1"); // NOI18N

        rad_2215.setText("Padre");
        rad_2215.setName("2215"); // NOI18N

        rad_2216.setText("Madre");
        rad_2216.setName("2216"); // NOI18N

        rad_2217.setText("Hermanas/os");
        rad_2217.setName("2217"); // NOI18N

        rad_2218.setText("Abuelas/os");
        rad_2218.setName("2218"); // NOI18N

        rad_2219.setText("Hija/o");
        rad_2219.setName("2219"); // NOI18N

        rad_2220.setText("Cónyuge o conviviente");
        rad_2220.setName("2220"); // NOI18N

        rad_2221.setText("Otro");
        rad_2221.setName("2221"); // NOI18N

        jLabel_307.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_307.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_307.setText("* Esta pregunta es obligatoria.");
        jLabel_307.setName("lbl_307"); // NOI18N

        javax.swing.GroupLayout jPanel_307Layout = new javax.swing.GroupLayout(jPanel_307);
        jPanel_307.setLayout(jPanel_307Layout);
        jPanel_307Layout.setHorizontalGroup(
            jPanel_307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_307Layout.createSequentialGroup()
                .addGroup(jPanel_307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_307Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2218)
                            .addComponent(rad_2217)
                            .addComponent(rad_2216)
                            .addComponent(rad_2215)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2219)
                            .addComponent(rad_2220)
                            .addComponent(rad_2221)))
                    .addGroup(jPanel_307Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_307)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_307Layout.setVerticalGroup(
            jPanel_307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_307Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_307)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2215)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2216)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2217)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2218)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2219)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2220)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2221)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_308.setName("308"); // NOI18N

        jLabel36.setText("<html><b>3.2. ¿Cuál es el nivel de instrucción  del jefe/a de tu hogar?</b><br/>(selecciona una opción)</html>");
        jLabel36.setName("1"); // NOI18N

        rad_2222.setText("Sin estudios");
        rad_2222.setName("2222"); // NOI18N

        rad_2223.setText("Primaria incompleta ");
        rad_2223.setName("2223"); // NOI18N

        rad_2224.setText("Primaria completa ");
        rad_2224.setName("2224"); // NOI18N

        rad_2225.setText("Secundaria incompleta ");
        rad_2225.setName("2225"); // NOI18N

        rad_2226.setText("Secundaria completa ");
        rad_2226.setName("2226"); // NOI18N

        rad_2227.setText("Hasta tres años de educación superior");
        rad_2227.setName("2227"); // NOI18N

        rad_2228.setText("4 o mas años de educación superior (sin post grado)");
        rad_2228.setName("2228"); // NOI18N

        rad_2229.setText("Postgrado");
        rad_2229.setName("2229"); // NOI18N

        jLabel_308.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_308.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_308.setText("* Esta pregunta es obligatoria.");
        jLabel_308.setName("lbl_308"); // NOI18N

        javax.swing.GroupLayout jPanel_308Layout = new javax.swing.GroupLayout(jPanel_308);
        jPanel_308.setLayout(jPanel_308Layout);
        jPanel_308Layout.setHorizontalGroup(
            jPanel_308Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_308Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_308Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_308)
                    .addComponent(rad_2225)
                    .addComponent(rad_2224)
                    .addComponent(rad_2223)
                    .addComponent(rad_2222)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2226)
                    .addComponent(rad_2227)
                    .addComponent(rad_2228)
                    .addComponent(rad_2229))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_308Layout.setVerticalGroup(
            jPanel_308Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_308Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_308)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2222)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2223)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2224)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2225)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2226)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2227)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2228)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2229)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_309.setName("309"); // NOI18N

        jLabel37.setText("<html><b>3.3. ¿Cuál es el nivel de instrucción  de tu padre?</b><br/>(selecciona una opción)</html>");
        jLabel37.setName("1"); // NOI18N

        rad_2230.setText("Ninguno");
        rad_2230.setName("2230"); // NOI18N
        rad_2230.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2230ActionPerformed(evt);
            }
        });

        rad_2231.setText("Centro de alfabetización/(EBA)");
        rad_2231.setName("2231"); // NOI18N
        rad_2231.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2231ActionPerformed(evt);
            }
        });

        rad_2232.setText("Jardín de infante");
        rad_2232.setName("2232"); // NOI18N
        rad_2232.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2232ActionPerformed(evt);
            }
        });

        rad_2233.setText("Primaria");
        rad_2233.setName("2233"); // NOI18N
        rad_2233.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2233ActionPerformed(evt);
            }
        });

        rad_2234.setText("Educación básica");
        rad_2234.setName("2234"); // NOI18N
        rad_2234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2234ActionPerformed(evt);
            }
        });

        rad_2235.setText("Secundaria ");
        rad_2235.setName("2235"); // NOI18N
        rad_2235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2235ActionPerformed(evt);
            }
        });

        rad_2236.setText("Educación media/ bachillerato");
        rad_2236.setName("2236"); // NOI18N
        rad_2236.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2236ActionPerformed(evt);
            }
        });

        rad_2237.setText("Superior no universitaria");
        rad_2237.setName("2237"); // NOI18N
        rad_2237.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2237ActionPerformed(evt);
            }
        });

        rad_2238.setText("Superior universitaria");
        rad_2238.setName("2238"); // NOI18N
        rad_2238.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2238ActionPerformed(evt);
            }
        });

        rad_2239.setText("Postgrado");
        rad_2239.setName("2239"); // NOI18N
        rad_2239.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2239ActionPerformed(evt);
            }
        });

        jLabel_309.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_309.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_309.setText("* Esta pregunta es obligatoria.");
        jLabel_309.setName("lbl_309"); // NOI18N

        javax.swing.GroupLayout jPanel_309Layout = new javax.swing.GroupLayout(jPanel_309);
        jPanel_309.setLayout(jPanel_309Layout);
        jPanel_309Layout.setHorizontalGroup(
            jPanel_309Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_309Layout.createSequentialGroup()
                .addGroup(jPanel_309Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_309Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_309Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2233)
                            .addComponent(rad_2232)
                            .addComponent(rad_2231)
                            .addComponent(rad_2230)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2234)
                            .addComponent(rad_2235)
                            .addComponent(rad_2236)
                            .addComponent(rad_2237)
                            .addComponent(rad_2238)
                            .addComponent(rad_2239)))
                    .addGroup(jPanel_309Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_309)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_309Layout.setVerticalGroup(
            jPanel_309Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_309Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_309)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2230)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2231)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2232)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2233)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2234)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2235)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2236)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2237)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2238)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2239)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_310.setName("310"); // NOI18N

        jLabel38.setText("<html><b>3.3.1. ¿Cuál es el año mas alto de estudios que aprobó?</b></html>");
        jLabel38.setName("1"); // NOI18N

        txt_2467.setName("2467"); // NOI18N
        txt_2467.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_2467KeyTyped(evt);
            }
        });

        jLabel39.setText("Año(s)");

        jLabel_310.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_310.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_310.setText("* Esta pregunta es obligatoria.");
        jLabel_310.setName("lbl_310"); // NOI18N

        javax.swing.GroupLayout jPanel_310Layout = new javax.swing.GroupLayout(jPanel_310);
        jPanel_310.setLayout(jPanel_310Layout);
        jPanel_310Layout.setHorizontalGroup(
            jPanel_310Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_310Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_310Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_310)
                    .addGroup(jPanel_310Layout.createSequentialGroup()
                        .addComponent(txt_2467, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel39)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_310Layout.setVerticalGroup(
            jPanel_310Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_310Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_310)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_310Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_2467, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addGap(7, 7, 7))
        );

        jPanel_311.setName("311"); // NOI18N

        jLabel40.setText("<html><b>3.4. ¿Cuál es el nivel de instrucción  de tu madre?</b><br/>(selecciona una opción)</html>");
        jLabel40.setName("1"); // NOI18N

        rad_2240.setText("Ninguno");
        rad_2240.setName("2240"); // NOI18N
        rad_2240.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2240ActionPerformed(evt);
            }
        });

        rad_2241.setText("Centro de alfabetización/(EBA)");
        rad_2241.setName("2241"); // NOI18N
        rad_2241.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2241ActionPerformed(evt);
            }
        });

        rad_2242.setText("Jardín de infante");
        rad_2242.setName("2242"); // NOI18N
        rad_2242.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2242ActionPerformed(evt);
            }
        });

        rad_2243.setText("Primaria");
        rad_2243.setName("2243"); // NOI18N
        rad_2243.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2243ActionPerformed(evt);
            }
        });

        rad_2244.setText("Educación básica");
        rad_2244.setName("2244"); // NOI18N
        rad_2244.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2244ActionPerformed(evt);
            }
        });

        rad_2245.setText("Secundaria ");
        rad_2245.setName("2245"); // NOI18N
        rad_2245.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2245ActionPerformed(evt);
            }
        });

        rad_2246.setText("Educación media/ bachillerato");
        rad_2246.setName("2246"); // NOI18N
        rad_2246.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2246ActionPerformed(evt);
            }
        });

        rad_2247.setText("Superior no universitaria");
        rad_2247.setName("2247"); // NOI18N
        rad_2247.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2247ActionPerformed(evt);
            }
        });

        rad_2248.setText("Superior universitaria");
        rad_2248.setName("2248"); // NOI18N
        rad_2248.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2248ActionPerformed(evt);
            }
        });

        rad_2249.setText("Postgrado");
        rad_2249.setName("2249"); // NOI18N
        rad_2249.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2249ActionPerformed(evt);
            }
        });

        jLabel_311.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_311.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_311.setText("* Esta pregunta es obligatoria.");
        jLabel_311.setName("lbl_311"); // NOI18N

        javax.swing.GroupLayout jPanel_311Layout = new javax.swing.GroupLayout(jPanel_311);
        jPanel_311.setLayout(jPanel_311Layout);
        jPanel_311Layout.setHorizontalGroup(
            jPanel_311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_311Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_311)
                    .addComponent(rad_2249)
                    .addComponent(rad_2248)
                    .addComponent(rad_2247)
                    .addComponent(rad_2246)
                    .addComponent(rad_2245)
                    .addComponent(rad_2244)
                    .addComponent(rad_2243)
                    .addComponent(rad_2242)
                    .addComponent(rad_2241)
                    .addComponent(rad_2240)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_311Layout.setVerticalGroup(
            jPanel_311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_311Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_311)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2240)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2241)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2242)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2243)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2244)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2245)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2246)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2247)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2248)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2249)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_312.setName("312"); // NOI18N

        jLabel41.setText("<html><b>3.4.1. ¿Cuál es el año mas alto de estudios que aprobó?</b></html>");
        jLabel41.setName("1"); // NOI18N

        txt_2250.setName("2250"); // NOI18N
        txt_2250.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_2250KeyTyped(evt);
            }
        });

        jLabel_312.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_312.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_312.setText("* Esta pregunta es obligatoria.");
        jLabel_312.setName("lbl_312"); // NOI18N

        jLabel85.setText("Año(s)");

        javax.swing.GroupLayout jPanel_312Layout = new javax.swing.GroupLayout(jPanel_312);
        jPanel_312.setLayout(jPanel_312Layout);
        jPanel_312Layout.setHorizontalGroup(
            jPanel_312Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_312Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_312Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_312)
                    .addGroup(jPanel_312Layout.createSequentialGroup()
                        .addComponent(txt_2250, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel85)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_312Layout.setVerticalGroup(
            jPanel_312Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_312Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel_312)
                .addGap(0, 0, 0)
                .addGroup(jPanel_312Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_2250, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85))
                .addGap(6, 6, 6))
        );

        jPanel_313.setName("313"); // NOI18N

        jLabel43.setText("<html><b>3.5. ¿Cuál es la principal ocupación del jefe de tu hogar?</b><br/>(selecciona una opción) </html>");
        jLabel43.setName("1"); // NOI18N

        rad_2251.setText("Personal Directivo de la  administración publica y de  empresas");
        rad_2251.setName("2251"); // NOI18N

        rad_2252.setText("Profesionales científicos e intelectuales");
        rad_2252.setName("2252"); // NOI18N

        rad_2253.setText("Técnicos y profesionales de nivel medio");
        rad_2253.setName("2253"); // NOI18N

        rad_2254.setText("Empleados de oficina");
        rad_2254.setName("2254"); // NOI18N

        rad_2255.setText("Trabajador de los servicios y comerciantes");
        rad_2255.setName("2255"); // NOI18N

        rad_2256.setText("Trabajador calificado agropecuario y pesquero");
        rad_2256.setName("2256"); // NOI18N

        rad_2257.setText("Oficiales operarios y artesanos");
        rad_2257.setName("2257"); // NOI18N

        rad_2258.setText("Operadores de instalaciones y maquinas");
        rad_2258.setName("2258"); // NOI18N

        rad_2259.setText("Trabajadores no calificados");
        rad_2259.setName("2259"); // NOI18N

        rad_2260.setText("Fuerzas armadas");
        rad_2260.setName("2260"); // NOI18N

        rad_2261.setText("Desocupados");
        rad_2261.setName("2261"); // NOI18N

        rad_2262.setText("Inactivos");
        rad_2262.setName("2262"); // NOI18N

        jLabel_313.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_313.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_313.setText("* Esta pregunta es obligatoria.");
        jLabel_313.setName("lbl_313"); // NOI18N

        javax.swing.GroupLayout jPanel_313Layout = new javax.swing.GroupLayout(jPanel_313);
        jPanel_313.setLayout(jPanel_313Layout);
        jPanel_313Layout.setHorizontalGroup(
            jPanel_313Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_313Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_313Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_313)
                    .addComponent(rad_2252)
                    .addComponent(rad_2251)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2253)
                    .addComponent(rad_2254)
                    .addComponent(rad_2255)
                    .addComponent(rad_2256)
                    .addComponent(rad_2257)
                    .addComponent(rad_2258)
                    .addComponent(rad_2259)
                    .addComponent(rad_2260)
                    .addComponent(rad_2261)
                    .addComponent(rad_2262))
                .addGap(10, 10, 10))
        );
        jPanel_313Layout.setVerticalGroup(
            jPanel_313Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_313Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_313)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2251)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2252)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2253)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2254)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2255)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2256)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2257)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2258)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2259)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2260)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2261)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2262)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_314.setName("314"); // NOI18N

        jLabel44.setText("<html><b>3.6. ¿Cuál es la principal ocupación de tu padre?</b><br/>(selecciona una opción)</html>");
        jLabel44.setName("1"); // NOI18N

        rad_2263.setText("Empleado, obrero de gobierno o Estado");
        rad_2263.setName("2263"); // NOI18N

        rad_2264.setText("Empleado/obrero privado");
        rad_2264.setName("2264"); // NOI18N

        rad_2265.setText("Empleado/obrero tercerizado");
        rad_2265.setName("2265"); // NOI18N

        rad_2266.setText("Jornalero o peón");
        rad_2266.setName("2266"); // NOI18N

        rad_2267.setText("Patrono");
        rad_2267.setName("2267"); // NOI18N

        rad_2268.setText("Cuenta propia ");
        rad_2268.setName("2268"); // NOI18N

        rad_2269.setText("Trabajador del hogar no remunerado");
        rad_2269.setName("2269"); // NOI18N

        rad_2270.setText("Trabajador del hogar no remunerado en otro hogar");
        rad_2270.setName("2270"); // NOI18N

        rad_2271.setText("Ayudante no remunerado de asalariado / jornalero");
        rad_2271.setName("2271"); // NOI18N

        rad_2272.setText("Empleado doméstico");
        rad_2272.setName("2272"); // NOI18N

        rad_2273.setText("Desocupado");
        rad_2273.setName("2273"); // NOI18N

        jLabel_314.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_314.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_314.setText("* Esta pregunta es obligatoria.");
        jLabel_314.setName("lbl_314"); // NOI18N

        javax.swing.GroupLayout jPanel_314Layout = new javax.swing.GroupLayout(jPanel_314);
        jPanel_314.setLayout(jPanel_314Layout);
        jPanel_314Layout.setHorizontalGroup(
            jPanel_314Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_314Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_314Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_314)
                    .addComponent(rad_2264)
                    .addComponent(rad_2263)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2265)
                    .addComponent(rad_2266)
                    .addComponent(rad_2267)
                    .addComponent(rad_2268)
                    .addComponent(rad_2269)
                    .addComponent(rad_2270)
                    .addComponent(rad_2271)
                    .addComponent(rad_2272)
                    .addComponent(rad_2273))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_314Layout.setVerticalGroup(
            jPanel_314Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_314Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_314)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2263)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2264)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2265)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2266)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2267)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2268)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2269)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2270)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2271)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2272)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2273)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_315.setName("315"); // NOI18N

        jLabel45.setText("<html><b>3.7. ¿Cuál es la principal ocupación de tu madre?</b><br/>(selecciona una opción)</html>");
        jLabel45.setName("1"); // NOI18N

        rad_2274.setText("Empleada, obrera de gobierno o Estado");
        rad_2274.setName("2274"); // NOI18N

        rad_2275.setText("Empleada/obrera privada");
        rad_2275.setName("2275"); // NOI18N

        rad_2276.setText("Empleada/obrera tercerizada");
        rad_2276.setName("2276"); // NOI18N

        rad_2277.setText("Jornalera o peón");
        rad_2277.setName("2277"); // NOI18N

        rad_2278.setText("Patrona");
        rad_2278.setName("2278"); // NOI18N

        rad_2279.setText("Cuenta propia ");
        rad_2279.setName("2279"); // NOI18N

        rad_2280.setText("Trabajadora del hogar no remunerada");
        rad_2280.setName("2280"); // NOI18N

        rad_2281.setText("Trabajadora del hogar no remunerada en otro hogar");
        rad_2281.setName("2281"); // NOI18N

        rad_2282.setText("Ayudante no remunerada de asalariada / jornalera");
        rad_2282.setName("2282"); // NOI18N

        rad_2283.setText("Empleada doméstico");
        rad_2283.setName("2283"); // NOI18N

        rad_2284.setText("Desocupada");
        rad_2284.setName("2284"); // NOI18N

        jLabel_315.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_315.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_315.setText("* Esta pregunta es obligatoria.");
        jLabel_315.setName("lbl_315"); // NOI18N

        javax.swing.GroupLayout jPanel_315Layout = new javax.swing.GroupLayout(jPanel_315);
        jPanel_315.setLayout(jPanel_315Layout);
        jPanel_315Layout.setHorizontalGroup(
            jPanel_315Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_315Layout.createSequentialGroup()
                .addGroup(jPanel_315Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_315Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_315Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2275)
                            .addComponent(rad_2274)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2276)
                            .addComponent(rad_2277)
                            .addComponent(rad_2278)
                            .addComponent(rad_2279)
                            .addComponent(rad_2280)
                            .addComponent(rad_2281)
                            .addComponent(rad_2282)
                            .addComponent(rad_2283)
                            .addComponent(rad_2284)))
                    .addGroup(jPanel_315Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_315)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_315Layout.setVerticalGroup(
            jPanel_315Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_315Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_315)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2274)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2275)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2276)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2277)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2278)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2279)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2280)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2281)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2282)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2283)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2284)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_316.setName("316"); // NOI18N

        jLabel46.setText("<html><b>3.8. Alguien en tu hogar esta afiliado o cubierto por el seguro del IESS<br/> (general, voluntario o campesino) y/o seguro del ISSFA o ISSPOL.</b><br/>(selecciona una opción)</html>");
        jLabel46.setName("1"); // NOI18N

        rad_2285.setText("Sí");
        rad_2285.setName("2285"); // NOI18N

        rad_2286.setText("No");
        rad_2286.setName("2286"); // NOI18N

        jLabel_316.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_316.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_316.setText("* Esta pregunta es obligatoria.");
        jLabel_316.setName("lbl_316"); // NOI18N

        javax.swing.GroupLayout jPanel_316Layout = new javax.swing.GroupLayout(jPanel_316);
        jPanel_316.setLayout(jPanel_316Layout);
        jPanel_316Layout.setHorizontalGroup(
            jPanel_316Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_316Layout.createSequentialGroup()
                .addGroup(jPanel_316Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_316Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_316Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2286)
                            .addComponent(rad_2285)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_316Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_316)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_316Layout.setVerticalGroup(
            jPanel_316Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_316Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_316)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2285)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2286)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_317.setName("317"); // NOI18N

        jLabel47.setText("<html><b>3.9. Alguien en tu hogar tiene seguro de salud privado con hospitalización,<br/>seguro de salud privada sin hospitalización, seguro internacional, seguros<br/>municipales y de Consejos Provinciales y/o seguro de vida?</b><br/>(selecciona una opción)</html>");
        jLabel47.setName("1"); // NOI18N

        rad_2287.setText("Sí");
        rad_2287.setName("2287"); // NOI18N

        rad_2288.setText("No");
        rad_2288.setName("2288"); // NOI18N

        jLabel_317.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_317.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_317.setText("* Esta pregunta es obligatoria.");
        jLabel_317.setName("lbl_317"); // NOI18N

        javax.swing.GroupLayout jPanel_317Layout = new javax.swing.GroupLayout(jPanel_317);
        jPanel_317.setLayout(jPanel_317Layout);
        jPanel_317Layout.setHorizontalGroup(
            jPanel_317Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_317Layout.createSequentialGroup()
                .addGroup(jPanel_317Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_317Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_317Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2288)
                            .addComponent(rad_2287)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_317Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_317)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_317Layout.setVerticalGroup(
            jPanel_317Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_317Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_317)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2287)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2288)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_318.setName("318"); // NOI18N

        jLabel48.setText("<html><b>3.10. Hábitos de consumo</b><br/>(selecciona la opción o las opciones que se adecuen a tu realidad)</html>");
        jLabel48.setName("1"); // NOI18N

        chk_2289.setText("En mi  hogar compran vestimenta en centros comerciales");
        chk_2289.setName("2289"); // NOI18N

        chk_2290.setText("En mi hogar alguien ha usado internet durante los últimos 6 meses ");
        chk_2290.setName("2290"); // NOI18N

        chk_2291.setText("En mi hogar alguien utiliza correo electrónico que no sea del trabajo");
        chk_2291.setName("2291"); // NOI18N

        chk_2292.setText("En mi hogar alguien esta registrado en una red social");
        chk_2292.setName("2292"); // NOI18N

        chk_2293.setText("<html>En mi hogar alguien ha leído un libro completo en los últimos tres meses<br/>(exceptuar libros o manuales de estudio y lecturas de trabajo)</html>");
        chk_2293.setName("2293"); // NOI18N

        jLabel_318.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_318.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_318.setText("* Esta pregunta es obligatoria.");
        jLabel_318.setName("lbl_318"); // NOI18N

        javax.swing.GroupLayout jPanel_318Layout = new javax.swing.GroupLayout(jPanel_318);
        jPanel_318.setLayout(jPanel_318Layout);
        jPanel_318Layout.setHorizontalGroup(
            jPanel_318Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_318Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_318Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_2293)
                    .addGroup(jPanel_318Layout.createSequentialGroup()
                        .addGroup(jPanel_318Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_318)
                            .addComponent(chk_2289)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chk_2290)
                            .addComponent(chk_2291)
                            .addComponent(chk_2292))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_318Layout.setVerticalGroup(
            jPanel_318Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_318Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_318)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_2289)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2290)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2291)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2292)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2293, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanel_319.setName("319"); // NOI18N

        jLabel49.setText("<html><b>3.11. ¿Alguien depende económicamente de ti?</b><br/>(selecciona una opción)</html>");
        jLabel49.setName("1"); // NOI18N

        rad_2294.setText("Sí");
        rad_2294.setName("2294"); // NOI18N
        rad_2294.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2294ActionPerformed(evt);
            }
        });

        rad_2295.setText("No");
        rad_2295.setName("2295"); // NOI18N
        rad_2295.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2295ActionPerformed(evt);
            }
        });

        jLabel_319.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_319.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_319.setText("* Esta pregunta es obligatoria.");
        jLabel_319.setName("lbl_319"); // NOI18N

        javax.swing.GroupLayout jPanel_319Layout = new javax.swing.GroupLayout(jPanel_319);
        jPanel_319.setLayout(jPanel_319Layout);
        jPanel_319Layout.setHorizontalGroup(
            jPanel_319Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_319Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_319Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_319)
                    .addComponent(rad_2295)
                    .addComponent(rad_2294)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_319Layout.setVerticalGroup(
            jPanel_319Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_319Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_319)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2294)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2295)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_320.setName("320"); // NOI18N

        jLabel50.setText("<html><b>3.11.1. ¿Quién depende económicamente de ti?</b><br/>(selección múltiple)</html>");
        jLabel50.setName("1"); // NOI18N

        chk_2296.setText("Padre");
        chk_2296.setName("2296"); // NOI18N

        chk_2297.setText("Madre ");
        chk_2297.setName("2297"); // NOI18N

        chk_2298.setText("Hermanas/os");
        chk_2298.setName("2298"); // NOI18N

        chk_2299.setText("Abuelas/os");
        chk_2299.setName("2299"); // NOI18N

        chk_2300.setText("Hija/o");
        chk_2300.setName("2300"); // NOI18N

        chk_2301.setText("Cónyuge o conviviente");
        chk_2301.setName("2301"); // NOI18N

        chk_2302.setText("Otro");
        chk_2302.setName("2302"); // NOI18N

        jLabel_320.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_320.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_320.setText("* Esta pregunta es obligatoria.");
        jLabel_320.setName("lbl_320"); // NOI18N

        javax.swing.GroupLayout jPanel_320Layout = new javax.swing.GroupLayout(jPanel_320);
        jPanel_320.setLayout(jPanel_320Layout);
        jPanel_320Layout.setHorizontalGroup(
            jPanel_320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_320Layout.createSequentialGroup()
                .addGroup(jPanel_320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_320Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chk_2296)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chk_2297)
                            .addComponent(chk_2298)
                            .addComponent(chk_2299)
                            .addComponent(chk_2300)
                            .addComponent(chk_2301)
                            .addComponent(chk_2302)))
                    .addGroup(jPanel_320Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_320)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_320Layout.setVerticalGroup(
            jPanel_320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_320Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_320)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_2296)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2297)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2298)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2299)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2300)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2301)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2302)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_321.setName("321"); // NOI18N

        jLabel51.setText("<html><b>3.12. ¿Cuántos libros, sin tomar en cuenta revistas<br/>y periódicos, existen en tu hogar aproximadamente?</b><br/>(selecciona una opción)</html>");
        jLabel51.setName("1"); // NOI18N

        rad_2303.setText("Ninguno ");
        rad_2303.setName("2303"); // NOI18N

        rad_2304.setText("1 a 25");
        rad_2304.setName("2304"); // NOI18N

        rad_2305.setText("26 - 50");
        rad_2305.setName("2305"); // NOI18N

        rad_2306.setText("51 - 75");
        rad_2306.setName("2306"); // NOI18N

        rad_2307.setText("76 -100");
        rad_2307.setName("2307"); // NOI18N

        rad_2308.setText("más de 100 ");
        rad_2308.setName("2308"); // NOI18N

        jLabel_321.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_321.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_321.setText("* Esta pregunta es obligatoria.");
        jLabel_321.setName("lbl_321"); // NOI18N

        javax.swing.GroupLayout jPanel_321Layout = new javax.swing.GroupLayout(jPanel_321);
        jPanel_321.setLayout(jPanel_321Layout);
        jPanel_321Layout.setHorizontalGroup(
            jPanel_321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_321Layout.createSequentialGroup()
                .addGroup(jPanel_321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_321Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2303)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2304)
                            .addComponent(rad_2305)
                            .addComponent(rad_2306)
                            .addComponent(rad_2307)
                            .addComponent(rad_2308)))
                    .addGroup(jPanel_321Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_321)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_321Layout.setVerticalGroup(
            jPanel_321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_321Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_321)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2303)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2304)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2305)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2306)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2307)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2308)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_322.setName("322"); // NOI18N

        jLabel52.setText("<html><b>3.13. ¿Cuál es la principal actividad cultural a la que asistes con frecuencia?</b><br/>(selecciona una opción)</html>");
        jLabel52.setName("1"); // NOI18N

        rad_2309.setText("Cine");
        rad_2309.setName("2309"); // NOI18N

        rad_2310.setText("Teatro/ teatro de la calle");
        rad_2310.setName("2310"); // NOI18N

        rad_2311.setText("Museo");
        rad_2311.setName("2311"); // NOI18N

        rad_2312.setText("Fiestas tradicionales");
        rad_2312.setName("2312"); // NOI18N

        rad_2313.setText("Conciertos");
        rad_2313.setName("2313"); // NOI18N

        rad_2314.setText("Visitas a comunidades ancestrales");
        rad_2314.setName("2314"); // NOI18N

        rad_2315.setText("Fiestas barriales");
        rad_2315.setName("2315"); // NOI18N

        rad_2316.setText("Juegos populares");
        rad_2316.setName("2316"); // NOI18N

        rad_2317.setText("Ferias");
        rad_2317.setName("2317"); // NOI18N

        jLabel_322.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_322.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_322.setText("* Esta pregunta es obligatoria.");
        jLabel_322.setName("lbl_322"); // NOI18N

        javax.swing.GroupLayout jPanel_322Layout = new javax.swing.GroupLayout(jPanel_322);
        jPanel_322.setLayout(jPanel_322Layout);
        jPanel_322Layout.setHorizontalGroup(
            jPanel_322Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_322Layout.createSequentialGroup()
                .addGroup(jPanel_322Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_322Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_322Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2309)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2310)
                            .addComponent(rad_2311)
                            .addComponent(rad_2312)
                            .addComponent(rad_2313)
                            .addComponent(rad_2314)
                            .addComponent(rad_2315)
                            .addComponent(rad_2316)
                            .addComponent(rad_2317)))
                    .addGroup(jPanel_322Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_322)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_322Layout.setVerticalGroup(
            jPanel_322Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_322Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_322)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2309)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2310)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2311)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2312)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2313)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2314)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2315)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2316)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2317)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_323.setName("323"); // NOI18N

        jLabel53.setText("<html><b>3.14. ¿Has sido beneficiario/a de alguna beca para tus estudios de bachillerato?</b><br/>(selecciona una opción)</html>");
        jLabel53.setName("1"); // NOI18N

        rad_2318.setText("Sí");
        rad_2318.setName("2318"); // NOI18N
        rad_2318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2318ActionPerformed(evt);
            }
        });

        rad_2319.setText("No");
        rad_2319.setName("2319"); // NOI18N
        rad_2319.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2319ActionPerformed(evt);
            }
        });

        jLabel_323.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_323.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_323.setText("* Esta pregunta es obligatoria.");
        jLabel_323.setName("lbl_323"); // NOI18N

        javax.swing.GroupLayout jPanel_323Layout = new javax.swing.GroupLayout(jPanel_323);
        jPanel_323.setLayout(jPanel_323Layout);
        jPanel_323Layout.setHorizontalGroup(
            jPanel_323Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_323Layout.createSequentialGroup()
                .addGroup(jPanel_323Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_323Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_323Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2318)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2319)))
                    .addGroup(jPanel_323Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_323)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_323Layout.setVerticalGroup(
            jPanel_323Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_323Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_323)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2318)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2319)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_324.setName("324"); // NOI18N

        jLabel54.setText("<html><b>3.14.1. ¿Qué tipo de beca?</b><br/>(selecciona una opción)</html>");
        jLabel54.setName("1"); // NOI18N

        rad_2320.setText("Académica");
        rad_2320.setName("2320"); // NOI18N

        rad_2321.setText("Deportiva");
        rad_2321.setName("2321"); // NOI18N

        rad_2322.setText("Cultural");
        rad_2322.setName("2322"); // NOI18N

        rad_2323.setText("Discapacidad");
        rad_2323.setName("2323"); // NOI18N

        rad_2324.setText("Situación económica");
        rad_2324.setName("2324"); // NOI18N

        rad_2325.setText("Pueblos y nacionalidades");
        rad_2325.setName("2325"); // NOI18N

        rad_2326.setText("Hermanos");
        rad_2326.setName("2326"); // NOI18N

        rad_2327.setText("Otro");
        rad_2327.setName("2327"); // NOI18N

        jLabel_324.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_324.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_324.setText("* Esta pregunta es obligatoria.");
        jLabel_324.setName("lbl_324"); // NOI18N

        javax.swing.GroupLayout jPanel_324Layout = new javax.swing.GroupLayout(jPanel_324);
        jPanel_324.setLayout(jPanel_324Layout);
        jPanel_324Layout.setHorizontalGroup(
            jPanel_324Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_324Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_324Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_324)
                    .addComponent(rad_2320)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2321)
                    .addComponent(rad_2322)
                    .addComponent(rad_2323)
                    .addComponent(rad_2324)
                    .addComponent(rad_2325)
                    .addComponent(rad_2326)
                    .addComponent(rad_2327))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_324Layout.setVerticalGroup(
            jPanel_324Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_324Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_324)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2320)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2321)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2322)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2323)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2324)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2325)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2326)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2327)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_325.setName("325"); // NOI18N

        jLabel55.setText("<html><b>3.15. ¿Has sido abanderado/a de tu colegio?</b><br/>(selecciona una opción)</html>");
        jLabel55.setName("1"); // NOI18N

        rad_2328.setText("Sí");
        rad_2328.setName("2328"); // NOI18N

        rad_2329.setText("No");
        rad_2329.setName("2329"); // NOI18N

        jLabel_325.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_325.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_325.setText("* Esta pregunta es obligatoria.");
        jLabel_325.setName("lbl_325"); // NOI18N

        javax.swing.GroupLayout jPanel_325Layout = new javax.swing.GroupLayout(jPanel_325);
        jPanel_325.setLayout(jPanel_325Layout);
        jPanel_325Layout.setHorizontalGroup(
            jPanel_325Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_325Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_325Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_325)
                    .addComponent(rad_2328)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2329))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_325Layout.setVerticalGroup(
            jPanel_325Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_325Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_325)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2328)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2329)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_326.setName("326"); // NOI18N

        jLabel56.setText("<html><b>3.16. ¿Cuál ha sido tu promedio  durante el bachillerato?</b><br/>(selecciona una opción)</html>");
        jLabel56.setName("1"); // NOI18N

        rad_2330.setText("Sobresaliente");
        rad_2330.setName("2330"); // NOI18N

        rad_2331.setText("Muy bueno");
        rad_2331.setName("2331"); // NOI18N

        rad_2332.setText("Bueno");
        rad_2332.setName("2332"); // NOI18N

        rad_2333.setText("Regular");
        rad_2333.setName("2333"); // NOI18N

        rad_2334.setText("Malo");
        rad_2334.setName("2334"); // NOI18N

        jLabel_326.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_326.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_326.setText("* Esta pregunta es obligatoria.");
        jLabel_326.setName("lbl_326"); // NOI18N

        javax.swing.GroupLayout jPanel_326Layout = new javax.swing.GroupLayout(jPanel_326);
        jPanel_326.setLayout(jPanel_326Layout);
        jPanel_326Layout.setHorizontalGroup(
            jPanel_326Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_326Layout.createSequentialGroup()
                .addGroup(jPanel_326Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_326Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_326Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2330)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2331)
                            .addComponent(rad_2332)
                            .addComponent(rad_2333)
                            .addComponent(rad_2334)))
                    .addGroup(jPanel_326Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_326)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_326Layout.setVerticalGroup(
            jPanel_326Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_326Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_326)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2330)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2331)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2332)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2333)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2334)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSec_3Layout = new javax.swing.GroupLayout(jPanelSec_3);
        jPanelSec_3.setLayout(jPanelSec_3Layout);
        jPanelSec_3Layout.setHorizontalGroup(
            jPanelSec_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSec_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel_307, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelSec_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel_308, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_309, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_310, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_311, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_314, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_315, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_316, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_317, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_323, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_324, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_325, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_326, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSec_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel_321, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_322, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel_320, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_318, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_319, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_313, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_312, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(100, 100, 100))
        );
        jPanelSec_3Layout.setVerticalGroup(
            jPanelSec_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_307, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_308, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_309, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_310, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_311, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_312, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_313, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_314, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_315, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_316, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_317, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_318, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_319, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_320, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_321, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_322, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_323, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_324, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_325, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_326, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane3.setViewportView(jPanelSec_3);

        jTabbedPane1.addTab("CAPITAL ECONOMICO, SOCIAL Y CULTURAL", jScrollPane3);

        jPanel_327.setName("327"); // NOI18N

        jLabel57.setText("<html><b>4.1. ¿La institución educativa en la que estudiaste o estudias es :</b><br/>(selecciona una opción)</html>");
        jLabel57.setName("1"); // NOI18N

        rad_2335.setText("Fiscal?");
        rad_2335.setName("2335"); // NOI18N

        rad_2336.setText("Particular?");
        rad_2336.setName("2336"); // NOI18N

        rad_2337.setText("Fisco misional?");
        rad_2337.setName("2337"); // NOI18N

        rad_2338.setText("Municipal?");
        rad_2338.setName("2338"); // NOI18N

        jLabel_327.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_327.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_327.setText("* Esta pregunta es obligatoria.");
        jLabel_327.setName("lbl_327"); // NOI18N

        javax.swing.GroupLayout jPanel_327Layout = new javax.swing.GroupLayout(jPanel_327);
        jPanel_327.setLayout(jPanel_327Layout);
        jPanel_327Layout.setHorizontalGroup(
            jPanel_327Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_327Layout.createSequentialGroup()
                .addGroup(jPanel_327Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_327Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_327Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2335)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2336)
                            .addComponent(rad_2337)
                            .addComponent(rad_2338)))
                    .addGroup(jPanel_327Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_327)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_327Layout.setVerticalGroup(
            jPanel_327Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_327Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_327)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2335)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2336)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2337)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2338)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_328.setName("328"); // NOI18N

        jLabel58.setText("<html><b>4.2. ¿A qué institución de educación superior aspiras ingresar?</b><br/>(selecciona una opción)</html>");
        jLabel58.setName("1"); // NOI18N

        rad_2339.setText("Universidad pública");
        rad_2339.setName("2339"); // NOI18N

        rad_2340.setText("Instituto público");
        rad_2340.setName("2340"); // NOI18N

        rad_2341.setText("Universidad de excelencia en el exterior");
        rad_2341.setName("2341"); // NOI18N

        rad_2342.setText("Instituto de excelencia en el exterior");
        rad_2342.setName("2342"); // NOI18N

        rad_2343.setText("Instituto privado");
        rad_2343.setName("2343"); // NOI18N

        rad_2344.setText("Universidad privada");
        rad_2344.setName("2344"); // NOI18N

        jLabel_328.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_328.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_328.setText("* Esta pregunta es obligatoria.");
        jLabel_328.setName("lbl_328"); // NOI18N

        javax.swing.GroupLayout jPanel_328Layout = new javax.swing.GroupLayout(jPanel_328);
        jPanel_328.setLayout(jPanel_328Layout);
        jPanel_328Layout.setHorizontalGroup(
            jPanel_328Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_328Layout.createSequentialGroup()
                .addGroup(jPanel_328Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_328Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_328Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2339)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2340)
                            .addComponent(rad_2341)
                            .addComponent(rad_2342)
                            .addComponent(rad_2343)
                            .addComponent(rad_2344)))
                    .addGroup(jPanel_328Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_328)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_328Layout.setVerticalGroup(
            jPanel_328Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_328Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_328)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2339)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2340)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2341)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2342)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2343)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2344)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_329.setName("329"); // NOI18N

        jLabel59.setText("<html><b>4.3. ¿Cuál es la  principal razón por la que deseas estudiar la<br/>carrera de tu preferencia ?</b><br/>(selecciona una opción)</html>");
        jLabel59.setName("1"); // NOI18N

        rad_2345.setText("Tradición familiar");
        rad_2345.setName("2345"); // NOI18N

        rad_2346.setText("Interés personal");
        rad_2346.setName("2346"); // NOI18N

        rad_2347.setText("Facilidad para encontrar trabajo");
        rad_2347.setName("2347"); // NOI18N

        rad_2348.setText("Está ligada a los procesos de desarrollo del país");
        rad_2348.setName("2348"); // NOI18N

        rad_2349.setText("Por lo que se dice en medios de comunicación");
        rad_2349.setName("2349"); // NOI18N

        rad_2350.setText("Mejores ingresos");
        rad_2350.setName("2350"); // NOI18N

        rad_2351.setText("Reconocimiento social");
        rad_2351.setName("2351"); // NOI18N

        rad_2352.setText("Otros");
        rad_2352.setName("2352"); // NOI18N

        jLabel_329.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_329.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_329.setText("* Esta pregunta es obligatoria.");
        jLabel_329.setName("lbl_329"); // NOI18N

        javax.swing.GroupLayout jPanel_329Layout = new javax.swing.GroupLayout(jPanel_329);
        jPanel_329.setLayout(jPanel_329Layout);
        jPanel_329Layout.setHorizontalGroup(
            jPanel_329Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_329Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_329Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_329)
                    .addComponent(rad_2345)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2346)
                    .addComponent(rad_2347)
                    .addComponent(rad_2348)
                    .addComponent(rad_2349)
                    .addComponent(rad_2350)
                    .addComponent(rad_2351)
                    .addComponent(rad_2352))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_329Layout.setVerticalGroup(
            jPanel_329Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_329Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_329)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2345)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2346)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2347)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2348)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2349)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2350)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2351)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2352)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_330.setName("330"); // NOI18N

        jLabel60.setText("<html><b>4.4. ¿Cuál fue tu preparación para rendir el ENES?</b><br/>(selecciona una opción)</html>");
        jLabel60.setName("1"); // NOI18N

        rad_2353.setText("Curso preuniversitario privado");
        rad_2353.setName("2353"); // NOI18N
        rad_2353.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2353ActionPerformed(evt);
            }
        });

        rad_2354.setText("Curso de nivelación general SNNA");
        rad_2354.setName("2354"); // NOI18N
        rad_2354.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2354ActionPerformed(evt);
            }
        });

        rad_2355.setText("Preparación a través de la plataforma Jóvenes");
        rad_2355.setName("2355"); // NOI18N
        rad_2355.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2355ActionPerformed(evt);
            }
        });

        rad_2356.setText("Auto preparación en casa");
        rad_2356.setName("2356"); // NOI18N
        rad_2356.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2356ActionPerformed(evt);
            }
        });

        rad_2357.setText("Ninguna");
        rad_2357.setName("2357"); // NOI18N
        rad_2357.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2357ActionPerformed(evt);
            }
        });

        rad_2358.setText("En tu colegio");
        rad_2358.setName("2358"); // NOI18N
        rad_2358.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2358ActionPerformed(evt);
            }
        });

        rad_2359.setText("Otro");
        rad_2359.setName("2359"); // NOI18N
        rad_2359.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2359ActionPerformed(evt);
            }
        });

        jLabel_330.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_330.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_330.setText("* Esta pregunta es obligatoria.");
        jLabel_330.setName("lbl_330"); // NOI18N

        javax.swing.GroupLayout jPanel_330Layout = new javax.swing.GroupLayout(jPanel_330);
        jPanel_330.setLayout(jPanel_330Layout);
        jPanel_330Layout.setHorizontalGroup(
            jPanel_330Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_330Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_330Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_330)
                    .addComponent(rad_2353)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2354)
                    .addComponent(rad_2355)
                    .addComponent(rad_2356)
                    .addComponent(rad_2357)
                    .addComponent(rad_2358)
                    .addComponent(rad_2359))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_330Layout.setVerticalGroup(
            jPanel_330Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_330Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_330)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2353)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2354)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2355)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2356)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2357)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2358)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2359)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_331.setName("331"); // NOI18N

        jLabel61.setText("<html><b>4.4.1.  ¿Cuánto costó el curso?</b><br/>(selecciona una opción)</html>");
        jLabel61.setName("1"); // NOI18N

        rad_2360.setText("Menos de $ 100 ");
        rad_2360.setName("2360"); // NOI18N

        rad_2361.setText("$100 – $200");
        rad_2361.setName("2361"); // NOI18N

        rad_2362.setText("$201 – S300");
        rad_2362.setName("2362"); // NOI18N

        rad_2363.setText("Más de $300");
        rad_2363.setName("2363"); // NOI18N

        jLabel_331.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_331.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_331.setText("* Esta pregunta es obligatoria.");
        jLabel_331.setName("lbl_331"); // NOI18N

        javax.swing.GroupLayout jPanel_331Layout = new javax.swing.GroupLayout(jPanel_331);
        jPanel_331.setLayout(jPanel_331Layout);
        jPanel_331Layout.setHorizontalGroup(
            jPanel_331Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_331Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_331Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_331)
                    .addComponent(rad_2360)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2361)
                    .addComponent(rad_2362)
                    .addComponent(rad_2363))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_331Layout.setVerticalGroup(
            jPanel_331Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_331Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_331)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2360)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2361)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2362)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2363)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSec_4Layout = new javax.swing.GroupLayout(jPanelSec_4);
        jPanelSec_4.setLayout(jPanelSec_4Layout);
        jPanelSec_4Layout.setHorizontalGroup(
            jPanelSec_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSec_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_327, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_328, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_329, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_330, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_331, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        jPanelSec_4Layout.setVerticalGroup(
            jPanelSec_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_327, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_328, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_329, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_330, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_331, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanelSec_4);

        jTabbedPane1.addTab("PREPARACIÓN PARA RENDIR EL ENES", jScrollPane4);

        jPanel_332.setName("332"); // NOI18N

        jLabel62.setText("<html><b>5.1. ¿Cuáles de estos bienes tienes en tu casa?</b><br/>(selección múltiple)</html>");
        jLabel62.setName("1"); // NOI18N

        chk_2364.setText("Servicio de telefonía convencional, teléfono fijo ");
        chk_2364.setName("2364"); // NOI18N

        chk_2365.setText("Cocina con horno ");
        chk_2365.setName("2365"); // NOI18N

        chk_2366.setText("Refrigeradora ");
        chk_2366.setName("2366"); // NOI18N

        chk_2367.setText("Lavadora ");
        chk_2367.setName("2367"); // NOI18N

        chk_2368.setText("Equipo de sonido ");
        chk_2368.setName("2368"); // NOI18N

        jLabel_332.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_332.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_332.setText("* Esta pregunta es obligatoria.");
        jLabel_332.setName("lbl_332"); // NOI18N

        javax.swing.GroupLayout jPanel_332Layout = new javax.swing.GroupLayout(jPanel_332);
        jPanel_332.setLayout(jPanel_332Layout);
        jPanel_332Layout.setHorizontalGroup(
            jPanel_332Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_332Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_332Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_332)
                    .addComponent(chk_2364)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_2365)
                    .addComponent(chk_2366)
                    .addComponent(chk_2367)
                    .addComponent(chk_2368))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_332Layout.setVerticalGroup(
            jPanel_332Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_332Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_332)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_2364)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2365)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2366)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2367)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2368)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_333.setName("333"); // NOI18N

        jLabel63.setText("<html><b>5.2. ¿Cuántos televisores a color tienes en tu hogar?</b><br/>(selecciona una opción)</html>");
        jLabel63.setName("1"); // NOI18N

        rad_2369.setText("No hay  TV a color en el hogar ");
        rad_2369.setName("2369"); // NOI18N

        rad_2370.setText("Hay 1 tv a color ");
        rad_2370.setName("2370"); // NOI18N

        rad_2371.setText("Hay 2 tv a color ");
        rad_2371.setName("2371"); // NOI18N

        rad_2372.setText("Hay  3 o mas tv a color ");
        rad_2372.setName("2372"); // NOI18N

        jLabel_333.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_333.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_333.setText("* Esta pregunta es obligatoria.");
        jLabel_333.setName("lbl_333"); // NOI18N

        javax.swing.GroupLayout jPanel_333Layout = new javax.swing.GroupLayout(jPanel_333);
        jPanel_333.setLayout(jPanel_333Layout);
        jPanel_333Layout.setHorizontalGroup(
            jPanel_333Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_333Layout.createSequentialGroup()
                .addGroup(jPanel_333Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_333Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_333Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2369)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2370)
                            .addComponent(rad_2371)
                            .addComponent(rad_2372)))
                    .addGroup(jPanel_333Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_333)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_333Layout.setVerticalGroup(
            jPanel_333Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_333Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_333)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2369)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2370)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2371)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2372)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_334.setName("334"); // NOI18N

        jLabel64.setText("<html><b>5.3. ¿Cuántos vehículos de uso exclusivo hay en tu hogar?</b><br/>(selecciona una opción)</html>");
        jLabel64.setName("1"); // NOI18N

        rad_2373.setText("No hay  vehículo de uso exclusivo para el hogar ");
        rad_2373.setName("2373"); // NOI18N

        rad_2374.setText("Hay 1 vehículo exclusivo para el hogar ");
        rad_2374.setName("2374"); // NOI18N

        rad_2375.setText("Hay 2 vehículos exclusivos para el hogar");
        rad_2375.setName("2375"); // NOI18N

        rad_2376.setText("Hay  3 o mas vehículos exclusivos para el hogar");
        rad_2376.setName("2376"); // NOI18N

        jLabel_334.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_334.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_334.setText("* Esta pregunta es obligatoria.");
        jLabel_334.setName("lbl_334"); // NOI18N

        javax.swing.GroupLayout jPanel_334Layout = new javax.swing.GroupLayout(jPanel_334);
        jPanel_334.setLayout(jPanel_334Layout);
        jPanel_334Layout.setHorizontalGroup(
            jPanel_334Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_334Layout.createSequentialGroup()
                .addGroup(jPanel_334Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_334Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_334Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2373)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2374)
                            .addComponent(rad_2375)
                            .addComponent(rad_2376)))
                    .addGroup(jPanel_334Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_334)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_334Layout.setVerticalGroup(
            jPanel_334Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_334Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_334)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2373)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2374)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2375)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2376)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_335.setName("335"); // NOI18N

        jLabel65.setText("<html><b>5.4. ¿Cuáles de estos servicios tiene tu casa?</b><br/>(selección múltiple)</html>");
        jLabel65.setName("1"); // NOI18N

        chk_2377.setText("Servicio de internet ");
        chk_2377.setName("2377"); // NOI18N

        chk_2378.setText("Computadora de escritorio ");
        chk_2378.setName("2378"); // NOI18N

        chk_2379.setText("Computadora portátil ");
        chk_2379.setName("2379"); // NOI18N

        jLabel_335.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_335.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_335.setText("* Esta pregunta es obligatoria.");
        jLabel_335.setName("lbl_335"); // NOI18N

        javax.swing.GroupLayout jPanel_335Layout = new javax.swing.GroupLayout(jPanel_335);
        jPanel_335.setLayout(jPanel_335Layout);
        jPanel_335Layout.setHorizontalGroup(
            jPanel_335Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_335Layout.createSequentialGroup()
                .addGroup(jPanel_335Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_335Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_335Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chk_2377)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chk_2378)
                            .addComponent(chk_2379)))
                    .addGroup(jPanel_335Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_335)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_335Layout.setVerticalGroup(
            jPanel_335Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_335Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_335)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_2377)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2378)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2379)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_336.setName("336"); // NOI18N

        jLabel66.setText("<html><b>5.5. ¿Cuántos celulares activados tienen en tu hogar?</b><br/>(selecciona una opción)</html>");
        jLabel66.setName("1"); // NOI18N

        rad_2380.setText("Nadie tiene celulares en el hogar ");
        rad_2380.setName("2380"); // NOI18N

        rad_2381.setText("Hay 1 celular  ");
        rad_2381.setName("2381"); // NOI18N

        rad_2382.setText("Hay 2 celulares ");
        rad_2382.setName("2382"); // NOI18N

        rad_2383.setText("Hay  3 celulares  ");
        rad_2383.setName("2383"); // NOI18N

        rad_2384.setText("Hay  4 o mas celulares");
        rad_2384.setName("2384"); // NOI18N

        jLabel_336.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_336.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_336.setText("* Esta pregunta es obligatoria.");
        jLabel_336.setName("lbl_336"); // NOI18N

        javax.swing.GroupLayout jPanel_336Layout = new javax.swing.GroupLayout(jPanel_336);
        jPanel_336.setLayout(jPanel_336Layout);
        jPanel_336Layout.setHorizontalGroup(
            jPanel_336Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_336Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_336Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_336)
                    .addComponent(rad_2380)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2381)
                    .addComponent(rad_2382)
                    .addComponent(rad_2383)
                    .addComponent(rad_2384))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_336Layout.setVerticalGroup(
            jPanel_336Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_336Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_336)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2380)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2381)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2382)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2383)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2384)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_337.setName("337"); // NOI18N

        jLabel67.setText("<html><b>5.6. ¿Dónde utilizas principalmente el internet?</b><br/>(selecciona una opción)</html>");
        jLabel67.setName("1"); // NOI18N

        rad_2385.setText("Hogar");
        rad_2385.setName("2385"); // NOI18N

        rad_2386.setText("Trabajo");
        rad_2386.setName("2386"); // NOI18N

        rad_2387.setText("Colegio");
        rad_2387.setName("2387"); // NOI18N

        rad_2388.setText("Espacios públicos con servicio gratuito");
        rad_2388.setName("2388"); // NOI18N

        rad_2389.setText("Lugar pagado como cyber café o centro de llamadas");
        rad_2389.setName("2389"); // NOI18N

        jLabel_337.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_337.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_337.setText("* Esta pregunta es obligatoria.");
        jLabel_337.setName("lbl_337"); // NOI18N

        javax.swing.GroupLayout jPanel_337Layout = new javax.swing.GroupLayout(jPanel_337);
        jPanel_337.setLayout(jPanel_337Layout);
        jPanel_337Layout.setHorizontalGroup(
            jPanel_337Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_337Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_337Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_337)
                    .addComponent(rad_2385)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2386)
                    .addComponent(rad_2387)
                    .addComponent(rad_2388)
                    .addComponent(rad_2389))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_337Layout.setVerticalGroup(
            jPanel_337Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_337Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_337)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2385)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2386)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2387)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2388)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2389)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSec_5Layout = new javax.swing.GroupLayout(jPanelSec_5);
        jPanelSec_5.setLayout(jPanelSec_5Layout);
        jPanelSec_5Layout.setHorizontalGroup(
            jPanelSec_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSec_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_334, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_333, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_332, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_336, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_335, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_337, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        jPanelSec_5Layout.setVerticalGroup(
            jPanelSec_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_332, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_333, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_334, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_335, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_336, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_337, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane5.setViewportView(jPanelSec_5);

        jTabbedPane1.addTab("ACCESO A TECNOLOGÍA DE LA INFORMACIÓN Y COMUNICACIÓN", jScrollPane5);

        jPanel_338.setName("338"); // NOI18N

        jLabel68.setText("<html><b>6.1. ¿Cómo te enteraste  de la convocatoria para rendir la prueba ENES?</b><br/>(selecciona una opción)</html>");
        jLabel68.setName("1"); // NOI18N

        rad_2390.setText("Colegio");
        rad_2390.setName("2390"); // NOI18N

        rad_2391.setText("Familiares");
        rad_2391.setName("2391"); // NOI18N

        rad_2392.setText("Amigos/vecinos");
        rad_2392.setName("2392"); // NOI18N

        rad_2393.setText("Internet");
        rad_2393.setName("2393"); // NOI18N

        rad_2394.setText("Redes sociales");
        rad_2394.setName("2394"); // NOI18N

        rad_2395.setText("Televisión");
        rad_2395.setName("2395"); // NOI18N

        rad_2396.setText("Radio");
        rad_2396.setName("2396"); // NOI18N

        rad_2397.setText("Prensa escrita");
        rad_2397.setName("2397"); // NOI18N

        jLabel_338.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_338.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_338.setText("* Esta pregunta es obligatoria.");
        jLabel_338.setName("lbl_338"); // NOI18N

        javax.swing.GroupLayout jPanel_338Layout = new javax.swing.GroupLayout(jPanel_338);
        jPanel_338.setLayout(jPanel_338Layout);
        jPanel_338Layout.setHorizontalGroup(
            jPanel_338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_338Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_338)
                    .addComponent(rad_2390)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2391)
                    .addComponent(rad_2392)
                    .addComponent(rad_2393)
                    .addComponent(rad_2394)
                    .addComponent(rad_2395)
                    .addComponent(rad_2396)
                    .addComponent(rad_2397))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_338Layout.setVerticalGroup(
            jPanel_338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_338Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_338)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2390)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2391)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2392)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2393)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2394)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2395)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2396)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2397)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_339.setName("339"); // NOI18N

        jLabel69.setText("<html><b>6.2. ¿Cómo calificarías el acceso a educación superior que tuvieron tus padres?</b><br/>(selecciona una opción)</html>");
        jLabel69.setName("1"); // NOI18N

        rad_2398.setText("Transparente");
        rad_2398.setName("2398"); // NOI18N

        rad_2399.setText("Meritocrático");
        rad_2399.setName("2399"); // NOI18N

        rad_2400.setText("Complejo");
        rad_2400.setName("2400"); // NOI18N

        rad_2401.setText("Burocrático");
        rad_2401.setName("2401"); // NOI18N

        rad_2402.setText("Libre");
        rad_2402.setName("2402"); // NOI18N

        rad_2403.setText("Fácil");
        rad_2403.setName("2403"); // NOI18N

        rad_2404.setText("Extenso");
        rad_2404.setName("2404"); // NOI18N

        rad_2405.setText("Organizado");
        rad_2405.setName("2405"); // NOI18N

        jLabel_339.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_339.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_339.setText("* Esta pregunta es obligatoria.");
        jLabel_339.setName("lbl_339"); // NOI18N

        javax.swing.GroupLayout jPanel_339Layout = new javax.swing.GroupLayout(jPanel_339);
        jPanel_339.setLayout(jPanel_339Layout);
        jPanel_339Layout.setHorizontalGroup(
            jPanel_339Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_339Layout.createSequentialGroup()
                .addGroup(jPanel_339Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_339Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_339Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2398)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2399)
                            .addComponent(rad_2400)
                            .addComponent(rad_2401)
                            .addComponent(rad_2402)
                            .addComponent(rad_2403)
                            .addComponent(rad_2404)
                            .addComponent(rad_2405)))
                    .addGroup(jPanel_339Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_339)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_339Layout.setVerticalGroup(
            jPanel_339Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_339Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_339)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2398)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2399)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2400)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2401)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2402)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2403)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2404)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2405)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_340.setName("340"); // NOI18N

        jLabel70.setText("<html><b>6.3. ¿Actualmente consideras que el SNNA ha:</b><br/>(selecciona una opción)</html>");
        jLabel70.setName("1"); // NOI18N

        rad_2406.setText("Mejorado el acceso a educación superior?");
        rad_2406.setName("2406"); // NOI18N

        rad_2407.setText("Regularizado el acceso a educación superior?");
        rad_2407.setName("2407"); // NOI18N

        rad_2408.setText("Dificultado el acceso para los  y las aspirantes?");
        rad_2408.setName("2408"); // NOI18N

        rad_2409.setText("<html>Establecido parámetros para democratizar el<br/>acceso a educación superior?</html>");
        rad_2409.setName("2409"); // NOI18N

        jLabel_340.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_340.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_340.setText("* Esta pregunta es obligatoria.");
        jLabel_340.setName("lbl_340"); // NOI18N

        javax.swing.GroupLayout jPanel_340Layout = new javax.swing.GroupLayout(jPanel_340);
        jPanel_340.setLayout(jPanel_340Layout);
        jPanel_340Layout.setHorizontalGroup(
            jPanel_340Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_340Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_340Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_340)
                    .addComponent(rad_2406)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2407)
                    .addComponent(rad_2408)
                    .addComponent(rad_2409, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_340Layout.setVerticalGroup(
            jPanel_340Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_340Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_340)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2406)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2407)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2408)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2409, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_341.setName("341"); // NOI18N

        jLabel71.setText("<html><b>6.4. Evalúa las  siguientes afirmaciones :</b><br/>(selecciona una opción)</html>");
        jLabel71.setName("1"); // NOI18N

        javax.swing.GroupLayout jPanel_341Layout = new javax.swing.GroupLayout(jPanel_341);
        jPanel_341.setLayout(jPanel_341Layout);
        jPanel_341Layout.setHorizontalGroup(
            jPanel_341Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_341Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel_341Layout.setVerticalGroup(
            jPanel_341Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_341Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel_342.setName("342"); // NOI18N

        jLabel72.setText("<html><b>6.4.1. Los/las profesionales técnicos/as  y tecnólogos/as reciben altos sueldos.</b></html>");
        jLabel72.setName("1"); // NOI18N

        rad_2411.setText("Totalmente de acuerdo");
        rad_2411.setName("2411"); // NOI18N

        rad_2412.setText("De acuerdo");
        rad_2412.setName("2412"); // NOI18N

        rad_2413.setText("Medianamente de acuerdo");
        rad_2413.setName("2413"); // NOI18N

        rad_2414.setText("En desacuerdo");
        rad_2414.setName("2414"); // NOI18N

        rad_2415.setText("Totalmente en desacuerdo");
        rad_2415.setName("2415"); // NOI18N

        jLabel_342.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_342.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_342.setText("* Esta pregunta es obligatoria.");
        jLabel_342.setName("lbl_342"); // NOI18N

        javax.swing.GroupLayout jPanel_342Layout = new javax.swing.GroupLayout(jPanel_342);
        jPanel_342.setLayout(jPanel_342Layout);
        jPanel_342Layout.setHorizontalGroup(
            jPanel_342Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_342Layout.createSequentialGroup()
                .addGroup(jPanel_342Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_342Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_342Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2411)
                            .addComponent(jLabel_342)
                            .addComponent(rad_2412)
                            .addComponent(rad_2413)
                            .addComponent(rad_2414)
                            .addComponent(rad_2415)))
                    .addGroup(jPanel_342Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_342Layout.setVerticalGroup(
            jPanel_342Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_342Layout.createSequentialGroup()
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_342)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rad_2411)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2412)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2413)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2414)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2415)
                .addGap(7, 7, 7))
        );

        jPanel_343.setName("343"); // NOI18N

        rad_2416.setText("Totalmente de acuerdo");
        rad_2416.setName("2416"); // NOI18N

        rad_2417.setText("De acuerdo");
        rad_2417.setName("2417"); // NOI18N

        rad_2418.setText("Medianamente de acuerdo");
        rad_2418.setName("2418"); // NOI18N

        rad_2419.setText("En desacuerdo");
        rad_2419.setName("2419"); // NOI18N

        rad_2420.setText("Totalmente en desacuerdo");
        rad_2420.setName("2420"); // NOI18N
        rad_2420.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_2420ActionPerformed(evt);
            }
        });

        jLabel_343.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_343.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_343.setText("* Esta pregunta es obligatoria.");
        jLabel_343.setName("lbl_343"); // NOI18N

        jLabel73.setText("<html><b>6.4.2. La formación técnica y tecnológica permite encontrar empleo fácilmente</b></html>");
        jLabel73.setName("1"); // NOI18N

        javax.swing.GroupLayout jPanel_343Layout = new javax.swing.GroupLayout(jPanel_343);
        jPanel_343.setLayout(jPanel_343Layout);
        jPanel_343Layout.setHorizontalGroup(
            jPanel_343Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_343Layout.createSequentialGroup()
                .addGroup(jPanel_343Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_343Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_343Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_343)
                            .addComponent(rad_2418)
                            .addComponent(rad_2419)
                            .addComponent(rad_2420)
                            .addComponent(rad_2416)
                            .addComponent(rad_2417)))
                    .addGroup(jPanel_343Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_343Layout.setVerticalGroup(
            jPanel_343Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_343Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_343)
                .addGap(0, 0, 0)
                .addComponent(rad_2416)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2417)
                .addGap(0, 0, 0)
                .addComponent(rad_2418)
                .addGap(0, 0, 0)
                .addComponent(rad_2419)
                .addGap(0, 0, 0)
                .addComponent(rad_2420))
        );

        jPanel_344.setName("344"); // NOI18N

        jLabel74.setText("<html><b>6.4.3. La educación técnica y tecnológica puede formarme en habilidades<br/>para el desarrollo personal</b></html>");
        jLabel74.setName("1"); // NOI18N

        rad_2421.setText("Totalmente de acuerdo");
        rad_2421.setName("2421"); // NOI18N

        rad_2422.setText("De acuerdo");
        rad_2422.setName("2422"); // NOI18N

        rad_2423.setText("Medianamente de acuerdo");
        rad_2423.setName("2423"); // NOI18N

        rad_2424.setText("En desacuerdo");
        rad_2424.setName("2424"); // NOI18N

        rad_2425.setText("Totalmente en desacuerdo");
        rad_2425.setName("2425"); // NOI18N

        jLabel_344.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_344.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_344.setText("* Esta pregunta es obligatoria.");
        jLabel_344.setName("lbl_344"); // NOI18N

        javax.swing.GroupLayout jPanel_344Layout = new javax.swing.GroupLayout(jPanel_344);
        jPanel_344.setLayout(jPanel_344Layout);
        jPanel_344Layout.setHorizontalGroup(
            jPanel_344Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_344Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_344Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_344)
                    .addComponent(rad_2421)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2422)
                    .addComponent(rad_2423)
                    .addComponent(rad_2424)
                    .addComponent(rad_2425))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_344Layout.setVerticalGroup(
            jPanel_344Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_344Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_344)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2421)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2422)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2423)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2424)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2425)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_345.setName("345"); // NOI18N

        jLabel75.setText("<html><b>6.4.4. Prefiero estudiar en un Instituto técnico o tecnológico que en la universidad</b></html>");
        jLabel75.setName("1"); // NOI18N

        rad_2426.setText("Totalmente de acuerdo");
        rad_2426.setName("2426"); // NOI18N

        rad_2427.setText("De acuerdo");
        rad_2427.setName("2427"); // NOI18N

        rad_2428.setText("Medianamente de acuerdo");
        rad_2428.setName("2428"); // NOI18N

        rad_2429.setText("En desacuerdo");
        rad_2429.setName("2429"); // NOI18N

        rad_2430.setText("Totalmente en desacuerdo");
        rad_2430.setName("2430"); // NOI18N

        jLabel_345.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_345.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_345.setText("* Esta pregunta es obligatoria.");
        jLabel_345.setName("lbl_345"); // NOI18N

        javax.swing.GroupLayout jPanel_345Layout = new javax.swing.GroupLayout(jPanel_345);
        jPanel_345.setLayout(jPanel_345Layout);
        jPanel_345Layout.setHorizontalGroup(
            jPanel_345Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_345Layout.createSequentialGroup()
                .addGroup(jPanel_345Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_345Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_345Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2426)
                            .addComponent(jLabel_345)
                            .addComponent(rad_2427)
                            .addComponent(rad_2428)
                            .addComponent(rad_2429)
                            .addComponent(rad_2430)))
                    .addGroup(jPanel_345Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_345Layout.setVerticalGroup(
            jPanel_345Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_345Layout.createSequentialGroup()
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_345)
                .addGap(0, 0, 0)
                .addComponent(rad_2426)
                .addGap(0, 0, 0)
                .addComponent(rad_2427)
                .addGap(0, 0, 0)
                .addComponent(rad_2428)
                .addGap(0, 0, 0)
                .addComponent(rad_2429)
                .addGap(0, 0, 0)
                .addComponent(rad_2430))
        );

        jPanel_346.setName("346"); // NOI18N

        jLabel76.setText("<html><b>6.4.5. La formación técnica y tecnológica es de baja calidad comparada con la<br/>formación universitaria</b></html>");
        jLabel76.setName("1"); // NOI18N

        rad_2431.setText("Totalmente de acuerdo");
        rad_2431.setName("2431"); // NOI18N

        rad_2432.setText("De acuerdo");
        rad_2432.setName("2432"); // NOI18N

        rad_2433.setText("Medianamente de acuerdo");
        rad_2433.setName("2433"); // NOI18N

        rad_2434.setText("En desacuerdo");
        rad_2434.setName("2434"); // NOI18N

        rad_2435.setText("Totalmente en desacuerdo");
        rad_2435.setName("2435"); // NOI18N

        jLabel_346.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_346.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_346.setText("* Esta pregunta es obligatoria.");
        jLabel_346.setName("lbl_346"); // NOI18N

        javax.swing.GroupLayout jPanel_346Layout = new javax.swing.GroupLayout(jPanel_346);
        jPanel_346.setLayout(jPanel_346Layout);
        jPanel_346Layout.setHorizontalGroup(
            jPanel_346Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_346Layout.createSequentialGroup()
                .addGroup(jPanel_346Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_346Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_346Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2431)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2432)
                            .addComponent(rad_2433)
                            .addComponent(rad_2434)
                            .addComponent(rad_2435)))
                    .addGroup(jPanel_346Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_346)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_346Layout.setVerticalGroup(
            jPanel_346Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_346Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_346)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2431)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2432)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2433)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2434)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2435)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_347.setName("347"); // NOI18N

        jLabel77.setText("<html><b>6.4.6. A continuación te pedimos que evalúes los siguientes aspectos de tu<br/>formación de bachillerato. Selecciona la opción que esté acorde a tu opinión.</b><br/>(selecciona una opción)</html>");
        jLabel77.setName("1"); // NOI18N

        javax.swing.GroupLayout jPanel_347Layout = new javax.swing.GroupLayout(jPanel_347);
        jPanel_347.setLayout(jPanel_347Layout);
        jPanel_347Layout.setHorizontalGroup(
            jPanel_347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_347Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77)
                .addContainerGap())
        );
        jPanel_347Layout.setVerticalGroup(
            jPanel_347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_347Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel_348.setName("348"); // NOI18N

        jLabel78.setText("<html><b>6.4.6.1. Infraestructura del colegio</b><br/>(aulas, baños, laboratorios, biblioteca, comedor, patio, canchas, etc.)</html>");
        jLabel78.setName("1"); // NOI18N

        rad_2437.setText("Totalmente satisfecho");
        rad_2437.setName("2437"); // NOI18N

        rad_2438.setText("Satisfecho");
        rad_2438.setName("2438"); // NOI18N

        rad_2439.setText("Medianamente satisfecho");
        rad_2439.setName("2439"); // NOI18N

        rad_2440.setText("Insatisfecho");
        rad_2440.setName("2440"); // NOI18N

        rad_2441.setText("Totalmente insatisfecho");
        rad_2441.setName("2441"); // NOI18N

        jLabel_348.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_348.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_348.setText("* Esta pregunta es obligatoria.");
        jLabel_348.setName("lbl_348"); // NOI18N

        javax.swing.GroupLayout jPanel_348Layout = new javax.swing.GroupLayout(jPanel_348);
        jPanel_348.setLayout(jPanel_348Layout);
        jPanel_348Layout.setHorizontalGroup(
            jPanel_348Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_348Layout.createSequentialGroup()
                .addGroup(jPanel_348Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_348Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_348Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2437)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2438)
                            .addComponent(rad_2439)
                            .addComponent(rad_2440)
                            .addComponent(rad_2441)))
                    .addGroup(jPanel_348Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_348)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_348Layout.setVerticalGroup(
            jPanel_348Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_348Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_348)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2437)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2438)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2439)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2440)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2441)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_349.setName("349"); // NOI18N

        jLabel79.setText("<html><b>6.4.6.2. Ambiente sin violencia (la violencia puede incluir violencia física,<br/>verbal, psicológica, bullying, racismo, discriminación, etc.) entre estudiantes</b></html>");
        jLabel79.setName("1"); // NOI18N

        rad_2442.setText("Totalmente satisfecho");
        rad_2442.setName("2442"); // NOI18N

        rad_2443.setText("Satisfecho");
        rad_2443.setName("2443"); // NOI18N

        rad_2444.setText("Medianamente satisfecho");
        rad_2444.setName("2444"); // NOI18N

        rad_2445.setText("Insatisfecho");
        rad_2445.setName("2445"); // NOI18N

        rad_2446.setText("Totalmente insatisfecho");
        rad_2446.setName("2446"); // NOI18N

        jLabel_349.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_349.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_349.setText("* Esta pregunta es obligatoria.");
        jLabel_349.setName("lbl_349"); // NOI18N

        javax.swing.GroupLayout jPanel_349Layout = new javax.swing.GroupLayout(jPanel_349);
        jPanel_349.setLayout(jPanel_349Layout);
        jPanel_349Layout.setHorizontalGroup(
            jPanel_349Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_349Layout.createSequentialGroup()
                .addGroup(jPanel_349Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_349Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_349Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2442)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2443)
                            .addComponent(rad_2444)
                            .addComponent(rad_2445)
                            .addComponent(rad_2446)))
                    .addGroup(jPanel_349Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_349)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_349Layout.setVerticalGroup(
            jPanel_349Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_349Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_349)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2442)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2443)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2444)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2445)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2446)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_350.setName("350"); // NOI18N

        jLabel80.setText("<html><b>6.4.6.3. Ambiente sin violencia (la violencia puede incluir violencia física,<br/>verbal, psicológica, bullying, racismo, discriminación, etc.) entre estudiantes<br/>y docentes.</b></html>");
        jLabel80.setName("1"); // NOI18N

        rad_2447.setText("Totalmente satisfecho");
        rad_2447.setName("2447"); // NOI18N

        rad_2448.setText("Satisfecho");
        rad_2448.setName("2448"); // NOI18N

        rad_2449.setText("Medianamente satisfecho");
        rad_2449.setName("2449"); // NOI18N

        rad_2450.setText("Insatisfecho");
        rad_2450.setName("2450"); // NOI18N

        rad_2451.setText("Totalmente insatisfecho");
        rad_2451.setName("2451"); // NOI18N

        jLabel_350.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_350.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_350.setText("* Esta pregunta es obligatoria.");
        jLabel_350.setName("lbl_350"); // NOI18N

        javax.swing.GroupLayout jPanel_350Layout = new javax.swing.GroupLayout(jPanel_350);
        jPanel_350.setLayout(jPanel_350Layout);
        jPanel_350Layout.setHorizontalGroup(
            jPanel_350Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_350Layout.createSequentialGroup()
                .addGroup(jPanel_350Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_350Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_350Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2447)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2448)
                            .addComponent(rad_2449)
                            .addComponent(rad_2450)
                            .addComponent(rad_2451)))
                    .addGroup(jPanel_350Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_350)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_350Layout.setVerticalGroup(
            jPanel_350Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_350Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_350)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2447)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2448)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2449)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2450)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2451)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_351.setName("351"); // NOI18N

        jLabel81.setText("<html><b>6.4.6.4. Orientación vocacional en el colegio para selección de carrera<br/>y elaboración de proyecto de vida.</b></html>");
        jLabel81.setName("1"); // NOI18N

        rad_2452.setText("Totalmente satisfecho");
        rad_2452.setName("2452"); // NOI18N

        rad_2453.setText("Satisfecho");
        rad_2453.setName("2453"); // NOI18N

        rad_2454.setText("Medianamente satisfecho");
        rad_2454.setName("2454"); // NOI18N

        rad_2455.setText("Insatisfecho");
        rad_2455.setName("2455"); // NOI18N

        rad_2456.setText("Totalmente insatisfecho");
        rad_2456.setName("2456"); // NOI18N

        jLabel_351.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_351.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_351.setText("* Esta pregunta es obligatoria.");
        jLabel_351.setName("lbl_351"); // NOI18N

        javax.swing.GroupLayout jPanel_351Layout = new javax.swing.GroupLayout(jPanel_351);
        jPanel_351.setLayout(jPanel_351Layout);
        jPanel_351Layout.setHorizontalGroup(
            jPanel_351Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_351Layout.createSequentialGroup()
                .addGroup(jPanel_351Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_351Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_351Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2452)
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2453)
                            .addComponent(rad_2454)
                            .addComponent(rad_2455)
                            .addComponent(rad_2456)))
                    .addGroup(jPanel_351Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_351)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_351Layout.setVerticalGroup(
            jPanel_351Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_351Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_351)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2452)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2453)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2454)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2455)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2456)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_352.setName("352"); // NOI18N

        jLabel82.setText("<html><b>6.4.6.5.Existencia de sistema de acompañamiento (tutoría) durante<br/>tu permanencia en la institución</b></html>");
        jLabel82.setName("1"); // NOI18N

        rad_2457.setText("Totalmente satisfecho");
        rad_2457.setName("2457"); // NOI18N

        rad_2458.setText("Satisfecho");
        rad_2458.setName("2458"); // NOI18N

        rad_2459.setText("Medianamente satisfecho");
        rad_2459.setName("2459"); // NOI18N

        rad_2460.setText("Insatisfecho");
        rad_2460.setName("2460"); // NOI18N

        rad_2461.setText("Totalmente insatisfecho");
        rad_2461.setName("2461"); // NOI18N

        jLabel_352.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_352.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_352.setText("* Esta pregunta es obligatoria.");
        jLabel_352.setName("lbl_352"); // NOI18N

        javax.swing.GroupLayout jPanel_352Layout = new javax.swing.GroupLayout(jPanel_352);
        jPanel_352.setLayout(jPanel_352Layout);
        jPanel_352Layout.setHorizontalGroup(
            jPanel_352Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_352Layout.createSequentialGroup()
                .addGroup(jPanel_352Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_352Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_352Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_2457)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rad_2458)
                            .addComponent(rad_2459)
                            .addComponent(rad_2460)
                            .addComponent(rad_2461)))
                    .addGroup(jPanel_352Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_352)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_352Layout.setVerticalGroup(
            jPanel_352Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_352Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_352)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2457)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2458)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2459)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2460)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2461)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_353.setName("353"); // NOI18N

        jLabel83.setText("<html><b>6.4.6.6. Los conocimientos y aprendizajes adquiridos en tu colegio<br/>te son útiles en tu vida.</b></html>");
        jLabel83.setName("1"); // NOI18N

        rad_2462.setText("Totalmente satisfecho");
        rad_2462.setName("2462"); // NOI18N

        rad_2463.setText("Satisfecho");
        rad_2463.setName("2463"); // NOI18N

        rad_2464.setText("Medianamente satisfecho");
        rad_2464.setName("2464"); // NOI18N

        rad_2465.setText("Insatisfecho");
        rad_2465.setName("2465"); // NOI18N

        rad_2466.setText("Totalmente insatisfecho");
        rad_2466.setName("2466"); // NOI18N

        jLabel_353.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_353.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_353.setText("* Esta pregunta es obligatoria.");
        jLabel_353.setName("lbl_353"); // NOI18N

        javax.swing.GroupLayout jPanel_353Layout = new javax.swing.GroupLayout(jPanel_353);
        jPanel_353.setLayout(jPanel_353Layout);
        jPanel_353Layout.setHorizontalGroup(
            jPanel_353Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_353Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_353Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_353)
                    .addComponent(rad_2462)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_2463)
                    .addComponent(rad_2464)
                    .addComponent(rad_2465)
                    .addComponent(rad_2466))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_353Layout.setVerticalGroup(
            jPanel_353Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_353Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_353)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_2462)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2463)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2464)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2465)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_2466)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSec_6Layout = new javax.swing.GroupLayout(jPanelSec_6);
        jPanelSec_6.setLayout(jPanelSec_6Layout);
        jPanelSec_6Layout.setHorizontalGroup(
            jPanelSec_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSec_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_341, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_343, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_344, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_342, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_345, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_340, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_339, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_346, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_347, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_348, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_349, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_350, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_351, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_352, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_353, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        jPanelSec_6Layout.setVerticalGroup(
            jPanelSec_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_339, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_340, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_341, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_342, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_343, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_344, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_345, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_346, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_347, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_348, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_349, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_350, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_351, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_352, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_353, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane6.setViewportView(jPanelSec_6);

        jTabbedPane1.addTab("PERCEPCIONES", jScrollPane6);

        jButton_Sigueinte.setText("Siguiente");
        jButton_Sigueinte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SigueinteActionPerformed(evt);
            }
        });

        jButton_Atras.setText("Atrás");
        jButton_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AtrasActionPerformed(evt);
            }
        });

        jPanel_DatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(153, 153, 153)));

        jLabel20.setText("Cédula:");

        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyTyped(evt);
            }
        });

        jLabel23.setText("Nombres:");

        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombresKeyTyped(evt);
            }
        });

        jLabel24.setText("Apellidos:");

        txt_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidosKeyTyped(evt);
            }
        });

        jButton_activarEncuesta.setText("Activar Encuesta");
        jButton_activarEncuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_activarEncuestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_DatosPersonalesLayout = new javax.swing.GroupLayout(jPanel_DatosPersonales);
        jPanel_DatosPersonales.setLayout(jPanel_DatosPersonalesLayout);
        jPanel_DatosPersonalesLayout.setHorizontalGroup(
            jPanel_DatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_DatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_DatosPersonalesLayout.createSequentialGroup()
                        .addGroup(jPanel_DatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_DatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_DatosPersonalesLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_apellidos)))
                .addGap(106, 106, 106)
                .addComponent(jButton_activarEncuesta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_DatosPersonalesLayout.setVerticalGroup(
            jPanel_DatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DatosPersonalesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton_activarEncuesta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_DatosPersonalesLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel_DatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel_DatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(3, 3, 3)
                .addGroup(jPanel_DatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton_Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Sigueinte)
                                .addGap(58, 58, 58))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_DatosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_DatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Sigueinte)
                    .addComponent(jButton_Atras))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SigueinteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SigueinteActionPerformed
        validaSiguiente();
    }//GEN-LAST:event_jButton_SigueinteActionPerformed

    private void jButton_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AtrasActionPerformed
        // TODO add your handling code here:
        int i = jTabbedPane1.getSelectedIndex();
        if (i > 0) {
            i--;
        }
        jTabbedPane1.setSelectedIndex(i);
        index = i;
        //OPTIMIZAR
        //obtenerRespuestasPorSeccion(jPanelSec_1);
    }//GEN-LAST:event_jButton_AtrasActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        index = jTabbedPane1.getSelectedIndex() + 1;
        switch(index){
            case 1:
                jButton_Sigueinte.setText("Siguiente");
            break;
            case 2:
                jButton_Sigueinte.setText("Siguiente");
            break;
            case 3:
                jButton_Sigueinte.setText("Siguiente");
            break;
            case 4:
                jButton_Sigueinte.setText("Siguiente");
            break;
            case 5:
                jButton_Sigueinte.setText("Siguiente");
            break;
            case 6:
                jButton_Sigueinte.setText("Finalizar");
            break;
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(index);
    }//GEN-LAST:event_jTabbedPane1MousePressed

    private void jTabbedPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseEntered

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        //jTabbedPane1.setSelectedIndex(index);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jScrollPane1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPane1FocusLost

    private void jButton_activarEncuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_activarEncuestaActionPerformed
        // TODO add your handling code here:
        if(txt_cedula.getText().isEmpty() || txt_nombres.getText().isEmpty() || txt_apellidos.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            switch(jButton_activarEncuesta.getText()){
                case "Activar Encuesta":
                    for(Component c: jPanelSec_1.getComponents()){
                        if(c instanceof JPanel && ((JPanel)c).isVisible()){
                            for(Component d: ((JPanel)c).getComponents()){
                                d.setEnabled(true);
                            }
                        }
                    }
                    for(Component c: jPanelSec_2.getComponents()){
                        if(c instanceof JPanel && ((JPanel)c).isVisible()){
                            for(Component d: ((JPanel)c).getComponents()){
                                d.setEnabled(true);
                            }
                        }
                    }
                    for(Component c: jPanelSec_3.getComponents()){
                        if(c instanceof JPanel && ((JPanel)c).isVisible()){
                            for(Component d: ((JPanel)c).getComponents()){
                                d.setEnabled(true);
                            }
                        }
                    }
                    for(Component c: jPanelSec_4.getComponents()){
                        if(c instanceof JPanel && ((JPanel)c).isVisible()){
                            for(Component d: ((JPanel)c).getComponents()){
                                d.setEnabled(true);
                            }
                        }
                    }
                    for(Component c: jPanelSec_5.getComponents()){
                        if(c instanceof JPanel && ((JPanel)c).isVisible()){
                            for(Component d: ((JPanel)c).getComponents()){
                                d.setEnabled(true);
                            }
                        }
                    }
                    for(Component c: jPanelSec_6.getComponents()){
                        if(c instanceof JPanel && ((JPanel)c).isVisible()){
                            for(Component d: ((JPanel)c).getComponents()){
                                d.setEnabled(true);
                            }
                        }
                    }
                    jButton_Atras.setEnabled(true);
                    jButton_Sigueinte.setEnabled(true);
                    txt_cedula.setEnabled(false);
                    txt_nombres.setEnabled(false);
                    txt_apellidos.setEnabled(false);
                    jButton_activarEncuesta.setText("Editar");
                    if(index > 0){
                        cargarXml();
                    }
                    for(int i=0;i<=index;i++){
                        jTabbedPane1.setEnabledAt(i,true);
                    }
                break;
                case "Editar":
                    txt_cedula.setEnabled(true);
                    txt_nombres.setEnabled(true);
                    txt_apellidos.setEnabled(true);
                    bloqueaPestanias(-1);
                    jButton_activarEncuesta.setText("Activar Encuesta");
                break;
            }
        }
    }//GEN-LAST:event_jButton_activarEncuestaActionPerformed

    private void txt_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyTyped
       soloNumeros(evt,10);
    }//GEN-LAST:event_txt_cedulaKeyTyped

    private void txt_nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombresKeyTyped
        soloLetras(evt,20);
    }//GEN-LAST:event_txt_nombresKeyTyped

    private void txt_apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidosKeyTyped
        soloLetras(evt,20);
    }//GEN-LAST:event_txt_apellidosKeyTyped

    private void rad_2152ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2152ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad_2152ActionPerformed

    private void rad_2138ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2138ActionPerformed
        if(rad_2138.isSelected()){
            muestraOcultaPanel(jPanel_295, false);
            muestraOcultaPanel(jPanel_297, false);
            muestraOcultaPanel(jPanel_311, false);
            muestraOcultaPanel(jPanel_312, false);
            muestraOcultaPanel(jPanel_315, false);
            habilitaDeshabilitaComponentesRango(2297, 2297, false);
        }
    }//GEN-LAST:event_rad_2138ActionPerformed

    private void rad_2137ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2137ActionPerformed
        if(rad_2137.isSelected()){
            muestraOcultaPanel(jPanel_295, false);
            muestraOcultaPanel(jPanel_297, true);
            muestraOcultaPanel(jPanel_311, true);
            muestraOcultaPanel(jPanel_315, true);
            habilitaDeshabilitaComponentesRango(2297, 2297, true);
        }
    }//GEN-LAST:event_rad_2137ActionPerformed

    private void rad_2136ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2136ActionPerformed
        if(rad_2136.isSelected()){
            muestraOcultaPanel(jPanel_295, false);
            muestraOcultaPanel(jPanel_297, true);
            muestraOcultaPanel(jPanel_311, true);
            muestraOcultaPanel(jPanel_315, true);
            habilitaDeshabilitaComponentesRango(2297, 2297, true);
        }
    }//GEN-LAST:event_rad_2136ActionPerformed

    private void rad_2135ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2135ActionPerformed
        if(rad_2135.isSelected()){
            muestraOcultaPanel(jPanel_295, false);
            muestraOcultaPanel(jPanel_297, true);
            muestraOcultaPanel(jPanel_311, true);
            muestraOcultaPanel(jPanel_315, true);
            habilitaDeshabilitaComponentesRango(2297, 2297, true);
        }
    }//GEN-LAST:event_rad_2135ActionPerformed

    private void rad_2134ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2134ActionPerformed
        if(rad_2134.isSelected()){
            muestraOcultaPanel(jPanel_295, false);
            muestraOcultaPanel(jPanel_297, true);
            muestraOcultaPanel(jPanel_311, true);
            muestraOcultaPanel(jPanel_315, true);
            habilitaDeshabilitaComponentesRango(2297, 2297, true);
        }
    }//GEN-LAST:event_rad_2134ActionPerformed

    private void rad_2133ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2133ActionPerformed
        if(rad_2133.isSelected()){
            muestraOcultaPanel(jPanel_295, false);
            muestraOcultaPanel(jPanel_297, true);
            muestraOcultaPanel(jPanel_311, true);
            muestraOcultaPanel(jPanel_315, true);
            habilitaDeshabilitaComponentesRango(2297, 2297, true);
        }
    }//GEN-LAST:event_rad_2133ActionPerformed

    private void rad_2132ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2132ActionPerformed
        if(rad_2132.isSelected()){
            muestraOcultaPanel(jPanel_295, false);
            muestraOcultaPanel(jPanel_297, true);
            muestraOcultaPanel(jPanel_311, true);
            muestraOcultaPanel(jPanel_315, true);
            habilitaDeshabilitaComponentesRango(2297, 2297, true);
        }
    }//GEN-LAST:event_rad_2132ActionPerformed

    private void rad_2131ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2131ActionPerformed
        if(rad_2131.isSelected()){
            muestraOcultaPanel(jPanel_295, true);
            muestraOcultaPanel(jPanel_297, true);
            muestraOcultaPanel(jPanel_311, true);
            muestraOcultaPanel(jPanel_315, true);
            habilitaDeshabilitaComponentesRango(2297, 2297, true);
        }
    }//GEN-LAST:event_rad_2131ActionPerformed

    private void rad_2102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2102ActionPerformed
        if(rad_2102.isSelected()){
            muestraOcultaPanel(jPanel_293, false);
            muestraOcultaPanel(jPanel_296, false);
            muestraOcultaPanel(jPanel_309,false);
            muestraOcultaPanel(jPanel_310,false);
            muestraOcultaPanel(jPanel_314,false);
            habilitaDeshabilitaComponentesRango(2296, 2296, false);
        }
    }//GEN-LAST:event_rad_2102ActionPerformed

    private void rad_2101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2101ActionPerformed
        if(rad_2101.isSelected()){
            muestraOcultaPanel(jPanel_293, false);
            muestraOcultaPanel(jPanel_296, true);
            muestraOcultaPanel(jPanel_309,true);
            muestraOcultaPanel(jPanel_314,true);
            habilitaDeshabilitaComponentesRango(2296, 2296, true);
        }
    }//GEN-LAST:event_rad_2101ActionPerformed

    private void rad_2100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2100ActionPerformed
        if(rad_2100.isSelected()){
            muestraOcultaPanel(jPanel_293, false);
            muestraOcultaPanel(jPanel_296, true);
            muestraOcultaPanel(jPanel_309,true);
            muestraOcultaPanel(jPanel_314,true);
            habilitaDeshabilitaComponentesRango(2296, 2296, true);
        }
    }//GEN-LAST:event_rad_2100ActionPerformed

    private void rad_2099ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2099ActionPerformed
        if(rad_2099.isSelected()){
            muestraOcultaPanel(jPanel_293, false);
            muestraOcultaPanel(jPanel_296, true);
            muestraOcultaPanel(jPanel_309,true);
            muestraOcultaPanel(jPanel_314,true);
            habilitaDeshabilitaComponentesRango(2296, 2296, true);
        }
    }//GEN-LAST:event_rad_2099ActionPerformed

    private void rad_2098ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2098ActionPerformed
        if(rad_2098.isSelected()){
            muestraOcultaPanel(jPanel_293, false);
            muestraOcultaPanel(jPanel_296, true);
            muestraOcultaPanel(jPanel_309,true);
            muestraOcultaPanel(jPanel_314,true);
            habilitaDeshabilitaComponentesRango(2296, 2296, true);
        }
    }//GEN-LAST:event_rad_2098ActionPerformed

    private void rad_2097ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2097ActionPerformed
        if(rad_2097.isSelected()){
            muestraOcultaPanel(jPanel_293, false);
            muestraOcultaPanel(jPanel_296, true);
            muestraOcultaPanel(jPanel_309,true);
            muestraOcultaPanel(jPanel_314,true);
            habilitaDeshabilitaComponentesRango(2296, 2296, true);
        }
    }//GEN-LAST:event_rad_2097ActionPerformed

    private void rad_2096ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2096ActionPerformed
        if(rad_2096.isSelected()){
            muestraOcultaPanel(jPanel_293, false);
            muestraOcultaPanel(jPanel_296, true);
            muestraOcultaPanel(jPanel_309,true);
            muestraOcultaPanel(jPanel_314,true);
            habilitaDeshabilitaComponentesRango(2296, 2296, true);
        }
    }//GEN-LAST:event_rad_2096ActionPerformed

    private void rad_2095ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2095ActionPerformed
        if(rad_2095.isSelected()){
            muestraOcultaPanel(jPanel_293, true);
            muestraOcultaPanel(jPanel_296, true);
            muestraOcultaPanel(jPanel_309,true);
            muestraOcultaPanel(jPanel_314,true);
            habilitaDeshabilitaComponentesRango(2296, 2296, true);
        }
    }//GEN-LAST:event_rad_2095ActionPerformed

    private void rad_2093ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2093ActionPerformed
        if(rad_2093.isSelected()){
            muestraOcultaPanel(jPanel_291, false);
        }
    }//GEN-LAST:event_rad_2093ActionPerformed

    private void rad_2092ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2092ActionPerformed
        if(rad_2092.isSelected()){
            muestraOcultaPanel(jPanel_291, true);
        }
    }//GEN-LAST:event_rad_2092ActionPerformed

    private void rad_1835ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1835ActionPerformed
        if(rad_1835.isSelected()){
            muestraOcultaPanel(jPanel_288, true);
        }
    }//GEN-LAST:event_rad_1835ActionPerformed

    private void rad_1834ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1834ActionPerformed
        if(rad_1834.isSelected()){
            muestraOcultaPanel(jPanel_288, true);
        }
    }//GEN-LAST:event_rad_1834ActionPerformed

    private void rad_1833ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1833ActionPerformed
        if(rad_1833.isSelected()){
            muestraOcultaPanel(jPanel_288, true);
        }
    }//GEN-LAST:event_rad_1833ActionPerformed

    private void rad_1832ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1832ActionPerformed
        if(rad_1832.isSelected()){
            muestraOcultaPanel(jPanel_288, false);
            muestraOcultaPanel(jPanel_289, true);
        }
    }//GEN-LAST:event_rad_1832ActionPerformed

    private void chk_1827ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1827ActionPerformed
        if(chk_1827.isSelected()){
            habilitaDeshabilitaComponentesRango(2217, 2217, false);
        }else{
            habilitaDeshabilitaComponentesRango(2217, 2217, true);
        }
    }//GEN-LAST:event_chk_1827ActionPerformed

    private void rad_1823ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1823ActionPerformed
        if(rad_1823.isSelected()){
            muestraOcultaPanel(jPanel_286, false);
            muestraOcultaPanel(jPanel_287, false);
            muestraOcultaPanel(jPanel_288, false);
            muestraOcultaPanel(jPanel_289, false);
            muestraOcultaPanel(jPanel_290, false);
            muestraOcultaPanel(jPanel_291, false);
        }
    }//GEN-LAST:event_rad_1823ActionPerformed

    private void rad_1822ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1822ActionPerformed
        if(rad_1822.isSelected()){
            muestraOcultaPanel(jPanel_286, true);
            muestraOcultaPanel(jPanel_287, true);
            muestraOcultaPanel(jPanel_289, true);
            muestraOcultaPanel(jPanel_290, true);
        }
    }//GEN-LAST:event_rad_1822ActionPerformed

    private void rad_1813ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1813ActionPerformed
        if(rad_1813.isSelected()){
            muestraOcultaPanel(jPanel_284,false);
        }
    }//GEN-LAST:event_rad_1813ActionPerformed

    private void rad_1812ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1812ActionPerformed
        if(rad_1812.isSelected()){
            muestraOcultaPanel(jPanel_284,true);
        }
    }//GEN-LAST:event_rad_1812ActionPerformed

    private void chk_1810ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1810ActionPerformed
        if(chk_1810.isSelected()){
            habilitaDeshabilitaComponentesRango(1831,1831,false);
            habilitaDeshabilitaComponentesRango(2221,2221,false);
        }else{
            habilitaDeshabilitaComponentesRango(1831,1831,true);
            habilitaDeshabilitaComponentesRango(2221,2221,true);
        }
    }//GEN-LAST:event_chk_1810ActionPerformed

    private void chk_1809ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1809ActionPerformed

    }//GEN-LAST:event_chk_1809ActionPerformed

    private void chk_1808ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1808ActionPerformed
        if(chk_1808.isSelected()){
            habilitaDeshabilitaComponentesRango(1830,1830,false);
            habilitaDeshabilitaComponentesRango(2220,2220,false);
        }else{
            habilitaDeshabilitaComponentesRango(1830,1830,true);
            habilitaDeshabilitaComponentesRango(2220,2220,true);
        }
    }//GEN-LAST:event_chk_1808ActionPerformed

    private void chk_1807ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1807ActionPerformed
        if(chk_1807.isSelected()){
            habilitaDeshabilitaComponentesRango(1829,1829,false);
            habilitaDeshabilitaComponentesRango(2219,2219,false);
        }else{
            habilitaDeshabilitaComponentesRango(1829,1829,true);
            habilitaDeshabilitaComponentesRango(2219,2219,true);
        }
    }//GEN-LAST:event_chk_1807ActionPerformed

    private void chk_1806ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1806ActionPerformed
        if(chk_1806.isSelected()){
            habilitaDeshabilitaComponentesRango(1828,1828,false);
            habilitaDeshabilitaComponentesRango(2218,2218,false);
        }else{
            habilitaDeshabilitaComponentesRango(1828,1828,true);
            habilitaDeshabilitaComponentesRango(2218,2218,true);
        }
    }//GEN-LAST:event_chk_1806ActionPerformed

    private void chk_1805ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1805ActionPerformed
        if(chk_1805.isSelected()){
            habilitaDeshabilitaComponentesRango(1827,1827,false);
            habilitaDeshabilitaComponentesRango(2217,2217,false);
        }else{
            habilitaDeshabilitaComponentesRango(1827,1827,true);
            habilitaDeshabilitaComponentesRango(2217,2217,true);
        }
    }//GEN-LAST:event_chk_1805ActionPerformed

    private void chk_1804ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1804ActionPerformed
        if(chk_1804.isSelected()){
            habilitaDeshabilitaComponentesRango(1826,1826,false);
            habilitaDeshabilitaComponentesRango(2138,2138,false);
            habilitaDeshabilitaComponentesRango(2216,2216,false);
        }else{
            habilitaDeshabilitaComponentesRango(1826,1826,true);
            habilitaDeshabilitaComponentesRango(2138,2138,true);
            habilitaDeshabilitaComponentesRango(2216,2216,true);
        }
    }//GEN-LAST:event_chk_1804ActionPerformed

    private void chk_1803ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1803ActionPerformed
        if(chk_1803.isSelected()){
            habilitaDeshabilitaComponentesRango(1825,1825,false);
            habilitaDeshabilitaComponentesRango(2102,2102,false);
            habilitaDeshabilitaComponentesRango(2215,2215,false);
        }else{
            habilitaDeshabilitaComponentesRango(1825,1825,true);
            habilitaDeshabilitaComponentesRango(2102,2102,true);
            habilitaDeshabilitaComponentesRango(2215,2215,true);
        }
    }//GEN-LAST:event_chk_1803ActionPerformed

    private void chk_1802ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1802ActionPerformed
        if(chk_1802.isSelected()){
            habilitaDeshabilitaComponentesRango(1803,1811,false);
            habilitaDeshabilitaComponentesRango(1824,1831,true);
            habilitaDeshabilitaComponentesRango(2215,2221,true);
            habilitaDeshabilitaComponentesRango(2095,2102,true);
            habilitaDeshabilitaComponentesRango(2131,2138,true);
        }else{
            habilitaDeshabilitaComponentesRango(1803,1811,true);
        }
    }//GEN-LAST:event_chk_1802ActionPerformed

    private void rad_2420ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2420ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad_2420ActionPerformed

    private void rad_2168ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2168ActionPerformed
        if(rad_2168.isSelected()){
            muestraOcultaPanel(jPanel_356,true);
            muestraOcultaPanel(jPanel_360,false);
        }
    }//GEN-LAST:event_rad_2168ActionPerformed

    private void rad_2169ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2169ActionPerformed
        if(rad_2169.isSelected()){
            muestraOcultaPanel(jPanel_360,true);
            muestraOcultaPanel(jPanel_356,false);
        }
    }//GEN-LAST:event_rad_2169ActionPerformed

    private void rad_2167ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2167ActionPerformed
        if(rad_2167.isSelected()){
            muestraOcultaPanel(jPanel_360,false);
            muestraOcultaPanel(jPanel_356,false);
        }
    }//GEN-LAST:event_rad_2167ActionPerformed

    private void rad_2170ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2170ActionPerformed
        if(rad_2170.isSelected()){
            muestraOcultaPanel(jPanel_360,false);
            muestraOcultaPanel(jPanel_356,false);
        }
    }//GEN-LAST:event_rad_2170ActionPerformed

    private void rad_2171ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2171ActionPerformed
        if(rad_2171.isSelected()){
            muestraOcultaPanel(jPanel_358,false);
            muestraOcultaPanel(jPanel_362,false);
        }
    }//GEN-LAST:event_rad_2171ActionPerformed

    private void rad_2172ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2172ActionPerformed
        if(rad_2172.isSelected()){
            muestraOcultaPanel(jPanel_358,true);
            muestraOcultaPanel(jPanel_362,false);
        }
    }//GEN-LAST:event_rad_2172ActionPerformed

    private void rad_2173ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2173ActionPerformed
        if(rad_2173.isSelected()){
            muestraOcultaPanel(jPanel_358,false);
            muestraOcultaPanel(jPanel_362,true);
        }
    }//GEN-LAST:event_rad_2173ActionPerformed

    private void rad_2174ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2174ActionPerformed
        if(rad_2174.isSelected()){
            muestraOcultaPanel(jPanel_358,false);
            muestraOcultaPanel(jPanel_362,false);
        }
    }//GEN-LAST:event_rad_2174ActionPerformed

    private void txt_2094KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_2094KeyTyped
        soloNumerosRango(evt, 5, 1, 10000);
    }//GEN-LAST:event_txt_2094KeyTyped

    private void rad_2182ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2182ActionPerformed
        if(rad_2182.isSelected()){
            muestraOcultaPanel(jPanel_299,true);
            muestraOcultaPanel(jPanel_300,true);
            muestraOcultaPanel(jPanel_301,true);
            muestraOcultaPanel(jPanel_302,true);
            muestraOcultaPanel(jPanel_303,true);
            muestraOcultaPanel(jPanel_304,true);
            muestraOcultaPanel(jPanel_305,true);
            muestraOcultaPanel(jPanel_306,true);
        }
    }//GEN-LAST:event_rad_2182ActionPerformed

    private void rad_2181ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2181ActionPerformed
        if(rad_2181.isSelected()){
            muestraOcultaPanel(jPanel_299,false);
            muestraOcultaPanel(jPanel_300,true);
            muestraOcultaPanel(jPanel_301,true);
            muestraOcultaPanel(jPanel_302,true);
            muestraOcultaPanel(jPanel_303,true);
            muestraOcultaPanel(jPanel_304,true);
            muestraOcultaPanel(jPanel_305,true);
            muestraOcultaPanel(jPanel_306,true);
        }
    }//GEN-LAST:event_rad_2181ActionPerformed

    private void rad_2180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2180ActionPerformed
        if(rad_2180.isSelected()){
            muestraOcultaPanel(jPanel_299,false);
            muestraOcultaPanel(jPanel_300,true);
            muestraOcultaPanel(jPanel_301,true);
            muestraOcultaPanel(jPanel_302,true);
            muestraOcultaPanel(jPanel_303,true);
            muestraOcultaPanel(jPanel_304,true);
            muestraOcultaPanel(jPanel_305,true);
            muestraOcultaPanel(jPanel_306,true);
        }
    }//GEN-LAST:event_rad_2180ActionPerformed

    private void rad_2179ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2179ActionPerformed
        if(rad_2179.isSelected()){
            muestraOcultaPanel(jPanel_299,false);
            muestraOcultaPanel(jPanel_300,true);
            muestraOcultaPanel(jPanel_301,true);
            muestraOcultaPanel(jPanel_302,true);
            muestraOcultaPanel(jPanel_303,true);
            muestraOcultaPanel(jPanel_304,true);
            muestraOcultaPanel(jPanel_305,true);
            muestraOcultaPanel(jPanel_306,true);
        }
    }//GEN-LAST:event_rad_2179ActionPerformed

    private void rad_2178ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2178ActionPerformed
        if(rad_2178.isSelected()){
            muestraOcultaPanel(jPanel_299,false);
            muestraOcultaPanel(jPanel_300,true);
            muestraOcultaPanel(jPanel_301,true);
            muestraOcultaPanel(jPanel_302,true);
            muestraOcultaPanel(jPanel_303,true);
            muestraOcultaPanel(jPanel_304,true);
            muestraOcultaPanel(jPanel_305,true);
            muestraOcultaPanel(jPanel_306,true);
        }
    }//GEN-LAST:event_rad_2178ActionPerformed

    private void rad_2177ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2177ActionPerformed
        if(rad_2177.isSelected()){
            muestraOcultaPanel(jPanel_299,false);
            muestraOcultaPanel(jPanel_300,true);
            muestraOcultaPanel(jPanel_301,true);
            muestraOcultaPanel(jPanel_302,true);
            muestraOcultaPanel(jPanel_303,true);
            muestraOcultaPanel(jPanel_304,true);
            muestraOcultaPanel(jPanel_305,true);
            muestraOcultaPanel(jPanel_306,true);
        }
    }//GEN-LAST:event_rad_2177ActionPerformed

    private void rad_2176ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2176ActionPerformed
        if(rad_2176.isSelected()){
            muestraOcultaPanel(jPanel_299,false);
            muestraOcultaPanel(jPanel_300,true);
            muestraOcultaPanel(jPanel_301,true);
            muestraOcultaPanel(jPanel_302,true);
            muestraOcultaPanel(jPanel_303,true);
            muestraOcultaPanel(jPanel_304,true);
            muestraOcultaPanel(jPanel_305,true);
            muestraOcultaPanel(jPanel_306,true);
        }
    }//GEN-LAST:event_rad_2176ActionPerformed

    private void rad_2175ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2175ActionPerformed
        if(rad_2175.isSelected()){
            muestraOcultaPanel(jPanel_299,false);
            muestraOcultaPanel(jPanel_300,true);
            muestraOcultaPanel(jPanel_301,true);
            muestraOcultaPanel(jPanel_302,true);
            muestraOcultaPanel(jPanel_303,true);
            muestraOcultaPanel(jPanel_304,true);
            muestraOcultaPanel(jPanel_305,true);
            muestraOcultaPanel(jPanel_306,true);
        }
    }//GEN-LAST:event_rad_2175ActionPerformed

    private void txt_2191KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_2191KeyTyped
        soloNumerosRango(evt, 2, 1, 20);
    }//GEN-LAST:event_txt_2191KeyTyped

    private void txt_2192KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_2192KeyTyped
        soloNumerosRango(evt, 2, 1, 10);
    }//GEN-LAST:event_txt_2192KeyTyped

    private void rad_2183ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2183ActionPerformed
        if(rad_2183.isSelected()){
            muestraOcultaPanel(jPanel_300,false);
            muestraOcultaPanel(jPanel_301,false);
            muestraOcultaPanel(jPanel_302,false);
            muestraOcultaPanel(jPanel_303,false);
            muestraOcultaPanel(jPanel_304,false);
            muestraOcultaPanel(jPanel_305,false);
            muestraOcultaPanel(jPanel_306,false);
        }
    }//GEN-LAST:event_rad_2183ActionPerformed

    private void rad_2184ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2184ActionPerformed
        if(rad_2184.isSelected()){
            muestraOcultaPanel(jPanel_300,false);
            muestraOcultaPanel(jPanel_301,false);
            muestraOcultaPanel(jPanel_302,false);
            muestraOcultaPanel(jPanel_303,false);
            muestraOcultaPanel(jPanel_304,false);
            muestraOcultaPanel(jPanel_305,false);
            muestraOcultaPanel(jPanel_306,false);
        }
    }//GEN-LAST:event_rad_2184ActionPerformed

    private void rad_2185ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2185ActionPerformed
        if(rad_2185.isSelected()){
            muestraOcultaPanel(jPanel_300,false);
            muestraOcultaPanel(jPanel_301,false);
            muestraOcultaPanel(jPanel_302,false);
            muestraOcultaPanel(jPanel_303,false);
            muestraOcultaPanel(jPanel_304,false);
            muestraOcultaPanel(jPanel_305,false);
            muestraOcultaPanel(jPanel_306,false);
        }
    }//GEN-LAST:event_rad_2185ActionPerformed

    private void rad_2186ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2186ActionPerformed
        if(rad_2186.isSelected()){
            muestraOcultaPanel(jPanel_300,false);
            muestraOcultaPanel(jPanel_301,false);
            muestraOcultaPanel(jPanel_302,false);
            muestraOcultaPanel(jPanel_303,false);
            muestraOcultaPanel(jPanel_304,false);
            muestraOcultaPanel(jPanel_305,false);
            muestraOcultaPanel(jPanel_306,false);
        }
    }//GEN-LAST:event_rad_2186ActionPerformed

    private void rad_2187ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2187ActionPerformed
        if(rad_2187.isSelected()){
            muestraOcultaPanel(jPanel_300,false);
            muestraOcultaPanel(jPanel_301,false);
            muestraOcultaPanel(jPanel_302,false);
            muestraOcultaPanel(jPanel_303,false);
            muestraOcultaPanel(jPanel_304,false);
            muestraOcultaPanel(jPanel_305,false);
            muestraOcultaPanel(jPanel_306,false);
        }
    }//GEN-LAST:event_rad_2187ActionPerformed

    private void rad_2188ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2188ActionPerformed
        if(rad_2188.isSelected()){
            muestraOcultaPanel(jPanel_300,false);
            muestraOcultaPanel(jPanel_301,false);
            muestraOcultaPanel(jPanel_302,false);
            muestraOcultaPanel(jPanel_303,false);
            muestraOcultaPanel(jPanel_304,false);
            muestraOcultaPanel(jPanel_305,false);
            muestraOcultaPanel(jPanel_306,false);
        }
    }//GEN-LAST:event_rad_2188ActionPerformed

    private void rad_2189ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2189ActionPerformed
        if(rad_2189.isSelected()){
            muestraOcultaPanel(jPanel_300,false);
            muestraOcultaPanel(jPanel_301,false);
            muestraOcultaPanel(jPanel_302,false);
            muestraOcultaPanel(jPanel_303,false);
            muestraOcultaPanel(jPanel_304,false);
            muestraOcultaPanel(jPanel_305,false);
            muestraOcultaPanel(jPanel_306,false);
        }
    }//GEN-LAST:event_rad_2189ActionPerformed

    private void rad_2190ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2190ActionPerformed
        if(rad_2190.isSelected()){
            muestraOcultaPanel(jPanel_300,false);
            muestraOcultaPanel(jPanel_301,false);
            muestraOcultaPanel(jPanel_302,false);
            muestraOcultaPanel(jPanel_303,false);
            muestraOcultaPanel(jPanel_304,false);
            muestraOcultaPanel(jPanel_305,false);
            muestraOcultaPanel(jPanel_306,false);
        }
    }//GEN-LAST:event_rad_2190ActionPerformed

    private void chk_1825ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1825ActionPerformed
        if(chk_1825.isSelected()){
            habilitaDeshabilitaComponentesRango(2215, 2215, false);
        }else{
            habilitaDeshabilitaComponentesRango(2215, 2215, true);
        }
    }//GEN-LAST:event_chk_1825ActionPerformed

    private void chk_1826ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1826ActionPerformed
        if(chk_1826.isSelected()){
            habilitaDeshabilitaComponentesRango(2216, 2216, false);
        }else{
            habilitaDeshabilitaComponentesRango(2216, 2216, true);
        }
    }//GEN-LAST:event_chk_1826ActionPerformed

    private void chk_1828ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1828ActionPerformed
        if(chk_1828.isSelected()){
            habilitaDeshabilitaComponentesRango(2218, 2218, false);
        }else{
            habilitaDeshabilitaComponentesRango(2218, 2218, true);
        }
    }//GEN-LAST:event_chk_1828ActionPerformed

    private void chk_1829ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1829ActionPerformed
        if(chk_1829.isSelected()){
            habilitaDeshabilitaComponentesRango(2219, 2219, false);
        }else{
            habilitaDeshabilitaComponentesRango(2219, 2219, true);
        }
    }//GEN-LAST:event_chk_1829ActionPerformed

    private void chk_1830ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1830ActionPerformed
        if(chk_1830.isSelected()){
            habilitaDeshabilitaComponentesRango(2220, 2220, false);
        }else{
            habilitaDeshabilitaComponentesRango(2220, 2220, true);
        }
    }//GEN-LAST:event_chk_1830ActionPerformed

    private void chk_1831ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1831ActionPerformed
        if(chk_1831.isSelected()){
            habilitaDeshabilitaComponentesRango(2221, 2221, false);
        }else{
            habilitaDeshabilitaComponentesRango(2221, 2221, true);
        }
    }//GEN-LAST:event_chk_1831ActionPerformed

    private void rad_2231ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2231ActionPerformed
        if(rad_2231.isSelected()){
            muestraOcultaPanel(jPanel_310,true);
        }
    }//GEN-LAST:event_rad_2231ActionPerformed

    private void rad_2232ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2232ActionPerformed
        if(rad_2232.isSelected()){
            muestraOcultaPanel(jPanel_310,true);
        }
    }//GEN-LAST:event_rad_2232ActionPerformed

    private void rad_2233ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2233ActionPerformed
        if(rad_2233.isSelected()){
            muestraOcultaPanel(jPanel_310,true);
        }
    }//GEN-LAST:event_rad_2233ActionPerformed

    private void rad_2234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2234ActionPerformed
        if(rad_2234.isSelected()){
            muestraOcultaPanel(jPanel_310,true);
        }
    }//GEN-LAST:event_rad_2234ActionPerformed

    private void rad_2235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2235ActionPerformed
        if(rad_2235.isSelected()){
            muestraOcultaPanel(jPanel_310,true);
        }
    }//GEN-LAST:event_rad_2235ActionPerformed

    private void rad_2236ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2236ActionPerformed
        if(rad_2236.isSelected()){
            muestraOcultaPanel(jPanel_310,true);
        }
    }//GEN-LAST:event_rad_2236ActionPerformed

    private void rad_2237ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2237ActionPerformed
        if(rad_2237.isSelected()){
            muestraOcultaPanel(jPanel_310,true);
        }
    }//GEN-LAST:event_rad_2237ActionPerformed

    private void rad_2238ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2238ActionPerformed
        if(rad_2238.isSelected()){
            muestraOcultaPanel(jPanel_310,true);
        }
    }//GEN-LAST:event_rad_2238ActionPerformed

    private void rad_2239ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2239ActionPerformed
        if(rad_2239.isSelected()){
            muestraOcultaPanel(jPanel_310,true);
        }
    }//GEN-LAST:event_rad_2239ActionPerformed

    private void rad_2230ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2230ActionPerformed
        if(rad_2230.isSelected()){
            muestraOcultaPanel(jPanel_310,false);
        }
    }//GEN-LAST:event_rad_2230ActionPerformed

    private void txt_2467KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_2467KeyTyped
        if(rad_2231.isSelected()){
            soloNumerosRango(evt, 1, 1, 3);
        }
        if(rad_2232.isSelected()){
            soloNumerosRango(evt, 1, 1, 2);
        }
        if(rad_2233.isSelected()){
            soloNumerosRango(evt, 1, 1, 6);
        }
        if(rad_2234.isSelected()){
            soloNumerosRango(evt, 1, 1, 6);
        }
        if(rad_2235.isSelected()){
            soloNumerosRango(evt, 1, 1, 6);
        }
        if(rad_2236.isSelected()){
            soloNumerosRango(evt, 1, 1, 6);
        }
        if(rad_2237.isSelected()){
            soloNumerosRango(evt, 1, 1, 4);
        }
        if(rad_2238.isSelected()){
            soloNumerosRango(evt, 1, 1, 7);
        }
        if(rad_2239.isSelected()){
            soloNumerosRango(evt, 1, 1, 5);
        }
    }//GEN-LAST:event_txt_2467KeyTyped

    private void txt_2250KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_2250KeyTyped
        if(rad_2241.isSelected()){
            soloNumerosRango(evt, 1, 1, 3);
        }
        if(rad_2242.isSelected()){
            soloNumerosRango(evt, 1, 1, 2);
        }
        if(rad_2243.isSelected()){
            soloNumerosRango(evt, 1, 1, 6);
        }
        if(rad_2244.isSelected()){
            soloNumerosRango(evt, 1, 1, 6);
        }
        if(rad_2245.isSelected()){
            soloNumerosRango(evt, 1, 1, 6);
        }
        if(rad_2246.isSelected()){
            soloNumerosRango(evt, 1, 1, 6);
        }
        if(rad_2247.isSelected()){
            soloNumerosRango(evt, 1, 1, 4);
        }
        if(rad_2248.isSelected()){
            soloNumerosRango(evt, 1, 1, 7);
        }
        if(rad_2249.isSelected()){
            soloNumerosRango(evt, 1, 1, 5);
        }
    }//GEN-LAST:event_txt_2250KeyTyped

    private void rad_2241ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2241ActionPerformed
        if(rad_2241.isSelected()){
            muestraOcultaPanel(jPanel_312,true);
        }
    }//GEN-LAST:event_rad_2241ActionPerformed

    private void rad_2242ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2242ActionPerformed
        if(rad_2242.isSelected()){
            muestraOcultaPanel(jPanel_312,true);
        }
    }//GEN-LAST:event_rad_2242ActionPerformed

    private void rad_2243ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2243ActionPerformed
        if(rad_2243.isSelected()){
            muestraOcultaPanel(jPanel_312,true);
        }
    }//GEN-LAST:event_rad_2243ActionPerformed

    private void rad_2244ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2244ActionPerformed
        if(rad_2244.isSelected()){
            muestraOcultaPanel(jPanel_312,true);
        }
    }//GEN-LAST:event_rad_2244ActionPerformed

    private void rad_2245ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2245ActionPerformed
        if(rad_2245.isSelected()){
            muestraOcultaPanel(jPanel_312,true);
        }
    }//GEN-LAST:event_rad_2245ActionPerformed

    private void rad_2246ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2246ActionPerformed
        if(rad_2246.isSelected()){
            muestraOcultaPanel(jPanel_312,true);
        }
    }//GEN-LAST:event_rad_2246ActionPerformed

    private void rad_2247ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2247ActionPerformed
        if(rad_2247.isSelected()){
            muestraOcultaPanel(jPanel_312,true);
        }
    }//GEN-LAST:event_rad_2247ActionPerformed

    private void rad_2248ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2248ActionPerformed
        if(rad_2248.isSelected()){
            muestraOcultaPanel(jPanel_312,true);
        }
    }//GEN-LAST:event_rad_2248ActionPerformed

    private void rad_2249ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2249ActionPerformed
        if(rad_2249.isSelected()){
            muestraOcultaPanel(jPanel_312,true);
        }
    }//GEN-LAST:event_rad_2249ActionPerformed

    private void rad_2240ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2240ActionPerformed
        if(rad_2240.isSelected()){
            muestraOcultaPanel(jPanel_312,false);
        }
    }//GEN-LAST:event_rad_2240ActionPerformed

    private void rad_2294ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2294ActionPerformed
        if(rad_2294.isSelected()){
            muestraOcultaPanel(jPanel_320,true);
        }
    }//GEN-LAST:event_rad_2294ActionPerformed

    private void rad_2295ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2295ActionPerformed
        if(rad_2295.isSelected()){
            muestraOcultaPanel(jPanel_320,false);
        }
    }//GEN-LAST:event_rad_2295ActionPerformed

    private void rad_2318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2318ActionPerformed
        if(rad_2318.isSelected()){
            muestraOcultaPanel(jPanel_324,true);
        }
    }//GEN-LAST:event_rad_2318ActionPerformed

    private void rad_2319ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2319ActionPerformed
        if(rad_2319.isSelected()){
            muestraOcultaPanel(jPanel_324,false);
        }
    }//GEN-LAST:event_rad_2319ActionPerformed

    private void rad_2353ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2353ActionPerformed
        if(rad_2353.isSelected()){
            muestraOcultaPanel(jPanel_331,true);
        }
    }//GEN-LAST:event_rad_2353ActionPerformed

    private void rad_2354ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2354ActionPerformed
        if(rad_2354.isSelected()){
            muestraOcultaPanel(jPanel_331,false);
        }
    }//GEN-LAST:event_rad_2354ActionPerformed

    private void rad_2355ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2355ActionPerformed
        if(rad_2355.isSelected()){
            muestraOcultaPanel(jPanel_331,false);
        }
    }//GEN-LAST:event_rad_2355ActionPerformed

    private void rad_2356ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2356ActionPerformed
        if(rad_2356.isSelected()){
            muestraOcultaPanel(jPanel_331,false);
        }
    }//GEN-LAST:event_rad_2356ActionPerformed

    private void rad_2357ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2357ActionPerformed
        if(rad_2357.isSelected()){
            muestraOcultaPanel(jPanel_331,false);
        }
    }//GEN-LAST:event_rad_2357ActionPerformed

    private void rad_2358ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2358ActionPerformed
        if(rad_2358.isSelected()){
            muestraOcultaPanel(jPanel_331,false);
        }
    }//GEN-LAST:event_rad_2358ActionPerformed

    private void rad_2359ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_2359ActionPerformed
        if(rad_2359.isSelected()){
            muestraOcultaPanel(jPanel_331,false);
        }
    }//GEN-LAST:event_rad_2359ActionPerformed

    /** 
     * @param args the command line arguments
     */
    public HashMap<String,Component> obtenerComponentesPorPanel(JPanel j) {
        try {
            Component[] componentes = j.getComponents();
            HashMap<String,Component> componentMap = new HashMap<>();
            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i] instanceof JPanel) {
                    componentMap.put(componentes[i].getName(), componentes[i]);
                    Component[] auxiliar = ((JPanel)componentes[i]).getComponents();
                    for (int a = 0; a < auxiliar.length; a++) {
                        componentMap.put(auxiliar[a].getName(), auxiliar[a]);
                    }
                }
                if (componentes[i] instanceof JLabel) {
                    componentMap.put(componentes[i].getName(), componentes[i]);
                }
            }
            return componentMap;
        } catch (Exception ex) {
            Logger.getLogger(EncuestaContexto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * 
     */
    public Component obtenerComponentePorName(String name) {
        if (allComponents.containsKey(name)) {
            return (Component) allComponents.get(name);
        }else{
             return null;
        }
    }
    
    /**
     * 
     */
    private void limpiaSeleccionRadio(String name){
        switch(name){
            case "283":
                bgSec1_283.clearSelection();
                break;
            case "285":
                bgSec1_285.clearSelection();
                break;
            case "287":
                bgSec1_287.clearSelection();
                break;
            case "289":
                bgSec1_289.clearSelection();
                break;
            case "290":
                bgSec1_290.clearSelection();
                break;
            case "292":
                bgSec1_292.clearSelection();
                break;
            case "293":
                bgSec1_293.clearSelection();
                break;
            case "294":
                bgSec1_294.clearSelection();
                break;
            case "295":
                bgSec1_295.clearSelection();
                break;
            case "296":
                bgSec1_296.clearSelection();
                break;
            case "297":
                bgSec1_297.clearSelection();
                break;
            case "298":
                bgSec2_298.clearSelection();
                break;
            case "302":
                bgSec2_302.clearSelection();
                break;
            case "303":
                bgSec2_303.clearSelection();
                break;
            case "304":
                bgSec2_304.clearSelection();
                break;
            case "305":
                bgSec2_305.clearSelection();
                break;
            case "306":
                bgSec2_306.clearSelection();
                break;
            case "307":
                bgSec3_307.clearSelection();
                break;
            case "308":
                bgSec3_308.clearSelection();
                break;
            case "309":
                bgSec3_309.clearSelection();
                break;
            case "311":
                bgSec3_311.clearSelection();
                break;
            case "313":
                bgSec3_313.clearSelection();
                break;
            case "314":
                bgSec3_314.clearSelection();
                break;
            case "315":
                bgSec3_315.clearSelection();
                break;
            case "316":
                bgSec3_316.clearSelection();
                break;
            case "317":
                bgSec3_317.clearSelection();
                break;
            case "319":
                bgSec3_319.clearSelection();
                break;
            case "321":
                bgSec3_321.clearSelection();
                break;
            case "322":
                bgSec3_322.clearSelection();
                break;
            case "323":
                bgSec3_323.clearSelection();
                break;
            case "324":
                bgSec3_324.clearSelection();
                break;
            case "325":
                bgSec3_325.clearSelection();
                break;
            case "326":
                bgSec3_326.clearSelection();
                break;
            case "327":
                bgSec4_327.clearSelection();
                break;
            case "328":
                bgSec4_328.clearSelection();
                break;
            case "329":
                bgSec4_329.clearSelection();
                break;
            case "330":
                bgSec4_330.clearSelection();
                break;
            case "331":
                bgSec4_331.clearSelection();
                break;
            case "333":
                bgSec5_333.clearSelection();
                break;
            case "334":
                bgSec5_334.clearSelection();
                break;
            case "336":
                bgSec5_336.clearSelection();
                break;
            case "337":
                bgSec5_337.clearSelection();
                break;
            case "338":
                bgSec6_338.clearSelection();
                break;
            case "339":
                bgSec6_339.clearSelection();
                break;
            case "340":
                bgSec6_340.clearSelection();
                break;
            case "342":
                bgSec6_342.clearSelection();
                break;
            case "343":
                bgSec6_343.clearSelection();
                break;
            case "344":
                bgSec6_344.clearSelection();
                break;
            case "345":
                bgSec6_345.clearSelection();
                break;
            case "346":
                bgSec6_346.clearSelection();
                break;
            case "348":
                bgSec6_348.clearSelection();
                break;
            case "349":
                bgSec6_349.clearSelection();
                break;
            case "350":
                bgSec6_350.clearSelection();
                break;
            case "351":
                bgSec6_351.clearSelection();
                break;
            case "352":
                bgSec6_352.clearSelection();
                break;
            case "353":
                bgSec6_353.clearSelection();
                break;
        }
    }
    /**
     * 
     * @param panel
     * @param opcion 
     */
    private void muestraOcultaPanel(JPanel panel,boolean opcion){
        panel.setVisible(opcion);
        Component[] componentes1 = panel.getComponents();
        for (int a = 0; a < componentes1.length; a++) {
            if(componentes1[a] instanceof JRadioButton){
                String name = ((JRadioButton)componentes1[a]).getParent().getName();
                limpiaSeleccionRadio(name);
            }
            if(componentes1[a] instanceof JCheckBox){
//                ((JCheckBox)componentes1[a]).setEnabled(opcion);
                ((JCheckBox)componentes1[a]).setSelected(false);
            }
            if(componentes1[a] instanceof JTextField){
//                ((JTextField)componentes1[a]).setEnabled(opcion);
                ((JTextField)componentes1[a]).setText("");
            }
            if(componentes1[a] instanceof JScrollPane){
                    if(((JScrollPane)componentes1[a]).getName().equalsIgnoreCase("lista_288") && jList_288 != null){
                        jList_288.clearSelection();
                    }
                    if(((JScrollPane)componentes1[a]).getName().equalsIgnoreCase("lista_356") && jList_356 != null){
                        jList_356.clearSelection();
                    }
                    if(((JScrollPane)componentes1[a]).getName().equalsIgnoreCase("lista_358") && jList_358 != null){
                        jList_358.clearSelection();
                    }
                    if(((JScrollPane)componentes1[a]).getName().equalsIgnoreCase("lista_360") && jList_360 != null){
                        jList_360.clearSelection();
                    }
                    if(((JScrollPane)componentes1[a]).getName().equalsIgnoreCase("lista_362") && jList_362 != null){
                        jList_362.clearSelection();
                    }
                }
        }
    }
    
    public void fileChooser(){
        javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser(); 
        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.XML", "xml");
        //Le indicamos el filtro
        jF1.setFileFilter(filtro);
        //Nombre por defecto
        jF1.setSelectedFile(new File("respuestas.XML"));
        try{ 
            if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION){ 
                ruta = jF1.getSelectedFile().getAbsolutePath();
                System.out.println(ruta);
                encuestaTerminada = true;
            } 
        }catch (Exception ex){ 
            ex.printStackTrace(); 
            encuestaTerminada = false;
        }
    }
    /**
     * 
     */
    public void habilitaDeshabilitaComponentesRango(int inicio,int fin, boolean opcion){
        Component componente;
        for(int i=inicio;i<=fin;i++){
            String nombre = ""+i;
            componente = obtenerComponentePorName(nombre);
            if(componente instanceof JRadioButton){
                ((JRadioButton)componente).setEnabled(opcion);
                ((JRadioButton)componente).setSelected(false);
            }
            if(componente instanceof JCheckBox){
                ((JCheckBox)componente).setEnabled(opcion);
                ((JCheckBox)componente).setSelected(false);
            }
            if(componente instanceof JTextField){
                ((JTextField)componente).setEnabled(opcion);
                ((JTextField)componente).setText("");
            }
        }
    
    }
    /**
     * @param args the command line arguments
     */
//    public void obtenerRespuestasPorSeccion(JPanel j) {
//        try {
//            Component[] componentes = j.getComponents();
//            HashMap<String,Component> componentMap = new HashMap<>();
//            for (int i = 0; i < componentes.length; i++) {
//                if (componentes[i] instanceof JPanel) {
//                    componentMap.put(componentes[i].getName(), componentes[i]);
//                    Component[] componentes1 = ((JPanel)componentes[i]).getComponents();
//                    for (int a = 0; a < componentes1.length; a++) {
////                        if(componentes1[a] instanceof JPanel){
////                            componentMap.put(componentes1[a].getName(), componentes1[a]);
////                        }
//                        if(componentes1[a] instanceof JRadioButton){
//                            componentMap.put(componentes1[a].getName(), componentes1[a]);
//                        }
//                        if(componentes1[a] instanceof JCheckBox){
//                            componentMap.put(componentes1[a].getName(), componentes1[a]);
//                        }
//                        if(componentes1[a] instanceof JTextField){
//                            componentMap.put(componentes1[a].getName(), componentes1[a]);
//                        }
//                    }
//                }
//            }
//            generateXML(componentMap);
//        } catch (Exception ex) {
//            Logger.getLogger(EncuestaContexto.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

     /**
     * @param args the command line arguments
     */
    public void generateXML(HashMap<String,Component> respuestas) throws Exception{
        String valor = "";
        if(respuestas.isEmpty()){
            System.out.println("ERROR empty ArrayList");
            return;
        }else{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            org.w3c.dom.Document document = implementation.createDocument(null, fileConfig, null);
            document.setXmlVersion("1.0");
            //Main Node
            org.w3c.dom.Element raiz = document.getDocumentElement();
            org.w3c.dom.Element itemNode = document.createElement("LISTA_RESPUESTAS");
            /*----------Para registrar la seccion actual----------------------------------*/
            org.w3c.dom.Element itemNode1 = document.createElement("SECCIONES");
            org.w3c.dom.Element keyNode1 = document.createElement("SECCION_ACTUAL");
            keyNode1.setAttribute("INDEX", index.toString());
            itemNode1.appendChild(keyNode1);
            raiz.appendChild(itemNode1);
            /*-----------------------------------------------------------------------------*/
            /*------------------Para registrar el usuario----------------------------------*/
            org.w3c.dom.Element itemNode2 = document.createElement("LOGIN");
            org.w3c.dom.Element keyNode2 = document.createElement("USUARIO");
            keyNode2.setAttribute("ID", txt_cedula.getText());
            keyNode2.setAttribute("NOMBRES", txt_nombres.getText());
            keyNode2.setAttribute("APELLIDOS", txt_apellidos.getText());
            if(jButton_Sigueinte.getText().equalsIgnoreCase("Finalizar")){
                keyNode2.setAttribute("FINALIZADO","1");
            }else{
                keyNode2.setAttribute("FINALIZADO","0");
            }
            itemNode2.appendChild(keyNode2);
            raiz.appendChild(itemNode2);
            /*-----------------------------------------------------------------------------*/
            for(Map.Entry<String,Component> b: respuestas.entrySet()){
                org.w3c.dom.Element keyNode = document.createElement("COMPONENTE");
//                System.out.println(b.getKey());
                keyNode.setAttribute("NAME", b.getKey());
                if(b.getValue() instanceof JPanel){
                    keyNode.setAttribute("VISIBLE", (((JPanel)b.getValue()).isVisible())?"1":"0");
                    valor = "jPanel";
                }
                if(b.getValue() instanceof JRadioButton){
                    keyNode.setAttribute("ENABLED", (((JRadioButton)b.getValue()).isEnabled())?"1":"0");
                    keyNode.setAttribute("SELECTED", (((JRadioButton)b.getValue()).isSelected())?"1":"0");
                    valor = (((JRadioButton)b.getValue()).isSelected())?"1":"0";
                }
                if(b.getValue() instanceof JCheckBox){
                    keyNode.setAttribute("ENABLED", (((JCheckBox)b.getValue()).isEnabled())?"1":"0");
                    keyNode.setAttribute("SELECTED", (((JCheckBox)b.getValue()).isSelected())?"1":"0");
                    valor = (((JCheckBox)b.getValue()).isSelected())?"1":"0";
                }
                if(b.getValue() instanceof JScrollPane){
                    if(((JScrollPane)b.getValue()).getName().equalsIgnoreCase("lista_288")){
                        if(!jList_288.isSelectionEmpty()){
                            keyNode.setAttribute("ENABLED", (jList_288.isEnabled())?"1":"0");
                            keyNode.setAttribute("SELECTED", !(jList_288.isSelectionEmpty())?"1":"0");
                            keyNode.setAttribute("INDEX", (""+jList_288.getSelectedIndex()));
                            keyNode.setAttribute("VALUE", codigoPaises[jList_288.getSelectedIndex()]);
                            valor = jList_288.getSelectedValue();
                        }
                    }
                    if(((JScrollPane)b.getValue()).getName().equalsIgnoreCase("lista_356")){
                        if(!jList_356.isSelectionEmpty()){
                            keyNode.setAttribute("ENABLED", (jList_356.isEnabled())?"1":"0");
                            keyNode.setAttribute("SELECTED", !(jList_356.isSelectionEmpty())?"1":"0");
                            keyNode.setAttribute("INDEX", (""+jList_356.getSelectedIndex()));
                            keyNode.setAttribute("VALUE", codigoLenguaIndigenaPadre[jList_356.getSelectedIndex()]);
                            valor = jList_356.getSelectedValue();
                        }
                    }
                    if(((JScrollPane)b.getValue()).getName().equalsIgnoreCase("lista_358")){
                        if(!jList_358.isSelectionEmpty()){
                            keyNode.setAttribute("ENABLED", (jList_358.isEnabled())?"1":"0");
                            keyNode.setAttribute("SELECTED", !(jList_358.isSelectionEmpty())?"1":"0");
                            keyNode.setAttribute("INDEX", (""+jList_358.getSelectedIndex()));
                            keyNode.setAttribute("VALUE", codigoLenguaIndigenaMadre[jList_358.getSelectedIndex()]);
                            valor = jList_358.getSelectedValue();
                        }
                    }
                    if(((JScrollPane)b.getValue()).getName().equalsIgnoreCase("lista_360")){
                        if(!jList_360.isSelectionEmpty()){
                            keyNode.setAttribute("ENABLED", (jList_360.isEnabled())?"1":"0");
                            keyNode.setAttribute("SELECTED", !(jList_360.isSelectionEmpty())?"1":"0");
                            keyNode.setAttribute("INDEX", (""+jList_360.getSelectedIndex()));
                            keyNode.setAttribute("VALUE", codigoLenguaExtranjeraPadre[jList_360.getSelectedIndex()]);
                            valor = jList_360.getSelectedValue();
                        }
                    }
                    if(((JScrollPane)b.getValue()).getName().equalsIgnoreCase("lista_362")){
                        if(!jList_362.isSelectionEmpty()){
                            keyNode.setAttribute("ENABLED", (jList_362.isEnabled())?"1":"0");
                            keyNode.setAttribute("SELECTED", !(jList_362.isSelectionEmpty())?"1":"0");
                            keyNode.setAttribute("INDEX", (""+jList_362.getSelectedIndex()));
                            keyNode.setAttribute("VALUE", codigoLenguaExtrajeraMadre[jList_362.getSelectedIndex()]);
                            valor = jList_362.getSelectedValue();
                        }
                    }
                }
                if(b.getValue() instanceof JTextField){
                    keyNode.setAttribute("ENABLED", (((JTextField)b.getValue()).isEnabled())?"1":"0");
                    keyNode.setAttribute("VALUE", ((JTextField)b.getValue()).getText());
                    valor = ((JTextField)b.getValue()).getText();
                }
                Text nodeKeyValue = document.createTextNode(valor);
                keyNode.appendChild(nodeKeyValue);      
                itemNode.appendChild(keyNode);
                raiz.appendChild(itemNode);
            }
            //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File("./xml/"+fileConfig+".xml")); //nombre del archivo
            //Result result = new StreamResult(new java.io.File("./src/ec/gob/senescyt/snna/xml/"+fileConfig+".xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            if(encuestaTerminada){
                Result resultFinal = new StreamResult(new java.io.File(ruta)); //nombre del archivo
                Transformer transformerFinal = TransformerFactory.newInstance().newTransformer();
                transformerFinal.transform(source, resultFinal);
                encuestaTerminada = false;
            }
        }
    }
    
    /**
     * 
     */
    public void cargarXml(){
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        //File xmlFile = new File( "./src/ec/gob/senescyt/snna/xml/"+fileConfig+".xml" );
        File xmlFile = new File( "./xml/"+fileConfig+".xml" );
        try
        {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build( xmlFile );
            //Se obtiene la raiz
            Element rootNode = document.getRootElement();
            //Se obtiene la lista de hijos de la raiz 'config'
            /*------------------------------------------------*/
            List listaSecciones = rootNode.getChildren( "SECCIONES" );
            Element secciones = (Element) listaSecciones.get(0);
            List hijosSecciones = secciones.getChildren();
            Element seccionActual = (Element)hijosSecciones.get(0);
            jTabbedPane1.setSelectedIndex(Integer.parseInt(seccionActual.getAttributeValue("INDEX")));
            index = jTabbedPane1.getSelectedIndex();
            bloqueaPestanias(index);
            /*------------------------------------------------*/
            /*------------------------------------------------*/
            List listaLogin = rootNode.getChildren( "LOGIN" );
            Element login = (Element) listaLogin.get(0);
            List hijosLogin = login.getChildren();
            Element loginActual = (Element)hijosLogin.get(0);
            if(!loginActual.getAttributeValue("ID").isEmpty()){
                txt_cedula.setText(loginActual.getAttributeValue("ID"));
                txt_cedula.setEnabled(false);
                txt_nombres.setText(loginActual.getAttributeValue("NOMBRES"));
                txt_nombres.setEnabled(false);
                txt_apellidos.setText(loginActual.getAttributeValue("APELLIDOS"));
                txt_apellidos.setEnabled(false);
                archivoGenerado = loginActual.getAttributeValue("FINALIZADO");
                jButton_activarEncuesta.setText("Editar");
            }else{
                bloqueaPestanias(-1);
            }
            /*------------------------------------------------*/
            List list = rootNode.getChildren( "LISTA_RESPUESTAS" );
            //Se obtiene el elemento 'LISTA_RESPUESTAS'
            Element respuestas = (Element) list.get(0);
            //Se obtiene la lista de hijos del tag 'LISTA_RESPUESTAS'
            List lista_componentes = respuestas.getChildren();
            //Se recorre la lista de campos
            for ( int j = 0; j < lista_componentes.size(); j++ )
            {
                //Se obtiene el elemento 'campo'
                Element componente = (Element)lista_componentes.get(j);
//                if(componente.getAttributeValue("NAME").equalsIgnoreCase("lista_358"))
//                {
//                System.out.println(componente.getAttributeValue("NAME"));
//                }
                Component componenteGui = obtenerComponentePorName(componente.getAttributeValue("NAME"));
                if(componenteGui instanceof JPanel){
                    ((JPanel)componenteGui).setVisible(componente.getAttributeValue("VISIBLE").equalsIgnoreCase("1"));
                }
                if(componenteGui instanceof JRadioButton){
                    ((JRadioButton)componenteGui).setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                    ((JRadioButton)componenteGui).setSelected(componente.getAttributeValue("SELECTED").equalsIgnoreCase("1"));
                }
                if(componenteGui instanceof JCheckBox){
                    ((JCheckBox)componenteGui).setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                    ((JCheckBox)componenteGui).setSelected(componente.getAttributeValue("SELECTED").equalsIgnoreCase("1"));
                }
                if(componenteGui instanceof JTextField){
                    ((JTextField)componenteGui).setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                    if(componente.getContent().size()>0)
                        ((JTextField)componenteGui).setText(componente.getAttributeValue("VALUE").toString());
                }
                if(componenteGui instanceof JScrollPane){
                    if(((JScrollPane)componenteGui).getName().equalsIgnoreCase("lista_288") && jList_288 != null){
                        if(componente.getAttributeValue("ENABLED") != null && componente.getAttributeValue("INDEX") != null){
                            jList_288.setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                            jList_288.setSelectedIndex(Integer.parseInt(componente.getAttributeValue("INDEX")));
                        }
                    }
                    if(((JScrollPane)componenteGui).getName().equalsIgnoreCase("lista_356") && jList_356 != null){
                        if(componente.getAttributeValue("ENABLED") != null && componente.getAttributeValue("INDEX") != null){
                            jList_356.setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                            jList_356.setSelectedIndex(Integer.parseInt(componente.getAttributeValue("INDEX")));
                        }
                    }
                    if(((JScrollPane)componenteGui).getName().equalsIgnoreCase("lista_358") && jList_358 != null){
                        if(componente.getAttributeValue("ENABLED") != null && componente.getAttributeValue("INDEX") != null){
                            jList_358.setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                            jList_358.setSelectedIndex(Integer.parseInt(componente.getAttributeValue("INDEX")));
                        }
                    }
                    if(((JScrollPane)componenteGui).getName().equalsIgnoreCase("lista_360") && jList_360 != null){
                        if(componente.getAttributeValue("ENABLED") != null && componente.getAttributeValue("INDEX") != null){
                            jList_360.setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                            jList_360.setSelectedIndex(Integer.parseInt(componente.getAttributeValue("INDEX")));
                        }
                    }
                    if(((JScrollPane)componenteGui).getName().equalsIgnoreCase("lista_362") && jList_362 != null){
                        if(componente.getAttributeValue("ENABLED") != null && componente.getAttributeValue("INDEX") != null){
                            jList_362.setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                            jList_362.setSelectedIndex(Integer.parseInt(componente.getAttributeValue("INDEX")));
                        }
                    }
                }
            }
        }catch ( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
    
    /** 
     * @param args the command line arguments
     */
    public boolean validarPreguntasPorPanel(JPanel j) {
        try {
            int bandera=0;
            int banderaAux=0;
            Component[] componentes = j.getComponents();
            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i] instanceof JPanel && ((JPanel)componentes[i]).isVisible()) {
                    Component[] auxiliar = ((JPanel)componentes[i]).getComponents();
                    bandera=0;
                    Component label = obtenerComponentePorName("lbl_"+ ((JPanel)componentes[i]).getName());
                    for (int a = 0; a < auxiliar.length; a++) {
                        if(auxiliar[a] instanceof JRadioButton && ((JRadioButton)auxiliar[a]).isSelected()){
                            bandera++;
                        }
                        if(auxiliar[a] instanceof JCheckBox && ((JCheckBox)auxiliar[a]).isSelected()){
                            bandera++;
                        }
                        if(auxiliar[a] instanceof JTextField && !((JTextField)auxiliar[a]).getText().isEmpty()){
                            bandera++;
                        }
                        if(auxiliar[a] instanceof JScrollPane){
                            if(((JScrollPane)auxiliar[a]).getName().equalsIgnoreCase("lista_288")){
                                if(!jList_288.isSelectionEmpty()){
                                    bandera++;
                                }
                            }
                            if(((JScrollPane)auxiliar[a]).getName().equalsIgnoreCase("lista_356")){
                                if(!jList_356.isSelectionEmpty()){
                                    bandera++;
                                }
                            }
                            if(((JScrollPane)auxiliar[a]).getName().equalsIgnoreCase("lista_358")){
                                if(!jList_358.isSelectionEmpty()){
                                    bandera++;
                                }
                            }
                            if(((JScrollPane)auxiliar[a]).getName().equalsIgnoreCase("lista_360")){
                                if(!jList_360.isSelectionEmpty()){
                                    bandera++;
                                }
                            }
                            if(((JScrollPane)auxiliar[a]).getName().equalsIgnoreCase("lista_362")){
                                if(!jList_362.isSelectionEmpty()){
                                    bandera++;
                                }
                            }
                        }
                    }
                    if(label != null)//CAMBIAR!!!!
                        if(bandera == 0){
                            ((JLabel)label).setVisible(true);
                            banderaAux++;
                        }else{
                            ((JLabel)label).setVisible(false);
                        }
                }
            }
            if(banderaAux > 0){
                JOptionPane.showMessageDialog(this, "Revisa los campos alertados","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }else{
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(EncuestaContexto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    /**
     * 
     */
    public void validaSiguiente(){
        int i = jTabbedPane1.getSelectedIndex() + 1;
        int total = jTabbedPane1.getTabCount();
        boolean bandera;
        switch(i){
            case 1:
                bandera = validarPreguntasPorPanel(jPanelSec_1);
            break;
            case 2:
                bandera = validarPreguntasPorPanel(jPanelSec_2);
            break;
            case 3:
                bandera = validarPreguntasPorPanel(jPanelSec_3);
            break;
            case 4:
                bandera = validarPreguntasPorPanel(jPanelSec_4);
            break;
            case 5:
                bandera = validarPreguntasPorPanel(jPanelSec_5);
            break;
            case 6:
                bandera = validarPreguntasPorPanel(jPanelSec_6);
            break;
            default:
                bandera = false;
            break;
        }
        
        if(bandera){
            try {
                if (i < total) {
                    jTabbedPane1.setSelectedIndex(i++);
                    jTabbedPane1.setEnabledAt(i-1,true);
                    index = jTabbedPane1.getSelectedIndex();
                }else{
                    fileChooser();
                }
                generateXML(allComponents);
            } catch (Exception ex) {
                Logger.getLogger(EncuestaContexto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //jTabbedPane1.setSelectedIndex(i-2);
        }
    }
    /**
     * 
     */
    private void soloNumeros(java.awt.event.KeyEvent evt, int max){
        char c = evt.getKeyChar(); 
        if(((JTextField)evt.getComponent()).getText().length() <= max){
            if(c >= '0' && c <= '9'){
            }else{
                getToolkit().beep();
                evt.consume();
            }
        }else{
                getToolkit().beep();
                evt.consume();
        }
    }
     /**
     * 
     */
    private void soloNumerosRango(java.awt.event.KeyEvent evt, int max,int inicio,int fin){
        char c = evt.getKeyChar();
        int valor = 1; 
        if(!((JTextField)evt.getComponent()).getText().isEmpty() && (c >= '0' && c <= '9'))
               valor = Integer.parseInt(((JTextField)evt.getComponent()).getText()+c);
        if(((JTextField)evt.getComponent()).getText().isEmpty() && (c >= '0' && c <= '9'))
            valor = Integer.parseInt(""+c);
        if(((JTextField)evt.getComponent()).getText().length() <= max){
            if(valor >= inicio && valor <= fin){
                if(c >= '0' && c <= '9'){
                }else{
                    getToolkit().beep();
                    evt.consume();
                }
            }else{
                evt.consume();
                JOptionPane.showMessageDialog(this, "El valor ingresado debe estar entre "+ inicio+" y "+fin,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
                getToolkit().beep();
                evt.consume();
        }
    }
    /**
     * 
     */
    private void soloLetras(java.awt.event.KeyEvent evt, int max){
        String caracteresPermitidos = "ÁÉÍÓÚÑÄËÏÖÜ áéíóúñäëïöü";
        char c = evt.getKeyChar(); 
        if(((JTextField)evt.getComponent()).getText().length() <= max){
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (caracteresPermitidos.indexOf(c) != -1)){
                if (Character.isLowerCase(c)) {
                  evt.setKeyChar(Character.toUpperCase(c));
                }
            }else{
                getToolkit().beep();
                evt.consume();
            }
        }else{
                getToolkit().beep();
                evt.consume();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EncuestaContexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncuestaContexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncuestaContexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncuestaContexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncuestaContexto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSec1_283;
    private javax.swing.ButtonGroup bgSec1_285;
    private javax.swing.ButtonGroup bgSec1_287;
    private javax.swing.ButtonGroup bgSec1_289;
    private javax.swing.ButtonGroup bgSec1_290;
    private javax.swing.ButtonGroup bgSec1_292;
    private javax.swing.ButtonGroup bgSec1_293;
    private javax.swing.ButtonGroup bgSec1_294;
    private javax.swing.ButtonGroup bgSec1_295;
    private javax.swing.ButtonGroup bgSec1_296;
    private javax.swing.ButtonGroup bgSec1_297;
    private javax.swing.ButtonGroup bgSec2_298;
    private javax.swing.ButtonGroup bgSec2_302;
    private javax.swing.ButtonGroup bgSec2_303;
    private javax.swing.ButtonGroup bgSec2_304;
    private javax.swing.ButtonGroup bgSec2_305;
    private javax.swing.ButtonGroup bgSec2_306;
    private javax.swing.ButtonGroup bgSec3_307;
    private javax.swing.ButtonGroup bgSec3_308;
    private javax.swing.ButtonGroup bgSec3_309;
    private javax.swing.ButtonGroup bgSec3_311;
    private javax.swing.ButtonGroup bgSec3_313;
    private javax.swing.ButtonGroup bgSec3_314;
    private javax.swing.ButtonGroup bgSec3_315;
    private javax.swing.ButtonGroup bgSec3_316;
    private javax.swing.ButtonGroup bgSec3_317;
    private javax.swing.ButtonGroup bgSec3_319;
    private javax.swing.ButtonGroup bgSec3_321;
    private javax.swing.ButtonGroup bgSec3_322;
    private javax.swing.ButtonGroup bgSec3_323;
    private javax.swing.ButtonGroup bgSec3_324;
    private javax.swing.ButtonGroup bgSec3_325;
    private javax.swing.ButtonGroup bgSec3_326;
    private javax.swing.ButtonGroup bgSec4_327;
    private javax.swing.ButtonGroup bgSec4_328;
    private javax.swing.ButtonGroup bgSec4_329;
    private javax.swing.ButtonGroup bgSec4_330;
    private javax.swing.ButtonGroup bgSec4_331;
    private javax.swing.ButtonGroup bgSec5_333;
    private javax.swing.ButtonGroup bgSec5_334;
    private javax.swing.ButtonGroup bgSec5_336;
    private javax.swing.ButtonGroup bgSec5_337;
    private javax.swing.ButtonGroup bgSec6_338;
    private javax.swing.ButtonGroup bgSec6_339;
    private javax.swing.ButtonGroup bgSec6_340;
    private javax.swing.ButtonGroup bgSec6_342;
    private javax.swing.ButtonGroup bgSec6_343;
    private javax.swing.ButtonGroup bgSec6_344;
    private javax.swing.ButtonGroup bgSec6_345;
    private javax.swing.ButtonGroup bgSec6_346;
    private javax.swing.ButtonGroup bgSec6_348;
    private javax.swing.ButtonGroup bgSec6_349;
    private javax.swing.ButtonGroup bgSec6_350;
    private javax.swing.ButtonGroup bgSec6_351;
    private javax.swing.ButtonGroup bgSec6_352;
    private javax.swing.ButtonGroup bgSec6_353;
    private javax.swing.JCheckBox chk_1802;
    private javax.swing.JCheckBox chk_1803;
    private javax.swing.JCheckBox chk_1804;
    private javax.swing.JCheckBox chk_1805;
    private javax.swing.JCheckBox chk_1806;
    private javax.swing.JCheckBox chk_1807;
    private javax.swing.JCheckBox chk_1808;
    private javax.swing.JCheckBox chk_1809;
    private javax.swing.JCheckBox chk_1810;
    private javax.swing.JCheckBox chk_1811;
    private javax.swing.JCheckBox chk_1814;
    private javax.swing.JCheckBox chk_1815;
    private javax.swing.JCheckBox chk_1816;
    private javax.swing.JCheckBox chk_1817;
    private javax.swing.JCheckBox chk_1818;
    private javax.swing.JCheckBox chk_1819;
    private javax.swing.JCheckBox chk_1820;
    private javax.swing.JCheckBox chk_1821;
    private javax.swing.JCheckBox chk_1824;
    private javax.swing.JCheckBox chk_1825;
    private javax.swing.JCheckBox chk_1826;
    private javax.swing.JCheckBox chk_1827;
    private javax.swing.JCheckBox chk_1828;
    private javax.swing.JCheckBox chk_1829;
    private javax.swing.JCheckBox chk_1830;
    private javax.swing.JCheckBox chk_1831;
    private javax.swing.JCheckBox chk_2289;
    private javax.swing.JCheckBox chk_2290;
    private javax.swing.JCheckBox chk_2291;
    private javax.swing.JCheckBox chk_2292;
    private javax.swing.JCheckBox chk_2293;
    private javax.swing.JCheckBox chk_2296;
    private javax.swing.JCheckBox chk_2297;
    private javax.swing.JCheckBox chk_2298;
    private javax.swing.JCheckBox chk_2299;
    private javax.swing.JCheckBox chk_2300;
    private javax.swing.JCheckBox chk_2301;
    private javax.swing.JCheckBox chk_2302;
    private javax.swing.JCheckBox chk_2364;
    private javax.swing.JCheckBox chk_2365;
    private javax.swing.JCheckBox chk_2366;
    private javax.swing.JCheckBox chk_2367;
    private javax.swing.JCheckBox chk_2368;
    private javax.swing.JCheckBox chk_2377;
    private javax.swing.JCheckBox chk_2378;
    private javax.swing.JCheckBox chk_2379;
    private javax.swing.JButton jButton_Atras;
    private javax.swing.JButton jButton_Sigueinte;
    private javax.swing.JButton jButton_activarEncuesta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_282;
    private javax.swing.JLabel jLabel_283;
    private javax.swing.JLabel jLabel_284;
    private javax.swing.JLabel jLabel_285;
    private javax.swing.JLabel jLabel_286;
    private javax.swing.JLabel jLabel_287;
    private javax.swing.JLabel jLabel_288;
    private javax.swing.JLabel jLabel_289;
    private javax.swing.JLabel jLabel_290;
    private javax.swing.JLabel jLabel_291;
    private javax.swing.JLabel jLabel_292;
    private javax.swing.JLabel jLabel_293;
    private javax.swing.JLabel jLabel_294;
    private javax.swing.JLabel jLabel_295;
    private javax.swing.JLabel jLabel_296;
    private javax.swing.JLabel jLabel_297;
    private javax.swing.JLabel jLabel_298;
    private javax.swing.JLabel jLabel_299;
    private javax.swing.JLabel jLabel_300;
    private javax.swing.JLabel jLabel_301;
    private javax.swing.JLabel jLabel_302;
    private javax.swing.JLabel jLabel_303;
    private javax.swing.JLabel jLabel_304;
    private javax.swing.JLabel jLabel_305;
    private javax.swing.JLabel jLabel_306;
    private javax.swing.JLabel jLabel_307;
    private javax.swing.JLabel jLabel_308;
    private javax.swing.JLabel jLabel_309;
    private javax.swing.JLabel jLabel_310;
    private javax.swing.JLabel jLabel_311;
    private javax.swing.JLabel jLabel_312;
    private javax.swing.JLabel jLabel_313;
    private javax.swing.JLabel jLabel_314;
    private javax.swing.JLabel jLabel_315;
    private javax.swing.JLabel jLabel_316;
    private javax.swing.JLabel jLabel_317;
    private javax.swing.JLabel jLabel_318;
    private javax.swing.JLabel jLabel_319;
    private javax.swing.JLabel jLabel_320;
    private javax.swing.JLabel jLabel_321;
    private javax.swing.JLabel jLabel_322;
    private javax.swing.JLabel jLabel_323;
    private javax.swing.JLabel jLabel_324;
    private javax.swing.JLabel jLabel_325;
    private javax.swing.JLabel jLabel_326;
    private javax.swing.JLabel jLabel_327;
    private javax.swing.JLabel jLabel_328;
    private javax.swing.JLabel jLabel_329;
    private javax.swing.JLabel jLabel_330;
    private javax.swing.JLabel jLabel_331;
    private javax.swing.JLabel jLabel_332;
    private javax.swing.JLabel jLabel_333;
    private javax.swing.JLabel jLabel_334;
    private javax.swing.JLabel jLabel_335;
    private javax.swing.JLabel jLabel_336;
    private javax.swing.JLabel jLabel_337;
    private javax.swing.JLabel jLabel_338;
    private javax.swing.JLabel jLabel_339;
    private javax.swing.JLabel jLabel_340;
    private javax.swing.JLabel jLabel_342;
    private javax.swing.JLabel jLabel_343;
    private javax.swing.JLabel jLabel_344;
    private javax.swing.JLabel jLabel_345;
    private javax.swing.JLabel jLabel_346;
    private javax.swing.JLabel jLabel_348;
    private javax.swing.JLabel jLabel_349;
    private javax.swing.JLabel jLabel_350;
    private javax.swing.JLabel jLabel_351;
    private javax.swing.JLabel jLabel_352;
    private javax.swing.JLabel jLabel_353;
    private javax.swing.JLabel jLabel_356;
    private javax.swing.JLabel jLabel_358;
    private javax.swing.JLabel jLabel_360;
    private javax.swing.JLabel jLabel_362;
    private javax.swing.JList<String> jList_288;
    private javax.swing.JList<String> jList_356;
    private javax.swing.JList<String> jList_358;
    private javax.swing.JList<String> jList_360;
    private javax.swing.JList<String> jList_362;
    private javax.swing.JPanel jPanelSec_1;
    private javax.swing.JPanel jPanelSec_2;
    private javax.swing.JPanel jPanelSec_3;
    private javax.swing.JPanel jPanelSec_4;
    private javax.swing.JPanel jPanelSec_5;
    private javax.swing.JPanel jPanelSec_6;
    private javax.swing.JPanel jPanel_282;
    private javax.swing.JPanel jPanel_283;
    private javax.swing.JPanel jPanel_284;
    private javax.swing.JPanel jPanel_285;
    private javax.swing.JPanel jPanel_286;
    private javax.swing.JPanel jPanel_287;
    private javax.swing.JPanel jPanel_288;
    private javax.swing.JPanel jPanel_289;
    private javax.swing.JPanel jPanel_290;
    private javax.swing.JPanel jPanel_291;
    private javax.swing.JPanel jPanel_292;
    private javax.swing.JPanel jPanel_293;
    private javax.swing.JPanel jPanel_294;
    private javax.swing.JPanel jPanel_295;
    private javax.swing.JPanel jPanel_296;
    private javax.swing.JPanel jPanel_297;
    private javax.swing.JPanel jPanel_298;
    private javax.swing.JPanel jPanel_299;
    private javax.swing.JPanel jPanel_300;
    private javax.swing.JPanel jPanel_301;
    private javax.swing.JPanel jPanel_302;
    private javax.swing.JPanel jPanel_303;
    private javax.swing.JPanel jPanel_304;
    private javax.swing.JPanel jPanel_305;
    private javax.swing.JPanel jPanel_306;
    private javax.swing.JPanel jPanel_307;
    private javax.swing.JPanel jPanel_308;
    private javax.swing.JPanel jPanel_309;
    private javax.swing.JPanel jPanel_310;
    private javax.swing.JPanel jPanel_311;
    private javax.swing.JPanel jPanel_312;
    private javax.swing.JPanel jPanel_313;
    private javax.swing.JPanel jPanel_314;
    private javax.swing.JPanel jPanel_315;
    private javax.swing.JPanel jPanel_316;
    private javax.swing.JPanel jPanel_317;
    private javax.swing.JPanel jPanel_318;
    private javax.swing.JPanel jPanel_319;
    private javax.swing.JPanel jPanel_320;
    private javax.swing.JPanel jPanel_321;
    private javax.swing.JPanel jPanel_322;
    private javax.swing.JPanel jPanel_323;
    private javax.swing.JPanel jPanel_324;
    private javax.swing.JPanel jPanel_325;
    private javax.swing.JPanel jPanel_326;
    private javax.swing.JPanel jPanel_327;
    private javax.swing.JPanel jPanel_328;
    private javax.swing.JPanel jPanel_329;
    private javax.swing.JPanel jPanel_330;
    private javax.swing.JPanel jPanel_331;
    private javax.swing.JPanel jPanel_332;
    private javax.swing.JPanel jPanel_333;
    private javax.swing.JPanel jPanel_334;
    private javax.swing.JPanel jPanel_335;
    private javax.swing.JPanel jPanel_336;
    private javax.swing.JPanel jPanel_337;
    private javax.swing.JPanel jPanel_338;
    private javax.swing.JPanel jPanel_339;
    private javax.swing.JPanel jPanel_340;
    private javax.swing.JPanel jPanel_341;
    private javax.swing.JPanel jPanel_342;
    private javax.swing.JPanel jPanel_343;
    private javax.swing.JPanel jPanel_344;
    private javax.swing.JPanel jPanel_345;
    private javax.swing.JPanel jPanel_346;
    private javax.swing.JPanel jPanel_347;
    private javax.swing.JPanel jPanel_348;
    private javax.swing.JPanel jPanel_349;
    private javax.swing.JPanel jPanel_350;
    private javax.swing.JPanel jPanel_351;
    private javax.swing.JPanel jPanel_352;
    private javax.swing.JPanel jPanel_353;
    private javax.swing.JPanel jPanel_356;
    private javax.swing.JPanel jPanel_358;
    private javax.swing.JPanel jPanel_360;
    private javax.swing.JPanel jPanel_362;
    private javax.swing.JPanel jPanel_DatosPersonales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rad_1812;
    private javax.swing.JRadioButton rad_1813;
    private javax.swing.JRadioButton rad_1822;
    private javax.swing.JRadioButton rad_1823;
    private javax.swing.JRadioButton rad_1832;
    private javax.swing.JRadioButton rad_1833;
    private javax.swing.JRadioButton rad_1834;
    private javax.swing.JRadioButton rad_1835;
    private javax.swing.JRadioButton rad_2085;
    private javax.swing.JRadioButton rad_2086;
    private javax.swing.JRadioButton rad_2087;
    private javax.swing.JRadioButton rad_2088;
    private javax.swing.JRadioButton rad_2089;
    private javax.swing.JRadioButton rad_2090;
    private javax.swing.JRadioButton rad_2091;
    private javax.swing.JRadioButton rad_2092;
    private javax.swing.JRadioButton rad_2093;
    private javax.swing.JRadioButton rad_2095;
    private javax.swing.JRadioButton rad_2096;
    private javax.swing.JRadioButton rad_2097;
    private javax.swing.JRadioButton rad_2098;
    private javax.swing.JRadioButton rad_2099;
    private javax.swing.JRadioButton rad_2100;
    private javax.swing.JRadioButton rad_2101;
    private javax.swing.JRadioButton rad_2102;
    private javax.swing.JRadioButton rad_2103;
    private javax.swing.JRadioButton rad_2104;
    private javax.swing.JRadioButton rad_2105;
    private javax.swing.JRadioButton rad_2106;
    private javax.swing.JRadioButton rad_2107;
    private javax.swing.JRadioButton rad_2108;
    private javax.swing.JRadioButton rad_2109;
    private javax.swing.JRadioButton rad_2110;
    private javax.swing.JRadioButton rad_2111;
    private javax.swing.JRadioButton rad_2112;
    private javax.swing.JRadioButton rad_2113;
    private javax.swing.JRadioButton rad_2114;
    private javax.swing.JRadioButton rad_2115;
    private javax.swing.JRadioButton rad_2116;
    private javax.swing.JRadioButton rad_2117;
    private javax.swing.JRadioButton rad_2118;
    private javax.swing.JRadioButton rad_2119;
    private javax.swing.JRadioButton rad_2120;
    private javax.swing.JRadioButton rad_2121;
    private javax.swing.JRadioButton rad_2122;
    private javax.swing.JRadioButton rad_2123;
    private javax.swing.JRadioButton rad_2124;
    private javax.swing.JRadioButton rad_2125;
    private javax.swing.JRadioButton rad_2126;
    private javax.swing.JRadioButton rad_2127;
    private javax.swing.JRadioButton rad_2128;
    private javax.swing.JRadioButton rad_2129;
    private javax.swing.JRadioButton rad_2130;
    private javax.swing.JRadioButton rad_2131;
    private javax.swing.JRadioButton rad_2132;
    private javax.swing.JRadioButton rad_2133;
    private javax.swing.JRadioButton rad_2134;
    private javax.swing.JRadioButton rad_2135;
    private javax.swing.JRadioButton rad_2136;
    private javax.swing.JRadioButton rad_2137;
    private javax.swing.JRadioButton rad_2138;
    private javax.swing.JRadioButton rad_2139;
    private javax.swing.JRadioButton rad_2140;
    private javax.swing.JRadioButton rad_2141;
    private javax.swing.JRadioButton rad_2142;
    private javax.swing.JRadioButton rad_2143;
    private javax.swing.JRadioButton rad_2144;
    private javax.swing.JRadioButton rad_2145;
    private javax.swing.JRadioButton rad_2146;
    private javax.swing.JRadioButton rad_2147;
    private javax.swing.JRadioButton rad_2148;
    private javax.swing.JRadioButton rad_2149;
    private javax.swing.JRadioButton rad_2150;
    private javax.swing.JRadioButton rad_2151;
    private javax.swing.JRadioButton rad_2152;
    private javax.swing.JRadioButton rad_2153;
    private javax.swing.JRadioButton rad_2154;
    private javax.swing.JRadioButton rad_2155;
    private javax.swing.JRadioButton rad_2156;
    private javax.swing.JRadioButton rad_2157;
    private javax.swing.JRadioButton rad_2158;
    private javax.swing.JRadioButton rad_2159;
    private javax.swing.JRadioButton rad_2160;
    private javax.swing.JRadioButton rad_2161;
    private javax.swing.JRadioButton rad_2162;
    private javax.swing.JRadioButton rad_2163;
    private javax.swing.JRadioButton rad_2164;
    private javax.swing.JRadioButton rad_2165;
    private javax.swing.JRadioButton rad_2166;
    private javax.swing.JRadioButton rad_2167;
    private javax.swing.JRadioButton rad_2168;
    private javax.swing.JRadioButton rad_2169;
    private javax.swing.JRadioButton rad_2170;
    private javax.swing.JRadioButton rad_2171;
    private javax.swing.JRadioButton rad_2172;
    private javax.swing.JRadioButton rad_2173;
    private javax.swing.JRadioButton rad_2174;
    private javax.swing.JRadioButton rad_2175;
    private javax.swing.JRadioButton rad_2176;
    private javax.swing.JRadioButton rad_2177;
    private javax.swing.JRadioButton rad_2178;
    private javax.swing.JRadioButton rad_2179;
    private javax.swing.JRadioButton rad_2180;
    private javax.swing.JRadioButton rad_2181;
    private javax.swing.JRadioButton rad_2182;
    private javax.swing.JRadioButton rad_2183;
    private javax.swing.JRadioButton rad_2184;
    private javax.swing.JRadioButton rad_2185;
    private javax.swing.JRadioButton rad_2186;
    private javax.swing.JRadioButton rad_2187;
    private javax.swing.JRadioButton rad_2188;
    private javax.swing.JRadioButton rad_2189;
    private javax.swing.JRadioButton rad_2190;
    private javax.swing.JRadioButton rad_2193;
    private javax.swing.JRadioButton rad_2194;
    private javax.swing.JRadioButton rad_2195;
    private javax.swing.JRadioButton rad_2196;
    private javax.swing.JRadioButton rad_2197;
    private javax.swing.JRadioButton rad_2198;
    private javax.swing.JRadioButton rad_2199;
    private javax.swing.JRadioButton rad_2200;
    private javax.swing.JRadioButton rad_2201;
    private javax.swing.JRadioButton rad_2202;
    private javax.swing.JRadioButton rad_2203;
    private javax.swing.JRadioButton rad_2204;
    private javax.swing.JRadioButton rad_2205;
    private javax.swing.JRadioButton rad_2206;
    private javax.swing.JRadioButton rad_2207;
    private javax.swing.JRadioButton rad_2208;
    private javax.swing.JRadioButton rad_2209;
    private javax.swing.JRadioButton rad_2210;
    private javax.swing.JRadioButton rad_2211;
    private javax.swing.JRadioButton rad_2212;
    private javax.swing.JRadioButton rad_2213;
    private javax.swing.JRadioButton rad_2214;
    private javax.swing.JRadioButton rad_2215;
    private javax.swing.JRadioButton rad_2216;
    private javax.swing.JRadioButton rad_2217;
    private javax.swing.JRadioButton rad_2218;
    private javax.swing.JRadioButton rad_2219;
    private javax.swing.JRadioButton rad_2220;
    private javax.swing.JRadioButton rad_2221;
    private javax.swing.JRadioButton rad_2222;
    private javax.swing.JRadioButton rad_2223;
    private javax.swing.JRadioButton rad_2224;
    private javax.swing.JRadioButton rad_2225;
    private javax.swing.JRadioButton rad_2226;
    private javax.swing.JRadioButton rad_2227;
    private javax.swing.JRadioButton rad_2228;
    private javax.swing.JRadioButton rad_2229;
    private javax.swing.JRadioButton rad_2230;
    private javax.swing.JRadioButton rad_2231;
    private javax.swing.JRadioButton rad_2232;
    private javax.swing.JRadioButton rad_2233;
    private javax.swing.JRadioButton rad_2234;
    private javax.swing.JRadioButton rad_2235;
    private javax.swing.JRadioButton rad_2236;
    private javax.swing.JRadioButton rad_2237;
    private javax.swing.JRadioButton rad_2238;
    private javax.swing.JRadioButton rad_2239;
    private javax.swing.JRadioButton rad_2240;
    private javax.swing.JRadioButton rad_2241;
    private javax.swing.JRadioButton rad_2242;
    private javax.swing.JRadioButton rad_2243;
    private javax.swing.JRadioButton rad_2244;
    private javax.swing.JRadioButton rad_2245;
    private javax.swing.JRadioButton rad_2246;
    private javax.swing.JRadioButton rad_2247;
    private javax.swing.JRadioButton rad_2248;
    private javax.swing.JRadioButton rad_2249;
    private javax.swing.JRadioButton rad_2251;
    private javax.swing.JRadioButton rad_2252;
    private javax.swing.JRadioButton rad_2253;
    private javax.swing.JRadioButton rad_2254;
    private javax.swing.JRadioButton rad_2255;
    private javax.swing.JRadioButton rad_2256;
    private javax.swing.JRadioButton rad_2257;
    private javax.swing.JRadioButton rad_2258;
    private javax.swing.JRadioButton rad_2259;
    private javax.swing.JRadioButton rad_2260;
    private javax.swing.JRadioButton rad_2261;
    private javax.swing.JRadioButton rad_2262;
    private javax.swing.JRadioButton rad_2263;
    private javax.swing.JRadioButton rad_2264;
    private javax.swing.JRadioButton rad_2265;
    private javax.swing.JRadioButton rad_2266;
    private javax.swing.JRadioButton rad_2267;
    private javax.swing.JRadioButton rad_2268;
    private javax.swing.JRadioButton rad_2269;
    private javax.swing.JRadioButton rad_2270;
    private javax.swing.JRadioButton rad_2271;
    private javax.swing.JRadioButton rad_2272;
    private javax.swing.JRadioButton rad_2273;
    private javax.swing.JRadioButton rad_2274;
    private javax.swing.JRadioButton rad_2275;
    private javax.swing.JRadioButton rad_2276;
    private javax.swing.JRadioButton rad_2277;
    private javax.swing.JRadioButton rad_2278;
    private javax.swing.JRadioButton rad_2279;
    private javax.swing.JRadioButton rad_2280;
    private javax.swing.JRadioButton rad_2281;
    private javax.swing.JRadioButton rad_2282;
    private javax.swing.JRadioButton rad_2283;
    private javax.swing.JRadioButton rad_2284;
    private javax.swing.JRadioButton rad_2285;
    private javax.swing.JRadioButton rad_2286;
    private javax.swing.JRadioButton rad_2287;
    private javax.swing.JRadioButton rad_2288;
    private javax.swing.JRadioButton rad_2294;
    private javax.swing.JRadioButton rad_2295;
    private javax.swing.JRadioButton rad_2303;
    private javax.swing.JRadioButton rad_2304;
    private javax.swing.JRadioButton rad_2305;
    private javax.swing.JRadioButton rad_2306;
    private javax.swing.JRadioButton rad_2307;
    private javax.swing.JRadioButton rad_2308;
    private javax.swing.JRadioButton rad_2309;
    private javax.swing.JRadioButton rad_2310;
    private javax.swing.JRadioButton rad_2311;
    private javax.swing.JRadioButton rad_2312;
    private javax.swing.JRadioButton rad_2313;
    private javax.swing.JRadioButton rad_2314;
    private javax.swing.JRadioButton rad_2315;
    private javax.swing.JRadioButton rad_2316;
    private javax.swing.JRadioButton rad_2317;
    private javax.swing.JRadioButton rad_2318;
    private javax.swing.JRadioButton rad_2319;
    private javax.swing.JRadioButton rad_2320;
    private javax.swing.JRadioButton rad_2321;
    private javax.swing.JRadioButton rad_2322;
    private javax.swing.JRadioButton rad_2323;
    private javax.swing.JRadioButton rad_2324;
    private javax.swing.JRadioButton rad_2325;
    private javax.swing.JRadioButton rad_2326;
    private javax.swing.JRadioButton rad_2327;
    private javax.swing.JRadioButton rad_2328;
    private javax.swing.JRadioButton rad_2329;
    private javax.swing.JRadioButton rad_2330;
    private javax.swing.JRadioButton rad_2331;
    private javax.swing.JRadioButton rad_2332;
    private javax.swing.JRadioButton rad_2333;
    private javax.swing.JRadioButton rad_2334;
    private javax.swing.JRadioButton rad_2335;
    private javax.swing.JRadioButton rad_2336;
    private javax.swing.JRadioButton rad_2337;
    private javax.swing.JRadioButton rad_2338;
    private javax.swing.JRadioButton rad_2339;
    private javax.swing.JRadioButton rad_2340;
    private javax.swing.JRadioButton rad_2341;
    private javax.swing.JRadioButton rad_2342;
    private javax.swing.JRadioButton rad_2343;
    private javax.swing.JRadioButton rad_2344;
    private javax.swing.JRadioButton rad_2345;
    private javax.swing.JRadioButton rad_2346;
    private javax.swing.JRadioButton rad_2347;
    private javax.swing.JRadioButton rad_2348;
    private javax.swing.JRadioButton rad_2349;
    private javax.swing.JRadioButton rad_2350;
    private javax.swing.JRadioButton rad_2351;
    private javax.swing.JRadioButton rad_2352;
    private javax.swing.JRadioButton rad_2353;
    private javax.swing.JRadioButton rad_2354;
    private javax.swing.JRadioButton rad_2355;
    private javax.swing.JRadioButton rad_2356;
    private javax.swing.JRadioButton rad_2357;
    private javax.swing.JRadioButton rad_2358;
    private javax.swing.JRadioButton rad_2359;
    private javax.swing.JRadioButton rad_2360;
    private javax.swing.JRadioButton rad_2361;
    private javax.swing.JRadioButton rad_2362;
    private javax.swing.JRadioButton rad_2363;
    private javax.swing.JRadioButton rad_2369;
    private javax.swing.JRadioButton rad_2370;
    private javax.swing.JRadioButton rad_2371;
    private javax.swing.JRadioButton rad_2372;
    private javax.swing.JRadioButton rad_2373;
    private javax.swing.JRadioButton rad_2374;
    private javax.swing.JRadioButton rad_2375;
    private javax.swing.JRadioButton rad_2376;
    private javax.swing.JRadioButton rad_2380;
    private javax.swing.JRadioButton rad_2381;
    private javax.swing.JRadioButton rad_2382;
    private javax.swing.JRadioButton rad_2383;
    private javax.swing.JRadioButton rad_2384;
    private javax.swing.JRadioButton rad_2385;
    private javax.swing.JRadioButton rad_2386;
    private javax.swing.JRadioButton rad_2387;
    private javax.swing.JRadioButton rad_2388;
    private javax.swing.JRadioButton rad_2389;
    private javax.swing.JRadioButton rad_2390;
    private javax.swing.JRadioButton rad_2391;
    private javax.swing.JRadioButton rad_2392;
    private javax.swing.JRadioButton rad_2393;
    private javax.swing.JRadioButton rad_2394;
    private javax.swing.JRadioButton rad_2395;
    private javax.swing.JRadioButton rad_2396;
    private javax.swing.JRadioButton rad_2397;
    private javax.swing.JRadioButton rad_2398;
    private javax.swing.JRadioButton rad_2399;
    private javax.swing.JRadioButton rad_2400;
    private javax.swing.JRadioButton rad_2401;
    private javax.swing.JRadioButton rad_2402;
    private javax.swing.JRadioButton rad_2403;
    private javax.swing.JRadioButton rad_2404;
    private javax.swing.JRadioButton rad_2405;
    private javax.swing.JRadioButton rad_2406;
    private javax.swing.JRadioButton rad_2407;
    private javax.swing.JRadioButton rad_2408;
    private javax.swing.JRadioButton rad_2409;
    private javax.swing.JRadioButton rad_2411;
    private javax.swing.JRadioButton rad_2412;
    private javax.swing.JRadioButton rad_2413;
    private javax.swing.JRadioButton rad_2414;
    private javax.swing.JRadioButton rad_2415;
    private javax.swing.JRadioButton rad_2416;
    private javax.swing.JRadioButton rad_2417;
    private javax.swing.JRadioButton rad_2418;
    private javax.swing.JRadioButton rad_2419;
    private javax.swing.JRadioButton rad_2420;
    private javax.swing.JRadioButton rad_2421;
    private javax.swing.JRadioButton rad_2422;
    private javax.swing.JRadioButton rad_2423;
    private javax.swing.JRadioButton rad_2424;
    private javax.swing.JRadioButton rad_2425;
    private javax.swing.JRadioButton rad_2426;
    private javax.swing.JRadioButton rad_2427;
    private javax.swing.JRadioButton rad_2428;
    private javax.swing.JRadioButton rad_2429;
    private javax.swing.JRadioButton rad_2430;
    private javax.swing.JRadioButton rad_2431;
    private javax.swing.JRadioButton rad_2432;
    private javax.swing.JRadioButton rad_2433;
    private javax.swing.JRadioButton rad_2434;
    private javax.swing.JRadioButton rad_2435;
    private javax.swing.JRadioButton rad_2437;
    private javax.swing.JRadioButton rad_2438;
    private javax.swing.JRadioButton rad_2439;
    private javax.swing.JRadioButton rad_2440;
    private javax.swing.JRadioButton rad_2441;
    private javax.swing.JRadioButton rad_2442;
    private javax.swing.JRadioButton rad_2443;
    private javax.swing.JRadioButton rad_2444;
    private javax.swing.JRadioButton rad_2445;
    private javax.swing.JRadioButton rad_2446;
    private javax.swing.JRadioButton rad_2447;
    private javax.swing.JRadioButton rad_2448;
    private javax.swing.JRadioButton rad_2449;
    private javax.swing.JRadioButton rad_2450;
    private javax.swing.JRadioButton rad_2451;
    private javax.swing.JRadioButton rad_2452;
    private javax.swing.JRadioButton rad_2453;
    private javax.swing.JRadioButton rad_2454;
    private javax.swing.JRadioButton rad_2455;
    private javax.swing.JRadioButton rad_2456;
    private javax.swing.JRadioButton rad_2457;
    private javax.swing.JRadioButton rad_2458;
    private javax.swing.JRadioButton rad_2459;
    private javax.swing.JRadioButton rad_2460;
    private javax.swing.JRadioButton rad_2461;
    private javax.swing.JRadioButton rad_2462;
    private javax.swing.JRadioButton rad_2463;
    private javax.swing.JRadioButton rad_2464;
    private javax.swing.JRadioButton rad_2465;
    private javax.swing.JRadioButton rad_2466;
    private javax.swing.JTextField txt_2094;
    private javax.swing.JTextField txt_2191;
    private javax.swing.JTextField txt_2192;
    private javax.swing.JTextField txt_2250;
    private javax.swing.JTextField txt_2467;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables
}
