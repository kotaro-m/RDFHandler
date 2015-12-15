package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Jaro_Winkler.Distance;
import RDFReader.Reader;
import RDFReader.getRDFNode;
import RDFUpdater.Updater;

public class Main {
	public static void main(String[] args) throws IOException{
		List<String> yn	= new ArrayList<String>(Reader.RDFreader_yn());
		List<String> livedoor	= new ArrayList<String>(Reader.RDFreader_livedoor());
		List<String> sankei	= new ArrayList<String>(Reader.RDFreader_sankei());


		for(int i = 0; i < yn.size(); i++){
			for(int j = 0; j < livedoor.size(); j++){
				if(Distance.J_Distance(yn.get(i),livedoor.get(j) )>0.6 && Distance.J_Distance(yn.get(i),livedoor.get(j)) < 0.8){
					if(getRDFNode.getSubject(yn.get(i)) != null && getRDFNode.getSubject(livedoor.get(j)) != null){
						Updater.RDFUpdater(getRDFNode.getSubject(yn.get(i)), getRDFNode.getURL(getRDFNode.getSubject(livedoor.get(j))));
						Updater.RDFUpdater(getRDFNode.getSubject(livedoor.get(j)), getRDFNode.getURL(getRDFNode.getSubject(yn.get(i))));
					}
				}
			}
		}

		for(int i = 0; i < yn.size(); i++){
			for(int j = 0; j < sankei.size(); j++){
				if(Distance.J_Distance(yn.get(i),sankei.get(j) )>0.6 && Distance.J_Distance(yn.get(i),sankei.get(j)) < 0.8){
					if(getRDFNode.getSubject(yn.get(i)) != null && getRDFNode.getSubject(sankei.get(j)) != null){
						Updater.RDFUpdater(getRDFNode.getSubject(yn.get(i)), getRDFNode.getURL(getRDFNode.getSubject(sankei.get(j))));
						Updater.RDFUpdater(getRDFNode.getSubject(sankei.get(j)), getRDFNode.getURL(getRDFNode.getSubject(yn.get(i))));
					}
				}
			}
		}

		for(int i = 0; i < sankei.size(); i++){
			for(int j = 0; j < livedoor.size(); j++){
				if(Distance.J_Distance(sankei.get(i),livedoor.get(j) )>0.6 && Distance.J_Distance(sankei.get(i),livedoor.get(j)) < 0.8){
					if(getRDFNode.getSubject(sankei.get(i)) != null && getRDFNode.getSubject(livedoor.get(j)) != null){
						Updater.RDFUpdater(getRDFNode.getSubject(sankei.get(i)), getRDFNode.getURL(getRDFNode.getSubject(livedoor.get(j))));
						Updater.RDFUpdater(getRDFNode.getSubject(livedoor.get(j)), getRDFNode.getURL(getRDFNode.getSubject(sankei.get(i))));
					}
				}
			}
		}
	}
}
