package com.techventus.server.voice.datatypes.records;

import com.techventus.server.voice.datatypes.Contact;

import java.util.Date;


/**
 * 
 * @author Tobias Eisentraeger
 *
 */
public class Voicemail extends Record {

	/** The transcript of the voicemail **/
	private Transscript transscript;
	/** The url of the mp3 file with the voicemail **/
	private String mp3Url;
	
	/**
	 * 
	 * @param title
	 * @param date
	 * @param contact
	 * @param transcript
	 */
	public Voicemail(String id, String title, Date date, Contact contact, Transscript transcript, boolean read) {
		super(id, title, date, contact, read);
		this.transscript = transcript;
		this.mp3Url = "https://www.google.com/voice/media/send_voicemail/"+id;
	}
	
	@Override
	public void setId(String id) {
		this.id = id;
		this.mp3Url = "https://www.google.com/voice/media/send_voicemail/"+id;
	}

	/**
	 * @return the transcript
	 */
	public Transscript getTransscript() {
		return transscript;
	}

	/**
	 * @param transcript the transcript to set
	 */
	public void setTransscript(Transscript transcript) {
		this.transscript = transcript;
	}

	/**
	 * @return the mp3Url
	 */
	public String getMp3Url() {
		return mp3Url;
	}

	/**
	 * @param mp3Url the mp3Url to set
	 */
	public void setMp3Url(String mp3Url) {
		this.mp3Url = mp3Url;
	}
	
	
	@Override
	public String toString() {
		String ret = "";
		if(id!=null){
			ret+="id="+id+";";
		}
		if(title!=null){
			ret+="title="+title+";";
		}
		if(date!=null){
			ret+="date="+date+";";
		}
		if(contact!=null){
			ret+="contact="+contact+";";
		}
		if(transscript!=null){
			ret+="transcript="+transscript+";";
		}
		if(mp3Url!=null){
			ret+="mp3Url="+mp3Url+";";
		}
		ret+="read="+read+";";
		return ret;
	}
	
	
	
	

}
