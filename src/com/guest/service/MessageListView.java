package com.guest.service;

import java.util.List;

import com.guest.model.Message;

public class MessageListView { //p455
	
	private int messageTotalCount;		//전체 메시지 개수
	private int currentPageNumber;		//요청한 페이지 번호
	private List<Message> messageList;  //요청한 페이지의 메시지 목록
	private int pageTotalCount;			//전체 페이지 개수
	private int messageCountPerPage;	//페이지당 보여줄  메시지 개수
	private int firstRow;				
	private int endRow;

	


	public MessageListView(List<Message> messageList, int messageTotalCount,
			int currentPageNumber, int messageCountPerPage,
			int startRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = startRow;
		this.endRow = endRow;
		
		calculatePageTotalCount();
	}
	
	private void calculatePageTotalCount() {
		if(messageTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			if(messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}	

	
	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrntPageNumber() {
		return currentPageNumber;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public boolean isEmpty() {
		return messageTotalCount == 0;
	}	

	
	
	
	@Override
	public String toString() {
		return "MessageListView [messageTotalCount=" + messageTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", messageList=" + messageList + ", pageTotalCount=" + pageTotalCount + ", messageCountPerPage="
				+ messageCountPerPage + ", firstRow=" + firstRow + ", endRow=" + endRow + "]";
	}
	
}
















