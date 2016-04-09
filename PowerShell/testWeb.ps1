$global:ie = New-Object -com "InternetExplorer.Application"
$global:ie.Navigate("about:blank")
$global:ie.visible = $true
. C:\Users\Jake\Desktop\PowerShell\functions.ps1



<#NavigateTo "http://www.google.com/advanced_search" 

SetElementValueByName "as_oq" "Unisys Fenix PLDA"
ClickElementByTagName "input" "14" #>
NavigateTo "http://www.herbal-salvation.com/shop/soap-ingredients/plantation-maeng-da/" 
SetElementValueByName "quantity" "2"
ClickElementByTagName "button" "2" 
