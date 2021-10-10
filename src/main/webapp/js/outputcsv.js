	$(function(){
	    $('#csv').click(function(){
	        var d = []
	        var c = []
	        $('table tr').each(function(i, e){
	            var dd = []
	            var cc = []
	            if(i === 0){
	                $(this).find('th').each(function(j, el){
	                    cc.push($(this).text())
	                })
	                c.push(cc)
	            }else{
	                $(this).find('td').each(function(j, el){
	                    dd.push($(this).text())
	                })
	                d.push(dd)
	            }
	        })
	        var m = $.merge(c,d)

	        var bom =  new Uint8Array([0xEF,0xBB,0xBF])

	        var CSV_data = m.map(function(l){
	            return l.join(',')
	        }).join('\r\n')
	        var blob = new Blob([bom, CSV_data],{type: 'text/csv'})
	        var url = (window.URL || window.webkitURL).createObjectURL(blob)
	        var a = document.getElementById('downloader')
	        a.download = 'timesheet.csv'
	        a.href = url
	        $('#downloader')[0].click()
	    })
	})