,ua:sync_conversations","diagnosticEventTime":"1574762486.89,1574762491.578"}}                                                                                                                                                                                                                                                                                                                                                                                                                                                  s]
      self.cache[mabs] = self.cache[abs]
    }
  }

  return m
}

// lotta situps...
function makeAbs (self, f) {
  var abs = f
  if (f.charAt(0) === '/') {
    abs = path.join(self.root, f)
  } else if (isAbsolute(f) || f === '') {
    abs = f
  } else if (self.changedCwd) {
    abs = path.resolve(self.cwd, f)
  } else {
    abs = path.resolve(f)
  }
  return abs
}


// Return true, if pattern ends with globstar '**', for the accompanying parent directory.
// Ex:- If node_modules/** is the pattern, add 'node_modules' to ignore list along with it's contents
function isIgnored (self, path) {
  if (!self.ignore.length)
    return false

  return self.ignore.some(function(item) {
    return item.matcher.match(path) || !!(item.gmatcher && item.gmatcher.match(path))
  })
}

function childrenIgnored (self, path) {
  if (!self.ignore.length)
    return false

  return self.ignore.some(function(item) {
    return !!(item.gmatcher && item.gmatcher.match(path))
  })
}
                                                numvalue);	
				}
				break;
			case BOOLEAN:
			value= Boolean.toString(cl.getBooleanCellValue());
			default:
				System.out.println("cell format is not matching");
				break;
			}		
			
		} catch (EncryptedDocumentException e) {
			System.out.println(e.getClass().getSimpleName());
		}
		catch (IOException e) {
			System.out.println(e.getClass().getSimpleName());
		}
	
	return value;	
		
	}	
	
//********************************WRITE/Update DATA in excel**************************************************************//	
	public void updateSpecificCell(int row_No, String status, int cell_No,String sheetName) {
        try {
        	System.out.println("updateSpecificCell called");
        	
            FileInputStream inputStream = new FileInputStream( new File(filepath));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(row_No);
            if (row == null) {
            	row = sheet.createRow(row_No);
            }
            
            Cell cell2Update = row.getCell(cell_No);
            
            if (cell2Update == null) {
                cell2Update = row.createCell(cell_No);
            }
            cell2Update.setCellValue(status);

            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(filepath);
            workbook.write(outputStream);
            outputStream.close();

        } catch (Exception ex) {
        	System.out.println(ex);
            ex.printStackTrace();
        }
    }
	
	
//******************************Get Row Count method************************************************************//		
	
	// 1. Get sheet method		
		public int getRowCount(String sheetname)
			{
				int rowCount=0;
				
				try
				{
					FileInputStream fis = new FileInputStream(new File(filepath));
					Workbook wb = WorkbookFactory.create(fis);
					Sheet sh = wb.getSheet(sheetname);
					 rowCount = sh.getLastRowNum();
					
					
				}
				catch(EncryptedDocumentException | IOException e)
				{
					
				}
				
				return rowCount;
			}
}
