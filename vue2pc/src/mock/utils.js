export const getParams=(url,name)=>{
  //console.log(url,name);
  const index=url.indexOf('?');
  //console.log(index);
  if(index!==-1){
    const newArr=url.substring(index+1).split('&');
    //console.log(newArr)
    for(var i=0;i<newArr.length;i++){
      const itemArr=newArr[i].split('=');
      //console.log(itemArr)
      if(itemArr[0]==name){
        return itemArr[1];
      }
    }
  }
  return null;

}

export const getData = (body, name) => {
  const data = JSON.parse(body)
  return data[name]
}
