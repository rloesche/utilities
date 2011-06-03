domain	= "dlva"
cn      = "s-deino"


set computer = GetObject("WinNT://" & domain & "/" & cn & ",computer")

computer.filter =Array("service")

for each s in computer
	if s.name = "mf_CCITCP2" then
		wscript.echo(s.name &" : "& s.serviceaccountname)
	end if
next

