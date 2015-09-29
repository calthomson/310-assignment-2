package ca.ubc.cpsc310.gitlab.client;

import java.util.ArrayList;
import java.util.List;

import ca.ubc.cpsc310.gitlab.client.products.ProductItem;
import ca.ubc.cpsc310.gitlab.client.user.IUser;
import ca.ubc.cpsc310.gitlab.client.user.User;
import java.util.List;

import ca.ubc.cpsc310.gitlab.client.service.LoadUsersService;
import ca.ubc.cpsc310.gitlab.client.service.LoadUsersServiceAsync;
import ca.ubc.cpsc310.gitlab.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GitLab implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private final FlexTable flexTable = new FlexTable();

	final LoadUsersServiceAsync service = GWT.create(LoadUsersService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() 
	{
		
		service.getUsers(new AsyncCallback<List<IUser>>(){

			@Override
			public void onFailure(Throwable caught) {
					Window.alert("Error occured " + caught.getClass() + " : " + caught.getMessage());
				
			}
      
      @Override
			public void onSuccess(List<IUser> result) {
				Window.alert("Got list back with " +  result.size() + " entries");
				
			}});

		
	}
	
	/**
	 * Used to display users 
	 * @param users
	 */
	public void displayUsers(List<IUser> users)
	{

		RootPanel.get("root").add(flexTable);
		
		flexTable.setText(0,0, "Name");
		
		flexTable.setText(0,1,"Language");
		flexTable.setText(0,2, "Shopping Cart Size");
		flexTable.setText(0,3, "Wish List Size");
		flexTable.setStyleName("centered-table", true);
		// JASON'S COMMENT
		// JASON'S SECOND COMMENT
		
		for(int i=0; i < users.size(); i++)
		{
			//THIS IS TOTALLY WRONG, BECAUSE I SAID SO
		/*
		.......................................................................................... .........
.......................................................................................... .........
.................................mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm............. .........
.........................mmmmmmmmmmmmmmmm..................................mmmmm.......... .........
...................mmmmmmmmmmm..........mmmmm...............mm................mmm......... .........
.................mmmm............................................mm.............mmm....... .........
..............mmmm....m..mmmmmm............mmm..............mm......m............mmm...... .........
............mmmm.................................................mm....m..........mmm..... .........
...........mmm............mmmmm....................m..........mmm...m....m.........mmm.... .........
..........mm...........m.........................m................mm...m....m.......mmm... .........
..........mm.........m............m..................................m..m....m.......mm... .........
..........mm........m..................................................m..m...........mm.. .........
.........mm..........................................mmmmmmmmmmmmmm...................mmm. .........
........mmm............mmmmmmmm...................mmmmm...mmmmmmmmmmmm.................mmm .........
....mmmm...........mmmmmmmmmmmmmm.............mmmm......mmmmmmmm..mmm..................mmm .......
...mmm...mmmmm.mmm.mmmmmmmmmmmmmmm...........mmm.....mmmmmmmmmmmmmmmmm....m....mmmmmmmm.mm mm.....
..mm...m..................mmmmmmmmmmmmm.......mmmmmmmmm...........mm...m.................. mmm....
.mm..m...mm.....................mmmm...........mmmmm......mmm..............mmmmmmmmmm..... ..mm...
.mm.m..m...mmmmmm................mm.........................mmmm.......mmmmmm......mmmm... .m.mm..
.mmm.....mmmmmmmmmm....m.........mm...........................mmmmmmmmmmm.....mm.....mmm.. .m..mmm
.mmm.....m.......mmmmmmmm........mm...........................................mm......mm.. .m..mmm
.mmm..m.......mm..mmmm........mmmm.........................................mmmmm.......mm. .m...mm
.mm....m......mm...........mmmm................mmmmmmmm................mmmmm...mmmmmm..mm. .m...mm
.mmmm...mm..mmmm..........mmmmm....................mm..............mmmmmm.....mmm.mmm.mmm. .m..mmm
..mm.mm.....mmmm.......mm..mmmmm.........mmmmmmm...mm..........mmmmmmm........mm......mm.. ....mmm
..mmm....m..mm.mmm...m........mmm..............m.mmm......mmmmmmmm.mm.......mmmm.....mm... m..mmm.
...mmm.....mmmmmmmmm............mmmmmm...............mmmmmmmm......mm....mmmmmm.........mm ..mm...
....mmm....mm.mm.mmmmmm...........mmm...........mmmmmmmm..........mmm.mmmmmmmm.......m.... .mmm...
.....mm....mmmm..mm..mmmmmmmm........mmmmmmmmmmmmmm..mm..........mmmmmmm..mmm..........mmm mm.....
.....mm....mmmm..mm....mmmmmmmmmmmmmmmmmmmm..........mm......mmmmmmmm....mmm............mm m......
.....mm....mmmm..mm...mmm.......mm.......mm..........mmm.mmmmmmmmm.mm...mmm...........mmm. .......
.....mm....mmmmmmmm...mm........mm.......mm.........mmmmmmmmmmm....mm..mmm...........mmm.. .......
.....mm....mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm.......mmmmmm............mm... .......
.....mm....mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm.mm...........mmm.............mmm... .......
.....mm.....mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm.......mm.........mmm..............mmm.... .......
.....mm.....mm.mmmmmmmmmmmmmmmmmmmmmmmmmmm.mm..........mmm.....mmmm...............mmm..... .......
.....mm......mm.mm..mm...mm.....mmm........mm...........mm...mmmm...............mmm....... .......
.....mm......mmmmmm.mmm...mm.....mm........mm............mmmmmm................mmm........ .......
.....mm.......mmmm...mmm..mmm....mm........mm.........mmmmmm.......m.....m...mmm.......... .......
.....mm.........mmmmmmmmm..mm....mmm.......mm..mmmmmmmmm........m.....mm...mmmm........... .......
.....mm..............mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm.........mm....mm....mmmm ...............
....mmm........m..........................................m.....mm....mmmmm.. ..............
....mm..........m....................................mm......m.....mmmmm..... ..............
....mm............m..............................mm......mm.....mmmmm........ ..............
..mm.....mm........mmm...........mmmmmmmmmm......mm.......mmmmmm....... ............
.mm.........m.........................mmm............mmmmm...... ........
.mmm..........mmmmmmmmmmmmmmm.....................mmmmm...... ....
.mmm..........................................mmmmm...... ..
..mmm...................................mm.mmmmm....... 
...mmmm............................mmmmmmmmmm........ 
....mmmmm...................mmmmmmmmm.............. 
.......mmmmmmmmmmmmmmmmmmmmmmmm.................... */
			IUser user = users.get(i);
			
			flexTable.setText(i+1,0,user.getName());
			if(user.getLanguage().trim().equals("EN"))
			{
				flexTable.setWidget(i+1, 1, new Image("uk.png"));
			} else if (user.getLanguage().trim().equals("FR"))
			{
				flexTable.setWidget(i+1, 1, new Image("fr.png"));
			} else
			{
				flexTable.setText(i+1,1,user.getLanguage());
			}
			
			flexTable.setText(i+1,2,String.valueOf(user.getShoppingCart().size()));
			
			flexTable.setText(i+1,3,String.valueOf(user.getWishList().size()));
		}
	}
}
