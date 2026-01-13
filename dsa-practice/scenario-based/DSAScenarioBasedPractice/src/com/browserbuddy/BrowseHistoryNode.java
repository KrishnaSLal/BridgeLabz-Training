package com.browserbuddy;

public class BrowseHistoryNode {
	
	    String url;
	    BrowseHistoryNode prev;
	    BrowseHistoryNode next;

	    BrowseHistoryNode(String url) {
	        this.url = url;
	        this.prev = null;
	        this.next = null;
	    }
	};