Function ClickElementByTagName($tagName, [int] $position = 0)
{
  if ($global:doc -eq $null) {
    Write-Error "Document is null"
    break
  }
  $elements = @($global:doc.getElementsByTagName($tagName))
  if ($elements.Count -ne 0) {
 $elements[$position].classname
    $elements[$position].Click()
    WaitForPage
  }
  else {
    Write-Error "Couldn't find element ""$tagName"" at position ""$position""";
    break
  }
}

Function ClickElementById($id)
{
  $element = $global:doc.getElementById($id)
  if ($element -ne $null) {
    $element.Click()
    WaitForPage
  }
  else {
    Write-Error "Couldn't find element with id ""$id"""
    break
  }
}

Function ClickElementByName($name, [int] $position = 0)
{
  if ($global:doc -eq $null) {
    Write-Error "Document is null"
    break
  }
  $elements = @($global:doc.getElementsByName($name))
  if ($elements.Count -ne 0) {
    $elements[$position].Click()
    WaitForPage
  }
  else {
    Write-Error "Couldn't find element with name ""$name"" at position ""$position"""
    break
  }
}

Function SetElementValueByName($name, $value, [int] $position = 0) {
  if ($global:doc -eq $null) {
    Write-Error "Document is null";
    break
  }
  $elements = @($global:doc.getElementsByName($name))
  if ($elements.Count -ne 0) {
    $elements[$position].Value = $value
  }
  else {
    Write-Warning "Couldn't find any element with name ""$name""";
  }
}

Function NavigateTo([string] $url, [int] $delayTime = 100)
{
  Write-Verbose "Navigating to $url";
  
  $global:ie.Navigate($url)
  
  WaitForPage $delayTime
}

Function WaitForPage([int] $delayTime = 100)
{
  $loaded = $false
  
  while ($loaded -eq $false) {
    [System.Threading.Thread]::Sleep($delayTime) 
    
    #If the browser is not busy, the page is loaded
    if (-not $global:ie.Busy)
    {
      $loaded = $true
    }
  }
  
  $global:doc = $global:ie.Document
}