package crawler;
import java.util.HashSet;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Crawler 
{
	
	private HashSet<String>sites;
	private static String busca;
	public Crawler()
	{
		sites = new HashSet<String>();
	
	}
	public static void main(String [] args)
	{
		
		busca =JOptionPane.showInputDialog(null, "Digite o filtro desejado");
		
		new Crawler().crawl("https://www.linkedin.com");
		
	}
	private void crawl (String site)
	{
		if (!sites.contains(site))
		{
			if(site.isEmpty()) 
			{
				
			System.out.println("Site raiz " + site );
			}
			
		else if (sites.add(site)) 
		{
			System.out.println("Site visitado " + site);
		}
			
		try 
		{
			Document doc = Jsoup.connect(site).userAgent("Chrome").get();
			Elements links = doc.select("a[href]");
			Elements imgs = doc.select("img[src]");
			
		for(Element img : imgs) 
		{
			String linkImg =img.attr("src");
			if(linkImg.contains(busca)) {
				System.out.println("Imagem de" + busca.toUpperCase()+ "encontrada:" +  linkImg);
				}
			
			
			}
			for(Element link : links)
			{
			crawl(link.attr("abs:href"));
			}
}			
		catch (Exception e) {
			System.err.println("");
}
		}}}
	
