import { CategoryDTO } from './categorydto';
import { ExtensionDTO } from './extensiondto';
import { FolderDTO } from './folderdto';
import { UserDTO } from './userdto';

export class DocumentDTO {
    id: number;
    dataPubblicazione:Date;
    description:string;
    genre:string;
    title:string;
    category:CategoryDTO;
    extension:ExtensionDTO;
    folder:FolderDTO;
    user:UserDTO;
}