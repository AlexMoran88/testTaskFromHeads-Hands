//
//  taskPage.swift
//  TaskFromHH
//
//  Created by john on 12.02.2022.
//

import Foundation


func getSortedArray( amountArrays : Int ) -> String{
    
    var index = 1
    var mainArray : String = " "
    var sortedItemArray : [Int] = []
    var collectionUniqueSizeOfItem = Set(2..<amountArrays+10)
    
    guard amountArrays > 0  else{
        return " "
    }
  
    while index <= amountArrays {
     
        let itemArray = Array(repeating: 0, count: collectionUniqueSizeOfItem.removeFirst())
       
        if index % 2 == 0 {
            sortedItemArray =  itemArray.map{_ in Int.random(in: 1..<100)}.sorted(by: <)
        }else{
            sortedItemArray =  itemArray.map{_ in Int.random(in: 1..<100)}.sorted(by: >)
        }
        mainArray += sortedItemArray.map {"\($0) "}.reduce("[") { $0 + $1} + "]\n"
        index += 1
    }
   
    return mainArray
    
}
