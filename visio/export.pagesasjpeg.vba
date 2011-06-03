Sub exjpeg()
 	Application.ActiveDocument.Save
  Dim ps As Pages
  Dim p As Page
  Path = Application.ActiveDocument.Path
    
  Set ps = Application.ActiveDocument.Pages
  For i = 1 To ps.Count
    ps(i).Export Path + "..\xdocs\images\" + ps(i).Name + ".jpg"
  Next
End Sub