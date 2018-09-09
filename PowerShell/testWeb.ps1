$global:ie = New-Object -com "InternetExplorer.Application"
$global:ie.Navigate("about:blank")
$global:ie.visible = $true
. C:\Users\Jacob\Documents\GitHub\gene-collector\PowerShell\functions.ps1
 


<# 
NavigateTo "http://www.google.com/advanced_search" 
SetElementValueByName "as_oq" "Unisys Fenix PLDA"
SetElementValueByName "as_oq" "Unisys Fenix PLDA"
ClickElementByTagName "input" "14" 
#>

NavigateTo "http://www.herbal-salvation.com/shop/soap-ingredients/green-vein-bali/" 
SetElementValueByName "quantity" "2"
$dropdown = $ie.Document.getElementById("pa_size")
($dropdown | where {$_.innerHTML -eq "100"}).Selected = $true
#SetElementValueByName "attribute_pa_size" "100"
ClickElementByTagName "button" "2" 
